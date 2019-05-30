package com.accenture.technology.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.technology.doc.User;
import com.accenture.technology.exceptions.UsersException;
import com.accenture.technology.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("users")
public class UserController {

	/** SLF4j */
	protected final transient Logger logger = LoggerFactory.getLogger(getClass());
	
	
	private final UserService usersService;
    
	private User user;


    @Autowired
    public UserController(UserService usersService) {
        this.usersService = usersService;
    }


    @RequestMapping(value="/{userId}",method = RequestMethod.GET)
    @ApiOperation(value = "Encuentra usuario", notes = "Retorna usuario por Id" )
    public ResponseEntity<User> userById(@PathVariable String userId)  throws  UsersException{
        logger.info("userById>>> " + userId);

        try{
        	user = usersService.findByUserId(userId);
        }catch(UsersException e){
        	user = null;
        }
        return ResponseEntity.ok(user);
    }


    @RequestMapping(method = RequestMethod.GET)
     public ResponseEntity<List<User>> userById(){
        logger.info("findAll>>>");
        return ResponseEntity.ok(usersService.findAll());

    }


    @RequestMapping(value="/{userId}",method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete an user", notes = "Delete a user by Id")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
    	logger.info("deleteUser>>> " + userId);
        usersService.deleteUser(userId);
        return ResponseEntity.noContent().build();

    }


    @RequestMapping(method=RequestMethod.POST)
    @ApiOperation(value = "Create an user", notes = "Create a new user")
    public  ResponseEntity<User> saveUser(@RequestBody @Valid User user){
    	logger.info("saveUser>>> " + user);
         return ResponseEntity.ok(usersService.saveUser(user));

    }
}

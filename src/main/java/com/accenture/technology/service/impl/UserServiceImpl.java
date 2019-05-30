package com.accenture.technology.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.technology.doc.User;
import com.accenture.technology.exceptions.UsersException;
import com.accenture.technology.repository.UserRepository;
import com.accenture.technology.service.UserService;

/**
 * Implementación del Servicio transaccional para manejar Usuario
 * @author nestrada
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	/** SLF4j */
	protected final transient Logger logger = LoggerFactory.getLogger(getClass());
	

    private UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    
	@Override
	public List<User> findAll() {
		logger.debug("findAll");
        Optional<List<User>> user = userRepository.findAll();
        return user.get();
	}

	@Override
	public User findByUserId(String userId) throws UsersException  {
		logger.debug("findByUserId: " + userId);
		 Optional<User> user = userRepository.findOne(userId);
	        if (user.isPresent()) {
	            logger.debug(String.format("El id del usuario es: ", userId));
	            return user.get();
	        }else
	           throw new UsersException(userId);
	}

	@Override
	public User saveUser(User user) {
		logger.debug("saveUser: " + user);
		return userRepository.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		logger.debug("updateUser: " + user);
		userRepository.updateUser(user);
	}

	@Override
	public void deleteUser(String userId) {
		logger.debug("deleteUser: " + userId);
		userRepository.deleteUser(userId);
	}

}

package com.accenture.technology.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.accenture.technology.doc.User;
import com.accenture.technology.repository.UserRepository;

/**
 * Implementación del Repository
 * @author nestrada
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository{


    private final MongoOperations mongoOperations;


   /**
    * Instancia de la interfaz MongoOperations
    * @param mongoOperations
    */
	@Autowired
    public UserRepositoryImpl(MongoOperations mongoOperations) {
        Assert.notNull(mongoOperations);
        this.mongoOperations = mongoOperations;
    }


    /**
     * Consulta todos los usuarios
     */
    public Optional<List<User>> findAll() {
    	List<User> users = this.mongoOperations.find(new Query(), User.class);
        Optional<List<User>> optionalUsers = Optional.ofNullable(users);
        return optionalUsers;
	}    

    /**
     * Consulta por id del usuario
     * @param userId
     * @return
     */
    public Optional<User> findOne(String userId) {

        User d = this.mongoOperations.findOne(new Query(Criteria.where("id").is(userId)), User.class);
        Optional<User> user = Optional.ofNullable(d);
        return user;
    }


    /**
     * Guardar usuario
     */
    public User saveUser(User user) {
        this.mongoOperations.save(user);
        return findOne(user.getId()).get();
    }

    
    /**
     * Actualizar usuario
     */
    public void updateUser(User user) {
        this.mongoOperations.save(user);
    }


    /**
     * Eliminar usuario
     */
    public void deleteUser(String userId) {
        this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(userId)), User.class);
    }

}
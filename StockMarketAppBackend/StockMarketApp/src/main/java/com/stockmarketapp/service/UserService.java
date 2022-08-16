package com.stockmarketapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockmarketapp.entities.User;
@Service
public interface UserService {

	List<User> getAllUsers();

	User getUserById(String id);

	String save(User user) throws Exception;

	boolean removeUser(String id);

	User modifyUser(String id, User user);

}

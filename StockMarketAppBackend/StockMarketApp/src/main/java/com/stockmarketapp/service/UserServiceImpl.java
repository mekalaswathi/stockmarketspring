package com.stockmarketapp.service;

import com.stockmarketapp.entities.User;
import com.stockmarketapp.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

   @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

   @Override
    public User getUserById(String id) {
        Optional<User> optional = userRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            System.out.println("User not found with id: " + id);
            return null;
        }

    }

   @Override
    public String save(User user) throws Exception {

        userRepository.save(user);
//        String subject = "Your account has been created";
//        String body = "Welcome to FSE Flight booking Application !";
//        String email = user.getEmail();
//        emailUtil.send(email, subject, body);
        return "SuccessFully added";
    }
   @Override
    public User modifyUser(String id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            System.out.println("User not found with id: " + id);
            return null;
        }
    }
   @Override
    public boolean removeUser(String id) {
        userRepository.deleteById(id);
        return true;
    }

//    public boolean ValidateUser(String id, String password) {
//        return userRepository.validateUser(id, password);
//    }
}

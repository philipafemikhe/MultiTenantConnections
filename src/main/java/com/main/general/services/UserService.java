package com.main.general.services;

import com.main.general.entities.User;
import com.main.general.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUser(String userId){
        return this.userRepository.findById(userId).get();
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User updateUser(User user){
        return this.userRepository.save(user);
    }

    public String deleteUser(String id){
        try {
            this.userRepository.deleteById(id);
            return "Record deleted successfully";
        }catch (Exception ex){
            ex.printStackTrace();
            return "Record not found or problem deleting record";
        }
    }
}

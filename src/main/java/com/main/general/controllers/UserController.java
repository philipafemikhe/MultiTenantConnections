package com.main.general.controllers;

import com.main.general.entities.User;
import com.main.general.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/add")
    public User addUser(User user){
        String encodedPsw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPsw);
        return this.userService.createUser(user);
    }

    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable String id){
        return this.userService.getUser(id);
    }

    @RequestMapping("/getUsers")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @RequestMapping(name = "/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id){
        try{
            this.userService.deleteUser(id);
            return "Record deleted successfully";
        }catch(Exception err){
            err.printStackTrace();
            return "Unable to delete record";
        }
    }
}

package com.main.general.services.security;

import com.main.general.entities.User;
import com.main.general.repositories.UserRepository;
import com.main.general.services.security.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        CustomUserDetail userDetail = null;
        if(user != null){
            userDetail = new CustomUserDetail();
            userDetail.setUser(user);
            System.out.println("User details: " + user.toString());
            //create database here for subscriber

        }else{
            throw new UsernameNotFoundException("User not found with username: " + s);
        }
        return userDetail;
    }
}

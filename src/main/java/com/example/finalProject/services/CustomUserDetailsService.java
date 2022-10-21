package com.example.finalProject.services;


import com.example.finalProject.repositories.usersRep.UserRepository;
import com.example.finalProject.segurity.CustomerUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userRepository.findByUsername(username).isPresent()) {
            throw new UsernameNotFoundException("User does not exist");
        }
        return new CustomerUserDetails(userRepository.findByUsername(username).get());
    }
}

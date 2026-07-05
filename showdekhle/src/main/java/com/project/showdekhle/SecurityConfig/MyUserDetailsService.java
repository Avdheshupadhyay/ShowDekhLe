package com.project.showdekhle.SecurityConfig;

import com.project.showdekhle.Models.UserModel;
import com.project.showdekhle.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@ RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel=userRepository.findByName(username);
        if(userModel==null)  throw new UsernameNotFoundException("User not found");
        else {
            return new User(userModel.getName(), userModel.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        }
    }
}

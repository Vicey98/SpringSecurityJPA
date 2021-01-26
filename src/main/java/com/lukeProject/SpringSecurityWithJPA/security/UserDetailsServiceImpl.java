package com.lukeProject.SpringSecurityWithJPA.security;

import java.util.HashSet;
import java.util.Set;

import com.lukeProject.SpringSecurityWithJPA.model.User;
import com.lukeProject.SpringSecurityWithJPA.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private UserRepository userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        super();
        this.userRepo = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Wrong email"));

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    } 
}

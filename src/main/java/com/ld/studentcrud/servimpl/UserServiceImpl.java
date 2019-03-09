package com.ld.studentcrud.servimpl;

import com.ld.studentcrud.domain.User;
import com.ld.studentcrud.respository.UserRepository;
import com.ld.studentcrud.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service(value = "userService")
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findOne(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(s);
        if (user == null)
            throw  new UsernameNotFoundException("Invalid credentials");

        return new org.springframework.security.core.userdetails.User( user.getUserName(), user.getPassword(), getAuthority()) ;
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }


    @Override
    public User save(User user) {

        log.info(user.toString());

        User newUser = User.builder().userName(user.getUserName())
                .password(bCryptPasswordEncoder.encode(user.getPassword())).name(user.getName()).userName(user.getUserName()).build();
        return userRepository.save(newUser);
    }
}

package com.task.productservice.domains.user.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.task.productservice.domains.user.model.User;
import com.task.productservice.domains.user.model.dto.AddUserDTO;
import com.task.productservice.domains.user.model.dto.AuthenticateUserDTO;
import com.task.productservice.domains.user.repository.UserRepository;
import com.task.productservice.domains.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(AddUserDTO addUserDTO) {
        User user = User.builder()
                .userName(addUserDTO.getUsername())
                .password(passwordEncoder.encode(addUserDTO.getPassword()))
                .build();
        userRepository.save(user);
    }

    @Override
    public String authenticateUser(AuthenticateUserDTO authenticateUserDTO) {
        String userName = authenticateUserDTO.getUsername();
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with userName: " + userName));

        if (!passwordEncoder.matches(authenticateUserDTO.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        String secretKey = "_mySecretKey";
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 360000);
         return JWT.create()
                .withSubject(userName)
                 .withIssuedAt(now)
                .withExpiresAt(expiryDate)
                .sign(Algorithm.HMAC256(secretKey));
    }
}


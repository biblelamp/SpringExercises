package com.simplebank.service;

import com.simplebank.domain.EnumStatus;
import com.simplebank.domain.User;
import com.simplebank.domain.UserRole;
import com.simplebank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void add(User user) {
        user.setUserRole(UserRole.CLIENT);
        user.setUserStatus(EnumStatus.ACTIVE);
        userRepository.save(user);
    }
}

package com.iprody.user.profile.service;

import com.iprody.user.profile.controller.dto.UserDTO;
import com.iprody.user.profile.domain.UserProfile;
import com.iprody.user.profile.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapperService mapper;

    public Integer addUser(UserDTO userDTO) {
        UserProfile user = new UserProfile();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user = userRepository.save(user);

        logger.info("Added user, userId: {}", user.getId());
        return user.getId();
    }

    public UserDTO getUserById(Integer id) {
        Optional<UserProfile> user = userRepository.findById(id);
        if (user.isPresent()) {
            return mapper.userToDTO(user.get());
        }

        logger.error("Not found user, userId: {}", id);
        return null;
    }

    public List<UserDTO> getAllUsers() {
        Iterable<UserProfile> users = userRepository.findAll();
        return mapper.userToDTO(users);
    }
}

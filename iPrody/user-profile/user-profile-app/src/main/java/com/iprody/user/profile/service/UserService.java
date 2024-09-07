package com.iprody.user.profile.service;

import com.iprody.user.profile.controller.dto.UserDTO;
import com.iprody.user.profile.domain.UserProfile;
import com.iprody.user.profile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapperService mapper;

    public Integer addUser(UserDTO userDTO) {
        UserProfile user = new UserProfile();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user = userRepository.save(user);
        return user.getId();
    }

    public UserDTO getUserById(Integer id) {
        Optional<UserProfile> user = userRepository.findById(id);
        if (user.isPresent()) {
            return mapper.userToDTO(user.get());
        }
        return null;
    }

    public List<UserDTO> getAllUsers() {
        Iterable<UserProfile> users = userRepository.findAll();
        return mapper.userToDTO(users);
    }
}

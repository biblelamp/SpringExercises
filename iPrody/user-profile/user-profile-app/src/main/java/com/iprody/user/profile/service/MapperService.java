package com.iprody.user.profile.service;

import com.iprody.user.profile.controller.dto.UserDTO;
import com.iprody.user.profile.domain.UserProfile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapperService {

    public UserDTO userToDTO(UserProfile user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());

        return userDTO;
    }

    public List<UserDTO> userToDTO(Iterable<UserProfile> users) {
        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(u -> usersDTO.add(userToDTO(u)));

        return usersDTO;
    }
}

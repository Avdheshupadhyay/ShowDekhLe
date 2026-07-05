package com.project.showdekhle.Service;

import com.project.showdekhle.DTO.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();
}

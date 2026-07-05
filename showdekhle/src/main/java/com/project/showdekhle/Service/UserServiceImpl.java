package com.project.showdekhle.Service;

import com.project.showdekhle.CommonUtils.ConversionUtil;
import com.project.showdekhle.DTO.UserDTO;
import com.project.showdekhle.Models.UserModel;
import com.project.showdekhle.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        if(userDTO==null) return null;
        try {
            String name = ConversionUtil.getStringValue(userDTO.getName());
            String phone = ConversionUtil.getStringValue(userDTO.getPhone());
            String password = ConversionUtil.getStringValue(userDTO.getPassword());
            String created_at = ConversionUtil.getCurrentDateAndTime();
            UserModel userModel = new UserModel();
            userModel.setName(name);
            userModel.setPhone(phone);
            String encodedPassword = passwordEncoder.encode(password);
            userModel.setPassword(encodedPassword);
            userModel.setCreated_at(created_at);
            userRepository.save(userModel);
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserModel> modelList=userRepository.findAll();
        List<UserDTO> userDTOList=new ArrayList<>();
        for(UserModel item:modelList){
            UserDTO userDTO=new UserDTO();
            userDTO.setName(item.getName());
            userDTO.setPassword(item.getPassword());
            userDTO.setPhone(item.getPhone());
            userDTOList.add(userDTO);
        }
        System.out.println(userDTOList);
        return userDTOList;
    }
}


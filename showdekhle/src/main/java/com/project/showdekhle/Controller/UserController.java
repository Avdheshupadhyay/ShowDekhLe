package com.project.showdekhle.Controller;


import com.project.showdekhle.CommonUtils.ApiResponse;
import com.project.showdekhle.DTO.UserDTO;
import com.project.showdekhle.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(new ApiResponse<>("Success",200,userService.getAllUsers()));
    }

}

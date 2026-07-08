package com.project.showdekhle.Controller;

import com.project.showdekhle.CommonUtils.ConversionUtil;
import com.project.showdekhle.DTO.LoginRequest;
import com.project.showdekhle.DTO.LoginResponse;
import com.project.showdekhle.DTO.RefreshTokenRequest;
import com.project.showdekhle.DTO.UserDTO;
import com.project.showdekhle.SecurityConfig.JwtService;
import com.project.showdekhle.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;

    // Register
    @PostMapping("/register")
    public UserDTO register(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    // Login
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        String token = jwtService.generateToken(loginRequest.getUsername());
        String refreshToken = jwtService.generateRefreshToken(loginRequest.getUsername());
        System.out.println(token);

        return new LoginResponse(token,refreshToken);
    }
    @PostMapping("/refershToken")
    public LoginResponse refershToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        String refreshToken= ConversionUtil.getStringValue(refreshTokenRequest.getRefreshToken());
        String username = jwtService.extractUsername(refreshToken);
        boolean isTokenValid=jwtService.isTokenValid(refreshToken,username);
        boolean isTokenExpired=jwtService.isTokenExpired(refreshToken);

        if (isTokenExpired || !isTokenValid) {
            throw new RuntimeException("Invalid Refresh Token");
        }
        String token=jwtService.generateToken(username);
        return new LoginResponse(token,refreshToken);
    }
}
package com.lld.bookmyshow.controllers;

import com.lld.bookmyshow.dto.ResponseStatus;
import com.lld.bookmyshow.dto.SignUpResponseDTO;
import com.lld.bookmyshow.dto.SignupRequestDTO;
import com.lld.bookmyshow.models.User;
import com.lld.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    public SignUpResponseDTO signUp(SignupRequestDTO signupRequestDTO) {
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try {
            User user = userService.signUp(signupRequestDTO.getEmail(), signupRequestDTO.getPassword());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setUserId(user.getId());
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}

package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.UserRequestDTO;
import com.ains.groupit.calculateme.dto.response.UserResponseDTO;
import com.ains.groupit.calculateme.service.UserService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse<Object>> saveUserDetails(@RequestBody UserRequestDTO userRequestDTO) {
        try {
            StandardResponse<Object> updateDetails = userService.saveUser(userRequestDTO);
            return new ResponseEntity<>(updateDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<StandardResponse<Object>> forgotPassword(@RequestParam String mobileNumber) {
        try {
            StandardResponse<Object> updateDetails = userService.forgotPassword(mobileNumber);
            return new ResponseEntity<>(updateDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update-by-mobile")
    public ResponseEntity<StandardResponse<Object>> updateUserDetailsByMobile(
            @RequestParam String mobileNumber,
            @RequestBody UserRequestDTO userRequestDTO
    ) {

        try {
            StandardResponse<Object> updateDetails = userService.updateUserDetailsByMobile(mobileNumber, userRequestDTO);
            return new ResponseEntity<>(updateDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/details")
    public ResponseEntity<StandardResponse<Object>> getUserDetails(
            @RequestParam String password,
            @RequestParam String email) {

        try {
            StandardResponse<Object> userResponseDTO = userService.getUserDetails(password, email);
            return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "User not found or error occurred: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

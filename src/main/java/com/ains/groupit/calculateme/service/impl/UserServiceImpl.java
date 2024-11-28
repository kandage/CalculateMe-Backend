package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.request.UserRequestDTO;
import com.ains.groupit.calculateme.dto.response.UserResponseDTO;
import com.ains.groupit.calculateme.entity.Users;
import com.ains.groupit.calculateme.repository.UsersRepository;
import com.ains.groupit.calculateme.service.UserService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import com.ains.groupit.calculateme.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final UserMapper userMapper;
    private final EmailService emailService;

    @Override
    public StandardResponse<Object> saveUser(UserRequestDTO userRequestDTO) {
        try {
            // Map DTO to Entity
            Users user = userMapper.toEntity(userRequestDTO);

            // Set username as email
            user.setUserFullName(user.getUserEmail());

            // Save user in the repository
            Users savedUser = usersRepository.save(user);

            // Compose email body
            String emailBody = String.format(
                    "Dear %s,\n\nWelcome to our platform! Here are your login details:\n\n" +
                            "Username (Email): %s\nPassword: %s\n\n" +
                            "Thank you,\nCon Cal Team ❤",
                    savedUser.getUserFullName(),
                    savedUser.getUserEmail(),
                    savedUser.getPassword()
            );

            // Send welcome email
            emailService.sendEmail(
                    savedUser.getUserEmail(),
                    "Welcome to Our ConCal Platform!",
                    emailBody
            );

            return new StandardResponse<>(
                    HttpStatus.OK.value(),
                    "User saved and email sent successfully",
                    savedUser
            );

        } catch (Exception e) {
            return new StandardResponse<>(
                    HttpStatus.BAD_REQUEST.value(),
                    "Error saving user or sending email: " + e.getMessage()
            );
        }
    }

    @Override
    public StandardResponse<Object> forgotPassword(String mobileNumber) {
        try {
            // Find user by mobile number
            Users user = usersRepository.findByUserMobile(mobileNumber)
                    .orElseThrow(() -> new IllegalArgumentException("No user found with the provided mobile number"));

            // Compose email body
            String emailBody = String.format(
                    "Dear %s,\n\nHere are your account details:\n\n" +
                            "Username (Email): %s\nPassword: %s\n\n" +
                            "If you did not request this, please ignore this email.\n\n" +
                            "Thank you,\nCon Cal Team ❤",
                    user.getUserFullName(),
                    user.getUserEmail(),
                    user.getPassword()
            );

            // Send account details email
            emailService.sendEmail(
                    user.getUserEmail(),
                    "Your Account Details",
                    emailBody
            );

            return new StandardResponse<>(
                    HttpStatus.OK.value(),
                    "User details sent successfully to the registered email address.",
                    null
            );

        } catch (IllegalArgumentException e) {
            return new StandardResponse<>(HttpStatus.NOT_FOUND.value(), e.getMessage());
        } catch (Exception e) {
            return new StandardResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error occurred while processing your request: " + e.getMessage()
            );
        }
    }

    @Override
    public StandardResponse<Object> updateUserDetailsByMobile(String mobileNumber, UserRequestDTO userRequestDTO) {
        try {
            // Find user by mobile number
            Users existingUser = usersRepository.findByUserMobile(mobileNumber)
                    .orElseThrow(() -> new IllegalArgumentException("No user found with the provided mobile number"));

            // Update user details based on input
            if (userRequestDTO.getUserFullName() != null) {
                existingUser.setUserFullName(userRequestDTO.getUserEmail());
            }
            if (userRequestDTO.getUserEmail() != null) {
                existingUser.setUserEmail(userRequestDTO.getUserEmail());
            }
            if (userRequestDTO.getUserAddress() != null) {
                existingUser.setUserAddress(userRequestDTO.getUserAddress());
            }
            if (userRequestDTO.getPassword() != null) {
                existingUser.setPassword(userRequestDTO.getPassword());
            }

            // Save updated user details
            Users updatedUser = usersRepository.save(existingUser);

            // Compose email body
            String emailBody = String.format(
                    "Dear %s,\n\nYour details have been updated successfully. Here are your updated details:\n\n" +
                            "Username (Email): %s\nPassword: %s\n\n" +
                            "Thank you,\nCon Cal Team ❤",
                    updatedUser.getUserFullName(),
                    updatedUser.getUserEmail(),
                    updatedUser.getPassword()
            );

            // Send email notification
            emailService.sendEmail(updatedUser.getUserEmail(), "Your Details Have Been Updated", emailBody);

            return new StandardResponse<>(
                    HttpStatus.OK.value(),
                    "User details updated and email sent successfully",
                    updatedUser
            );

        } catch (IllegalArgumentException e) {
            return new StandardResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage()
            );
        } catch (Exception e) {
            return new StandardResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error occurred while updating user details: " + e.getMessage()
            );
        }
    }

    @Override
    public StandardResponse<Object> getUserDetails(String password, String email) {
        try {
            Users user = usersRepository.findByPasswordAndUserEmail(password, email)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            UserResponseDTO userResponseDTO = userMapper.toResponseDTO(user);

            return new StandardResponse<>(
                    HttpStatus.OK.value(),
                    "User details fetched successfully!",
                    userResponseDTO
            );
        } catch (IllegalArgumentException e) {
            return new StandardResponse<>(HttpStatus.NOT_FOUND.value(), e.getMessage());
        } catch (Exception e) {
            return new StandardResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error occurred while fetching user details: " + e.getMessage()
            );
        }
    }
}

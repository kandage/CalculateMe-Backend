package com.ains.groupit.calculateme.service.impl;

import com.ains.groupit.calculateme.dto.request.UserRequestDTO;
import com.ains.groupit.calculateme.entity.Users;
import com.ains.groupit.calculateme.repository.UsersRepository;
import com.ains.groupit.calculateme.service.UserService;
import com.ains.groupit.calculateme.util.common.StandardResponse;
import com.ains.groupit.calculateme.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final UserMapper userMapper;
    private final EmailService emailService;

    @Override
    public StandardResponse<Object> saveUser(UserRequestDTO userRequestDTO) {
        try {
            Users user = userMapper.toEntity(userRequestDTO);

            Users savedUser = usersRepository.save(user);

            String emailBody = String.format(
                    "Dear %s,\n\nWelcome to our platform! Here are your Log in details:\n\n" +
                            "UserName: %s\nEmail: %s\nMobile: %s\nAddress: %s\n\n" +
                            "Thank you,\n Con Cal Team ❤",
                    savedUser.getUserFirstName(),
                    savedUser.getUserFirstName(),
                    savedUser.getUserEmail(),
                    savedUser.getUserMobile(),
                    savedUser.getUserAddress()
            );

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
            // Handle exception and return failure response
            return new StandardResponse<>(
                    HttpStatus.BAD_REQUEST.value(),
                    "Error saving user or sending email: " + e.getMessage()
            );
        }
    }
    @Override
    public StandardResponse<Object> forgotPassword(String mobileNumber) {
        try {
            // Search for the user by mobile number
            Users user = usersRepository.findByUserMobile(mobileNumber)
                    .orElseThrow(() -> new IllegalArgumentException("No user found with the provided mobile number"));

            // Construct email body with user details
            String emailBody = String.format(
                    "Dear %s,\n\nIt seems you have requested to retrieve your account details.\n\n" +
                            "Here are your details:\n" +
                            "UserName: %s\nEmail: %s\nMobile: %s\nAddress: %s\n\n" +
                            "If you did not request this, please ignore this email.\n\n" +
                            "Thank you,\n Con Cal Team ",
                    user.getUserFirstName(),
                    user.getUserFirstName(),
                    user.getUserEmail(),
                    user.getUserMobile(),
                    user.getUserAddress()      
            );

            // Send email with the user details
            emailService.sendEmail(
                    user.getUserEmail(),
                    "Your Account Details",
                    emailBody
            );

            // Return a success response
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
            Users existingUser = usersRepository.findByUserMobile(mobileNumber)
                    .orElseThrow(() -> new IllegalArgumentException("No user found with the provided mobile number"));

            if (userRequestDTO.getUserFirstName() != null) {
                existingUser.setUserFirstName(userRequestDTO.getUserFirstName());
            }
            if (userRequestDTO.getUserLastName() != null) {
                existingUser.setUserLastName(userRequestDTO.getUserLastName());
            }
            if (userRequestDTO.getUserEmail() != null) {
                existingUser.setUserEmail(userRequestDTO.getUserEmail());
            }
            if (userRequestDTO.getUserAddress() != null) {
                existingUser.setUserAddress(userRequestDTO.getUserAddress());
            }

            Users updatedUser = usersRepository.save(existingUser);

            String emailBody = String.format(
                    "Dear %s,\n\nYour details have been updated successfully. Here are your updated details:\n\n" +
                            "First Name: %s\nLast Name: %s\nEmail: %s\nMobile: %s\nAddress: %s\n\n" +
                            "Thank you,\nTeam",
                    updatedUser.getUserFirstName(),
                    updatedUser.getUserFirstName(),
                    updatedUser.getUserLastName(),
                    updatedUser.getUserEmail(),
                    updatedUser.getUserMobile(),
                    updatedUser.getUserAddress()
            );

            // Send email to the user
            emailService.sendEmail(updatedUser.getUserEmail(), "Your Details Have Been Updated", emailBody);

            // Return success response
            return new StandardResponse<>(
                    HttpStatus.OK.value(),
                    "User details updated and email sent successfully",
                    updatedUser
            );

        } catch (IllegalArgumentException e) {
            // Handle user not found
            return new StandardResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage()
            );
        } catch (Exception e) {
            // Handle other errors
            return new StandardResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error occurred while updating user details: " + e.getMessage()
            );
        }
    }


}

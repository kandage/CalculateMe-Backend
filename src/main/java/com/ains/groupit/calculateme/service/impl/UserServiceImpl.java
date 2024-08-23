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
    private final UserMapper userMapper ;

    @Override
    public StandardResponse<Object> saveUser(UserRequestDTO userRequestDTO) {
        try {
            Users user = userMapper.toEntity(userRequestDTO);
            Users savedUser = usersRepository.save(user);
            return new StandardResponse<>(HttpStatus.OK.value(), "User saved successfully", savedUser);

        } catch (Exception e) {
            return new StandardResponse<>(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }
}

package com.ains.groupit.calculateme.service;

import com.ains.groupit.calculateme.dto.request.UserRequestDTO;
import com.ains.groupit.calculateme.util.common.StandardResponse;

public interface UserService {
    StandardResponse<Object> saveUser(UserRequestDTO userRequestDTO);
}


package com.ains.groupit.calculateme.util.mapper;

import com.ains.groupit.calculateme.dto.request.UserRequestDTO;
import com.ains.groupit.calculateme.dto.response.UserResponseDTO;
import com.ains.groupit.calculateme.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Users toEntity(UserRequestDTO dto);

    UserRequestDTO toDTO(Users entity);

    UserResponseDTO toResponseDTO(Users entity);

}

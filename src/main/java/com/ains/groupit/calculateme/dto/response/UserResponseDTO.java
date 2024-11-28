package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private String userFullName;
    private String userAddress;
    private String userEmail;
    private String userMobile;
}

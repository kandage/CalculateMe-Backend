package com.ains.groupit.calculateme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userAddress;
    private String userMobile;
}

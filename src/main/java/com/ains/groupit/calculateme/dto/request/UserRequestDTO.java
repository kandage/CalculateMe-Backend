package com.ains.groupit.calculateme.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private String userFirstName;
    private String userLastName;
    private String userAddress;
    private String userEmail;
    private String userMobile;
}

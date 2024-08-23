package com.ains.groupit.calculateme.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Embeddable
public class UsersPk {
    private String userEmail;
    private String userMobile;
}

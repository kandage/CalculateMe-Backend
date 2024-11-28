package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUserMobile(String mobileNumber);

    Optional<Users> findByUserFirstNameAndUserEmail(String firstName, String email);
}

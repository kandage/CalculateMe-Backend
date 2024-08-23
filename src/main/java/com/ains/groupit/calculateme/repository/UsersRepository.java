package com.ains.groupit.calculateme.repository;

import com.ains.groupit.calculateme.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}

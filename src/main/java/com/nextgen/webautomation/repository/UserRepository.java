package com.nextgen.webautomation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextgen.webautomation.entiry.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
package com.nextgen.webautomation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextgen.webautomation.entiry.Demo;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Integer> {

}
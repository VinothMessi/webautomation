package com.nextgen.webautomation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextgen.webautomation.entiry.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
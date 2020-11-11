package com.nextgen.webautomation.testcases;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.nextgen.webautomation.base.TestBase;
import com.nextgen.webautomation.entiry.Payment;
import com.nextgen.webautomation.repository.PaymentRepository;

public class Sanity extends TestBase {
	
	@Autowired
	private PaymentRepository repository;
	
	@Test
	public void test() {
		Map<Integer, String> firstName = this.repository.findAll().stream().collect(Collectors.toMap(Payment::getId, Payment::getFirstName));
		System.out.println(firstName.get(1));
	}

}
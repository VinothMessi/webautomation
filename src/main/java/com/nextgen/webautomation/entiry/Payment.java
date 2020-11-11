package com.nextgen.webautomation.entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	private Integer id;

	private String firstName;
	private String lastName;

	@Column(name = "user_email")
	private String email;

	private String ccBank;
	private String yearAccount;
	private String pin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCcBank() {
		return ccBank;
	}

	public void setCcBank(String ccBank) {
		this.ccBank = ccBank;
	}

	public String getYearAccount() {
		return yearAccount;
	}

	public void setYearAccount(String yearAccount) {
		this.yearAccount = yearAccount;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

}
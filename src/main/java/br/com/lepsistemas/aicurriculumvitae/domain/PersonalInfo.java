package br.com.lepsistemas.aicurriculumvitae.domain;

import static java.time.format.DateTimeFormatter.ofPattern;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonalInfo implements Domain {

	private String name;
	private String city;
	private String state;
	private String country;
	private String address;
	private String phone;
	private String email;
	@JsonFormat(pattern = "YYYY-MM-dd")
	private LocalDate birth;
	private String nationality;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append(name)
				.append(" lives in ")
				.append(address)
				.append(", ")
				.append(city)
				.append(" - ")
				.append(state)
				.append(", ")
				.append(country)
				.append(". His phone number is ")
				.append(phone)
				.append(". You can also be in touch by e-mail, which is ")
				.append(email)
				.append(". Date birth is ")
				.append(birth.format(ofPattern("MM/dd/YYYY")))
				.append(" and his nationality is ")
				.append(nationality)
				.append(".")
				.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj);
	}

}

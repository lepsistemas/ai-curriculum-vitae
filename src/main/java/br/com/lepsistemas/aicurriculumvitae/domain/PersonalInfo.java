package br.com.lepsistemas.aicurriculumvitae.domain;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class PersonalInfo implements Domain {

	private String name;
	private String city;
	private String state;
	private String country;
	private String address;
	private String phone;
	private String email;
	private Date birth;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public Integer getAge() {
		LocalDate today = LocalDate.now();
		Calendar cal = Calendar.getInstance();
		cal.setTime(birth);
		LocalDate birthday = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		Period p = Period.between(birthday, today);
		return p.getYears();
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
				.append(". He is ")
				.append(getAge())
				.append(" years old and his nationality is ")
				.append(nationality)
				.append(".")
				.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj);
	}

}

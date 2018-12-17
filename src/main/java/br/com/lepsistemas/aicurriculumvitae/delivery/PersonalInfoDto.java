package br.com.lepsistemas.aicurriculumvitae.delivery;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lepsistemas.aicurriculumvitae.domain.PersonalInfo;

public class PersonalInfoDto {
	
	private String name;
	private String city;
	private String state;
	private String country;
	private String address;
	private String phone;
	private String email;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date birth;
	private String nationality;
	
	public PersonalInfoDto(PersonalInfo personalInfo) {
		this.name = personalInfo.getName();
		this.city = personalInfo.getCity();
		this.state = personalInfo.getState();
		this.country = personalInfo.getCountry();
		this.address = personalInfo.getAddress();
		this.phone = personalInfo.getPhone();
		this.email = personalInfo.getEmail();
		this.birth = personalInfo.getBirth();
		this.nationality = personalInfo.getNationality();
	}

	public String getName() {
		return name;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getBirth() {
		return birth;
	}
	
	public String getNationality() {
		return nationality;
	}

}

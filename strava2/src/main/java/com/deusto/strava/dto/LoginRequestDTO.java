package com.deusto.strava.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String email;

    public LoginRequestDTO(String email) {
        this.email = email;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}

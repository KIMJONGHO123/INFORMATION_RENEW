package com.example.demo.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	private String username;		//유저ID
	private String password;	//패스워드
	private String role;

}

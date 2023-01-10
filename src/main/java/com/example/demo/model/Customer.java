package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customerregister")

public class Customer {
	
	@Id
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer	id;
	private String firstName;
	private String lastName;
	private String sex;
	private String skill;
	private String userName;
	private String email;
	private String address;
	private String address2;
	private String city;
	private String state;
	private String pincode;

}

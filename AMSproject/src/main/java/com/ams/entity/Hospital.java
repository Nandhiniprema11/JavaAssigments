package com.ams.entity;

import jakarta.persistence.Column;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Hospital {
	@JsonIgnore	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hosid;
	
	@Column
	private String hosname;
	private String hosadd;
	private String hoscon;
	
		
}



package com.jsp.hibernate_many_to_one_Uni_mapping.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//to remove unwanted code ctrl+shift+O
@Entity
@Table(name="indiancompetition")// to change the name of the table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //it will generate the id automatically.
	private int competitionId;
	
	@Column(nullable = false) //now it won't be null. if it will null data will not be save in the database.
	private String competitionName;
	private int competitionYear;
	private String sponsorsName;
	
	@Transient //it will stop the compiler to create the column of particular name. 
	private String competitionChairman;
}

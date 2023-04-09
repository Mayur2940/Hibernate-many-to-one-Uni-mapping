package com.jsp.hibernate_many_to_one_Uni_mapping.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="myteam")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teams {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;
	private String teamName;
	private String teamCaptain;
	private int teamSize;
	private String teamCoach;
	
	@ManyToOne
	@JoinColumn (name = "competitonId") // it will generate the foreign key name according to name given.
	private Competition competition;
	
}

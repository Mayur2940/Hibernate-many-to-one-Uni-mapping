package com.jsp.hibernate_many_to_one_Uni_mapping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_many_to_one_Uni_mapping.dto.Competition;
import com.jsp.hibernate_many_to_one_Uni_mapping.dto.Teams;

public class TeamsDao {
	
	EntityManager entityManager = Persistence.createEntityManagerFactory("mayur").createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	//save method
	public Teams saveTeamsCompetition(Teams teams , int competitionId) {
		
		Competition competition = entityManager.find(Competition.class, competitionId);
		
		if(competition != null) {
			
			teams.setCompetition(competition);
			entityTransaction.begin();
			entityManager.persist(teams);
			entityTransaction.commit();
			
		}
		return teams;
	}
	
	//get By Id
	public Teams getById(int teamsId)
	{
		Teams teams = entityManager.find(Teams.class, teamsId);
		
		if(teams != null) {
			return teams;
		}
		else {
			
			return null; 
		}
	}
	
	
	//delete teams
	public void deleteTeam(int teamsId) {
		Teams teams = entityManager.find(Teams.class, teamsId);
		
		if(teams != null) {
			entityTransaction.begin();
			entityManager.remove(teams);
			entityTransaction.commit();
			
			System.out.println("!!!!!!!!DATA!!!!DELETED!!!!!");
		}
	}
	
	//update teams
	public void updateTeamsCompetition(int teamsId , int competitionYear , String teamsCaptain)
	{
		Teams teams = entityManager.find(Teams.class, teamsId);
		
		if(teams != null) {
			teams.setTeamCaptain(teamsCaptain);
			
			Competition competition = teams.getCompetition();
			
			if(competition != null)
			{
				competition.setCompetitionYear(competitionYear);
			}
			
			entityTransaction.begin();
			entityManager.merge(teams);
			entityTransaction.commit();
			
			System.out.println("-------Data---Updated-----");
		}
	}
	
	
	//display
	public List<Teams> displayTeamsCompetition()
	{
		String displayQuery = "SELECT t FROM Teams t";
		
		Query query = entityManager.createQuery(displayQuery);
		
		List<Teams> list = query.getResultList();
		return list;
		
		
		
	}
}

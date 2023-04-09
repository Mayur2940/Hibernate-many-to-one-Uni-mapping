package com.jsp.hibernate_many_to_one_Uni_mapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate_many_to_one_Uni_mapping.dto.Competition;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

public class CompetitionDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("mayur").createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//save competition
	public void saveCompetition( Competition competition)
	{
		entityTransaction.begin();
		entityManager.persist(competition);
		entityTransaction.commit();
		
		System.out.println("-----DATA-----SAVED----");
	}
	
	//getById competition
	public Competition getById(int competitionId) 
	{
		Competition competition = entityManager.find(Competition.class, competitionId);
		
		if(competition != null) {
			
			return competition;
		}
		else 
		{
			return null;
		}
		
	}
	
	//Update
	public void updateCompetition(int competitionId, String sponsorName)
	{
		Competition competition = entityManager.find(Competition.class, competitionId);
		
		competition.setSponsorsName(sponsorName);
		
		entityTransaction.begin();
		entityManager.merge(competition);
		entityTransaction.commit();
		
		System.out.println("-----DATA-----UPDATED----");
	}
	
	//delete
	public void deleteCompetition(int id) 
	{
		Competition competition = entityManager.find(Competition.class, id);
		
		entityTransaction.begin();
		entityManager.remove(competition);
		entityTransaction.commit();
		
		System.out.println("-----Data----Deleted-----");
	}
}

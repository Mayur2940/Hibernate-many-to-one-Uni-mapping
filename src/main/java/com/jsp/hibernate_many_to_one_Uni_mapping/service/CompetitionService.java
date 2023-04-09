package com.jsp.hibernate_many_to_one_Uni_mapping.service;

import com.jsp.hibernate_many_to_one_Uni_mapping.dao.CompetitionDao;
import com.jsp.hibernate_many_to_one_Uni_mapping.dto.Competition;

public class CompetitionService {

	CompetitionDao competitionDao = new CompetitionDao();
	
	//save competiton
		public void saveCompetition( Competition competition)
		{
			competitionDao.saveCompetition(competition);
		}
		
		//getById competition
		public Competition getById(int competitionId) 
		{
			return competitionDao.getById(competitionId);
		}
		
		//Update
		public void updateCompetition(int competitionId, String sponsorName)
		{
			Competition competition = competitionDao.getById(competitionId);
			
			if(competition != null )
			{
				competitionDao.updateCompetition(competitionId, sponsorName);
			}
			else
			{
				System.err.println("Please check the id");
			}
		}
		
		//delete
		public void deleteCompetition(int id) 
		{
			Competition competition = competitionDao.getById(id);
			
			if(competition != null) {
				competitionDao.deleteCompetition(id);
			}
			else
			{
				System.err.println("Please check the Id");
			}
		}
}

package com.jsp.hibernate_many_to_one_Uni_mapping.service;

import java.util.List;

import com.jsp.hibernate_many_to_one_Uni_mapping.dao.TeamsDao;
import com.jsp.hibernate_many_to_one_Uni_mapping.dto.Teams;

public class TeamsService {

	TeamsDao teamsDao = new TeamsDao();
	
	//save method
		public Teams saveTeamsCompetition(Teams teams , int competitionId) {
			
			return teamsDao.saveTeamsCompetition(teams, competitionId);	
		}
		
		//get By Id
		public Teams getById(int teamsId)
		{
			return teamsDao.getById(teamsId);
		}
		
		//delete teams
		public void deleteTeam(int teamsId) 
		{
			Teams teams = teamsDao.getById(teamsId);
			
			if(teams != null) {
				teamsDao.deleteTeam(teamsId);
			}
			else
			{
				System.err.println("Check the Id You have inserted ");
			}
		}
		
		//update teams
		public void updateTeamsCompetition(int teamsId , int competitionYear , String teamsCaptain)
		{
			Teams teams = teamsDao.getById(teamsId);
			
			if( teams != null) {
				teamsDao.updateTeamsCompetition(teamsId, competitionYear, teamsCaptain);
			}
			else
			{
				System.err.println("Check The Id");
			}
		}
		
		//display
		public List<Teams> displayTeamsCompetition()
		{
			return teamsDao.displayTeamsCompetition();
		}
}

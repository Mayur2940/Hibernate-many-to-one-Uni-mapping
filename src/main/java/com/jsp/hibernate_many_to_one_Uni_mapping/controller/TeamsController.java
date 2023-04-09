package com.jsp.hibernate_many_to_one_Uni_mapping.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_many_to_one_Uni_mapping.dto.Competition;
import com.jsp.hibernate_many_to_one_Uni_mapping.dto.Teams;
import com.jsp.hibernate_many_to_one_Uni_mapping.service.TeamsService;

public class TeamsController {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TeamsService teamsService = new TeamsService();
		
		for(;;) {
			
			System.out.println("1.Insert \n2. GetById \n3. Delete \n4. Update \n5. Display");
			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();
			
			switch(ch) {
			
			case 1: {
				
				Teams teams = new Teams();
				
				System.out.println("Enter the Competition Id");
				int competitonId = sc.nextInt();
				
				System.out.println("Enter the team name");
				String name = sc.next();
				name += sc.nextLine();
				teams.setTeamName(name);
				
				System.out.println("ENter the team captain name");
				teams.setTeamCaptain(sc.next());
				
				System.out.println("Enter the team size");
				teams.setTeamSize(sc.nextInt());
				
				System.out.println("Enter the team Coach");
				String coach = sc.next();
				name += sc.nextLine();
				
				teams.setTeamCoach(coach);
				
				teamsService.saveTeamsCompetition(teams, competitonId);
		
			}break;
			
			case 2: {
				
				System.out.println("Enter the Team Id");
				int id = sc.nextInt();
				
				Teams teams = teamsService.getById(id);
				
				System.out.println("---------Team-----Details------");
				System.out.println("Team Id = "+teams.getTeamId());
				System.out.println("Team name = "+teams.getTeamName());
				System.out.println("Team Captain = "+teams.getTeamCaptain());
				System.out.println("Team Size = "+teams.getTeamSize());
				System.out.println("Team Coach = "+teams.getTeamCoach());
				
				System.out.println("------Competition----Details------");
				System.out.println("Competition Id = "+teams.getCompetition().getCompetitionId());
				System.out.println("Competition Name = "+teams.getCompetition().getCompetitionName());
				System.out.println("Competition Year = "+teams.getCompetition().getCompetitionYear());
				System.out.println("Competition Spnosor Name = "+teams.getCompetition().getSponsorsName());
				
			}break;
			
			case 3: {
				System.out.println("Enter the Team Id which you want to delete");
				int id = sc.nextInt();
				
				teamsService.deleteTeam(id);
			}break;
			
			case 4: {
				System.out.println("Enter the Teams Id");
				int id = sc.nextInt();
				
				System.out.println("MAke competition year as a Currrent Year");
				int year = LocalDateTime.now().getYear();
				
				System.out.println("Enter the Updated Name");
				String captain = sc.next();
				captain += sc.nextLine();
				
				teamsService.updateTeamsCompetition(id, year, captain);
			}break;
			
			case 5: {
				List<Teams> list = teamsService.displayTeamsCompetition();
				
				for (Teams teams : list) {
					
					System.out.println("------Teams------Details");
					System.out.println("Team Id = "+teams.getTeamId());
					System.out.println("Team Name = "+teams.getTeamName());
					System.out.println("Team Captain = "+teams.getTeamCaptain());
					System.out.println("Team Coach = "+teams.getTeamCoach());
					System.out.println("Team Size = "+teams.getTeamSize());
					
					System.out.println("--------Competition-----Details-----");
					
					System.out.println("Competition Id = "+teams.getCompetition().getCompetitionId());
					System.out.println("Competition Name = "+teams.getCompetition().getCompetitionName());
					System.out.println("Competition Year = "+teams.getCompetition().getCompetitionYear());
					System.out.println("Competition Sponsor Name = "+teams.getCompetition().getSponsorsName());
					
				}
			}break;
			}
		}
	}
}

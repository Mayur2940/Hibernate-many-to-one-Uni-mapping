package com.jsp.hibernate_many_to_one_Uni_mapping.controller;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.jsp.hibernate_many_to_one_Uni_mapping.dto.Competition;
import com.jsp.hibernate_many_to_one_Uni_mapping.service.CompetitionService;

public class CompetitionController {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		CompetitionService competitionService = new CompetitionService();
		
		for(;;) {
			
			System.out.println("1.Insert \n2.getById \n3. Update \n4. Delete ");
			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();
			
			switch(ch) {
			
			case 1: {
				
				Competition competition = new Competition();
				
				System.out.println("Enter the Competition Name");
				String name = sc.next();
				name += sc.nextLine();
				
				competition.setCompetitionName(name);
				
				int year = LocalDateTime.now().getYear();
				competition.setCompetitionYear(year);
				
				System.out.println("Enter the Sponsors Name");
				String sponsor = sc.next();
				sponsor += sc.nextLine();
				
				competition.setSponsorsName(sponsor);
				
				System.out.println("Enter the Chairman Name");
				String chairman = sc.next();
				chairman += sc.nextLine();
				
				competition.setCompetitionChairman(chairman);
				
				competitionService.saveCompetition(competition);
			}break;
			
			case 2: {
				
				System.out.println("Enter the Competition Id");
				int id = sc.nextInt();
				
				Competition competition = competitionService.getById(id);
				
				System.out.println("Competition Id = "+competition.getCompetitionId());
				System.out.println("Competition Name = "+competition.getCompetitionName());
				System.out.println("Competition Year = "+competition.getCompetitionYear());
				System.out.println("Competition Sponsor Name = "+competition.getSponsorsName());
			}break;
			
			case 3: {
				System.out.println("Enter the Competition Id");
				int id = sc.nextInt();
				
				System.out.println("Enter the Sponsor Name");
				String sponsor = sc.next();
				sponsor += sc.nextLine();
				
				competitionService.updateCompetition(id, sponsor);
			}break;
			
			case 4: {
				System.out.println("Enter the Competition Id");
				int id = sc.nextInt();
				
				competitionService.deleteCompetition(id);
			}break;
			}
		}
	}
}

package com.mycompany.controller;

import java.util.List;

import com.mycompany.dao.DataRetrievalService;
import com.mycompany.dto.LotteryTicket;
import com.mycompany.microservice.DataEvaluationService;

public class ApplicationLaunchController {

	/**
	 * Calls to DataRetrievalService to retrieve data for program 
	 */
	public void launch() {
		//Retrieve Data
		DataRetrievalService dataRetrievalService = new DataRetrievalService();
		dataRetrievalService.scrapePage();
		List<LotteryTicket> allScratchOffTickets = dataRetrievalService.returnAllTickets();
		
		//perform analysis
		DataEvaluationService dataEvaluationService = new DataEvaluationService();
		List<LotteryTicket> topTen = dataEvaluationService.findHighestPrizesAvailable(allScratchOffTickets, 10);

		System.out.println("TOP TEN TICKETS");
		int i = 1;
		for(LotteryTicket ticket : topTen) {
			System.out.println();
			System.out.println("GAME " + i);
			System.out.println();
			System.out.println(ticket.getName());
			System.out.println("This ticket costs $" + ticket.getCost());
			System.out.println(ticket.getAllPrizes());
			i++;
			
		}
	}

}

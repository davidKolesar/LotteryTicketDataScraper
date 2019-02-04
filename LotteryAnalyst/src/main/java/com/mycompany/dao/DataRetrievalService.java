package com.mycompany.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mycompany.dto.LotteryTicket;

public class DataRetrievalService {
	private static final Logger LOGGER = Logger.getLogger(DataRetrievalService.class.getName());

	int gameCount = 1;
	int iteration = 1;
	String textHeader = "";
	LotteryTicket ticket = new LotteryTicket();
	String[] remainingPrizesForTicket;

	/**
	 * Scrapes table from website to get data and concatenates string to present to
	 * the user.
	 */
	public void scrapePage() {

		// Attempting to connect to page
		Document document = null;
		try {
			LOGGER.log(Level.FINE, "Attempting to connect to PA Lottery page");
			document = Jsoup
					.connect(
							"https://www.palottery.state.pa.us/scratch-offs/Print-Scratch-Offs.aspx?gametype=Remaining")
					.get();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.toString(), "Unable to connect to lottery page.");
		}
		System.out.println(document.title());

		Element table = document.select("table").first();
		Iterator<Element> iterator = table.select("td").iterator();
		while (iterator.hasNext()) {

			// temporary console view checks if new ticket is being evaluated
			if (iteration == 1) {
				System.out.println("");
				System.out.println("Game # : " + gameCount);
				System.out.println("");
			}
			
			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			setTicketDataFromTable(iteration, iterator.next().text()); 
			iteration = iteration += 1;

			// checks if this is last cell for ticket
			if (iteration == 6) {
				gameCount++;
				iteration = 1;
			}
		}
	}

	private void setHeader(int iteration) {

		switch (iteration) {
		case 1:
			textHeader = "TICKET NUMBER";
			break;
		case 2:
			textHeader = "TICKET NAME";
			break;
		case 3:
			textHeader = "TICKET COST";
			break;
		case 4:
			textHeader = "WINNING AMOUNTS";
			break;
		case 5:
			textHeader = "WINNERS REMAINING";
			break;
		}
	}

	private void setTicketDataFromTable(int iteration, String tableData) {
	
		switch (iteration) {
		case 1:
			ticket.setNumber(tableData);
			break;
		case 2:
			ticket.setName(tableData);
			break;
		case 3:
                                      
			break;
		case 4:
			remainingPrizesForTicket = tableData.split("\\s+");
			break;
		case 5:
			HashMap<Integer, Integer> prizesToAvailabilities = new HashMap<Integer, Integer>(); 
			String [] remainingWinnersPerPrize = tableData.split("\\s+");
			
			for(int i = 0; i < remainingPrizesForTicket.length; i++) {
				
				Integer remainingPrizeForTicket = Integer.valueOf(remainingWinnersPerPrize[i]);
				Integer remainingWinners = Integer.valueOf(remainingWinnersPerPrize[i]);
				prizesToAvailabilities.put(remainingPrizeForTicket, remainingWinners);
			}
			ticket.setPrizesToAvailabilities(prizesToAvailabilities);
			break;
		}
	}
	
}

package com.mycompany.dao;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DataRetrievalService {
	private static final Logger LOGGER = Logger.getLogger(DataRetrievalService.class.getName());

	int gameCount = 1;
	int iteration = 1;
	String textHeader = "";

	/**
	 * Scrapes table from website to get data and concatenates string to present to
	 * the user
	 */
	public void scrapePage() {

		// Attemtping to connect to page
		Document document = null;
		try {
			LOGGER.log( Level.FINE, "Attempting to connect to PA Lottery page");
			document = Jsoup
					.connect(
							"https://www.palottery.state.pa.us/scratch-offs/Print-Scratch-Offs.aspx?gametype=Remaining")
					.get();
		} catch (IOException e) {
			 LOGGER.log( Level.SEVERE, e.toString(), "Unable to connect to lottery page." );
		}
		System.out.println(document.title());

		Element table = document.select("table").first();
		Iterator<Element> iterator = table.select("td").iterator();
		while (iterator.hasNext()) {

			System.out.println("");
			System.out.println("Game # " + gameCount);
			System.out.println("");

			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			iteration = iteration += 1;
			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			iteration = iteration += 1;
			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			iteration = iteration += 1;
			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			iteration = iteration += 1;
			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			iteration = 1;
			gameCount++;
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

}

package com.mycompany.dao;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DataRetrievalService {
	int gameCount = 1;
	int iteration = 1;
	String textHeader = "";

	public void scrapePage() throws IOException {

		// connect to page
		Document doc = Jsoup
				.connect("https://www.palottery.state.pa.us/scratch-offs/Print-Scratch-Offs.aspx?gametype=Remaining")
				.get();
		System.out.println(doc.title());

		Element table = doc.select("table").first();
		Iterator<Element> iterator = table.select("td").iterator();
		while (iterator.hasNext()) {
			
			System.out.println("");
			System.out.println("Game # " + gameCount);
			System.out.println("");
			
			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			iteration = iteration+= 1;
			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			iteration = iteration+= 1;
			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			iteration = iteration+= 1;
			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			iteration = iteration+= 1;
			setHeader(iteration);
			System.out.println(textHeader + " : " + iterator.next().text());
			iteration = 1;
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

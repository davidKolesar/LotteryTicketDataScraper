package app;

import java.io.IOException;

import com.mycompany.dao.DataRetrievalService;

public class Run {

	public static void main(String args[]) {
		DataRetrievalService dataRetrievalService = new DataRetrievalService();
		dataRetrievalService.scrapePage();
	}
}

package com.mycompany.microservice;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataConversionService {
	private static final Logger LOGGER = Logger.getLogger(DataConversionService.class.getName());
	
	
	public Integer convertTableDataToMoney(String tableData) {
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number cost = null;

		try {
			cost = format.parse(tableData);
		} catch (ParseException e) {
			LOGGER.log(Level.SEVERE, e.toString(),
					"Unable to parse dataTable to currency. Check if source table data was updated.");
		}
		return cost.intValue();
	}

	public String[] removeSpacesFromTableData(String tableData) {
		if (tableData.contains("FREE")) {
			String tableDataSansfreeTicket = tableData.substring(0, tableData.lastIndexOf("FREE"));
			String completeTableData = tableDataSansfreeTicket + " FREE";
			String[] separatedTableData = completeTableData.split("\\s+");
			return separatedTableData;

		}
		return tableData.split("\\s+");
	}

	public Integer removeCommasFromTableData(String tableData) {
		String amount = tableData.replace(",", "");

		return Integer.valueOf(amount);
	}
}

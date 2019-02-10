package com.mycompany.microservice;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cthulu
 *
 */
public class DataConversionService {
	private static final Logger LOGGER = Logger.getLogger(DataConversionService.class.getName());
	// TODO fix javadocs to reveal datatype

	/**
	 * Takes prize data from original table and parses it into integers while
	 * handling currency chars
	 * 
	 * @param tableData
	 * @return
	 */
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

	/**
	 * Takes String data from original table and parses it into integers while
	 * handling free ticket prizes
	 * 
	 * @param tableData
	 * @return
	 */
	public String[] removeSpacesFromTableData(String tableData) {
		if (tableData.contains("FREE")) {
			String tableDataSansfreeTicket = tableData.substring(0, tableData.lastIndexOf("FREE"));
			String completeTableData = tableDataSansfreeTicket + " FREE";
			String[] separatedTableData = completeTableData.split("\\s+");
			return separatedTableData;

		}
		return tableData.split("\\s+");
	}

	/**
	 * Removes commas from original table data and converts it to integer
	 * 
	 * @param tableData
	 * @return
	 */
	public Integer removeCommasFromTableData(String tableData) {
		String amount = tableData.replace(",", "");

		return Integer.valueOf(amount);
	}
}

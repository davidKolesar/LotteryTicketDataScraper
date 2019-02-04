package com.mycompany.dto;

import java.util.HashMap;

public class LotteryTicket {

	public int id;
	public String name;
	public HashMap<Integer, Integer> prizesToAvailabilities = new HashMap<Integer, Integer>(); 
	
}

package com.mycompany.dto;

import java.util.HashMap;
import java.util.UUID;

public class LotteryTicket {

	public UUID id = java.util.UUID.randomUUID();
	public String number;
	public int cost;
	public String name;
	public HashMap<Integer, Integer> prizesToAvailabilities = new HashMap<Integer, Integer>(); 
	
	
	
	public UUID getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<Integer, Integer> getPrizesToAvailabilities() {
		return prizesToAvailabilities;
	}
	public void setPrizesToAvailabilities(HashMap<Integer, Integer> prizesToAvailabilities) {
		this.prizesToAvailabilities = prizesToAvailabilities;
	}
	
}

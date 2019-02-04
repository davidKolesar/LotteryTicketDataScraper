package com.mycompany.dto;

import java.util.HashMap;

public class LotteryTicket {

	public int id;
	public int number;
	public int cost;
	public String name;
	public HashMap<Integer, Integer> prizesToAvailabilities = new HashMap<Integer, Integer>(); 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
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

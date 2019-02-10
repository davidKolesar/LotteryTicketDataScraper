package com.mycompany.microservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.mycompany.dto.LotteryTicket;

public class DataEvaluationService {
	List<LotteryTicket> allScratchOffTickets = new ArrayList<>();

	public ArrayList<LotteryTicket> findHighestPrizesAvailable(ArrayList<LotteryTicket> allScratchOffTickets,
			int amountToEvaluate) {
		List<LotteryTicket> topPrizedTickets = new ArrayList<>();
		Integer highestPrizeAmount = 0;

		// iterate through all tickets
		for (LotteryTicket ticket : allScratchOffTickets) {

			// For each ticket, find all prizes
			Set<Integer> prizeAmounts = ticket.getAllPrizes();

			// evaluate if prizes are greater than current top prize
			for (Integer prizeAmount : prizeAmounts) {
				
				if (highestPrizeAmount < prizeAmount || highestPrizeAmount == prizeAmount) {
				
					// if so, check if tickets are available
					HashMap<Integer, Integer> prizesToAvailabities = ticket.getPrizesToAvailabilities();
					// if at least one is available, set as the new top prize
					
					if (prizesToAvailabities.get(prizeAmount) > 0) {
						topPrizedTickets.add(ticket);
					}
				}

			}

		}
		return null;

	}

	// Most possible winners

	// Highest possible winners

	// "hot" tickets

	// Greatest odds?

	// Each by price

	// Big winner odds

}

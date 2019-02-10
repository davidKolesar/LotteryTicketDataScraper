package com.mycompany.microservice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.mycompany.dto.LotteryTicket;

public class DataEvaluationService {
	/**
	 * Goes through all tickets passed in as an argument and returns the top available prizes for n tickets. 
	 * 
	 * @param allScratchOffTickets -- List of all tickets to evaluate (should be all tickets in the game)
	 * @param amountToEvaluate -- The amount of tickets to evaluate
	 * @return -- Top n Tickets with highest prize amounts.
	 */
	public List<LotteryTicket> findHighestPrizesAvailable(List<LotteryTicket> allScratchOffTickets, int amountToEvaluate) {
		List<LotteryTicket> topPrizedTickets = new ArrayList<>();
		Integer highestPrizeAmount = 0;

		// iterate through all tickets
		for (LotteryTicket ticket : allScratchOffTickets) {

			// For each ticket, find all prizes
			Set<Integer> prizeAmounts = ticket.getAllPrizes();

			// evaluate if prizes are greater than current top prize
			for (Integer prizeAmount : prizeAmounts) {

				if (highestPrizeAmount < prizeAmount || highestPrizeAmount == prizeAmount) {

					// if greater than current top prize, check if winners are available
					HashMap<Integer, Integer> prizesToAvailabities = ticket.getPrizesToAvailabilities();

					// if at least one is available, set as the new top prize
					if (prizesToAvailabities.get(prizeAmount) > 0) {
						topPrizedTickets.add(ticket);
					}
				}
			}
		}
		
		// getting top tickets from amountToEvaluate
		allScratchOffTickets.sort(Comparator.comparing(LotteryTicket::getCost));
		List<LotteryTicket> topTickets = allScratchOffTickets.subList(allScratchOffTickets.size() -amountToEvaluate, allScratchOffTickets.size());
		
		return topTickets;
	}

	// Most possible winners

	// Highest possible winners

	// "hot" tickets

	// Greatest odds?

	// Each by price

	// Big winner odds

}

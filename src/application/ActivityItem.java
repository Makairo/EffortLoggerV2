//User class for use with EffortLogger and Planning Poker
//Collaborators: Andrew Hejl
package application;

import java.util.ArrayList;

public class ActivityItem 
{
	private String name;
	private double average;
	private ArrayList<Integer> estimate;
	private ArrayList<String> criteria;
	private PokerCard card;
	
	//Temporary database to store ActivityItems without SQL.
	public static ArrayList<ActivityItem> PPDatabase = new ArrayList<ActivityItem>();
	
	
	ActivityItem()
	{
		name = "empty item";
		average = 0.0;
		estimate = new ArrayList<Integer>();
		criteria = new ArrayList<String>();
		card = new PokerCard();
	}
	
	ActivityItem(String inName)
	{
		name = inName;
		average = 0.0;
		estimate = new ArrayList<Integer>();
		criteria = new ArrayList<String>();
		card = new PokerCard();
	}
	
	//Add new estimate, update the average and planning poker card.
	public void AddEstimate(int input)
	{
		estimate.add(input);
		average = setAvg();
		updateCard();
	}
	
	//Add criteria.
	public void AddCriteria(String input)
	{
		criteria.add(input);
	}
	
	//Getters and setters.
	public String getName()
	{
		return this.name;
	}
	
	public double getAverage()
	{
		return this.average;
	}
	
	public ArrayList<Integer> getEstimates()
	{
		return this.estimate;
	}
	
	public PokerCard getCard()
	{
		return this.card;
	}
	
	//Returns string value of all the criteria associated with one element in the list.
	//If empty, returns "No criteria listed."
	public String getCriteria()
	{
		String returnVal = "";
		if(criteria.isEmpty())
		{
			returnVal = "No criteria listed.";
			return returnVal;
		}
		for(int i = 0 ; i < criteria.size() ; i++)
		{
			returnVal += "> " + criteria.get(i) + '\n';
		}
		return returnVal;
	}
	
	//Update the values on the planning poker card
	public void updateCard()
	{
		int high, low;
		if(estimate.isEmpty())
		{
			return;
		}
		
		//Initially set high and low to first value in list.
		high = estimate.get(0);
		low = estimate.get(0);
		for(int i = 1 ; i < estimate.size() ; i++)
		{
			if(estimate.get(i) > high)
			{
				high = estimate.get(i);
			}
			if(estimate.get(i) < low)
			{
				low = estimate.get(i);
			}
		}
		card.setHighCard(high);
		card.setLowCard(low);
		card.setAverage(average);
	}
	

	//Returns the index of the first item in the list to match the given name(string).
	//Returns -1 if not found.
	public static int findItem(String input)
	{
		int index = -1;
		if(PPDatabase.isEmpty())
		{
			return index;
		}
		for(int i = 0 ; i < PPDatabase.size() ; i++)
		{
			if(input.equals(PPDatabase.get(i).getName()))
			{
				//Value found, exit and return index.
				index = i;
				return index;
			}
		}
		//Value not found
		return index;
	}
	
	//Helper method to calculate the average.
	private double setAvg()
	{
		double sum = 0.0;
		int i;
		for(i = 0 ; i < estimate.size() ; i++)
		{
			sum += (double)estimate.get(i);
		}
		return sum / i;
	}
}

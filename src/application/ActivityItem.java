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
	
	public void AddEstimate(int input)
	{
		estimate.add(input);
		average = setAvg();
		updateCard();
	}
	
	public void AddCriteria(String input)
	{
		criteria.add(input);
	}
	
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
	
	public PokerCard getCard()
	{
		return this.card;
	}
	
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

//User class for use with EffortLogger and Planning Poker
//Collaborators: Andrew Hejl
package application;

import java.util.ArrayList;

public class ActivityItem 
{
	private int ID;
	private double average;
	private ArrayList<Integer> estimate;
	private ArrayList<String> criteria;
	private PokerCard card;
	
	//Temporary database to store ActivityItems without SQL.
	public static ArrayList<ActivityItem> PPDatabase = new ArrayList<ActivityItem>();
	
	
	ActivityItem()
	{
		ID = 0000000;
		average = 0.0;
		estimate = new ArrayList<Integer>();
		criteria = new ArrayList<String>();
	}
	
	ActivityItem(int nID)
	{
		ID = nID;
		average = 0.0;
		estimate = new ArrayList<Integer>();
		criteria = new ArrayList<String>();
	}
	
	public void AddEstimate(int input)
	{
		estimate.add(input);
		average = setAvg();
	}
	
	public void AddCriteria(String input)
	{
		criteria.add(input);
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public double getAverage()
	{
		return this.average;
	}
	
	public ArrayList<Integer> getEstimates()
	{
		return this.estimate;
	}
	
	public ArrayList<String> getCriteria()
	{
		return this.criteria;
	}
	
	public void createCard()
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
		this.card = new PokerCard(high, low, average);
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

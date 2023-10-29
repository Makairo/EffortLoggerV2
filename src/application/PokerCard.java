//User class for use with EffortLogger and Planning Poker
//Collaborators: Andrew Hejl
package application;

public class PokerCard
{
	int highCard;
	int lowCard;
	double average;
	
	PokerCard()
	{
		highCard = 0;
		lowCard = 0;
		average = 0.0;
	}
	
	PokerCard(int high, int low, double avg)
	{
		highCard = high;
		lowCard = low;
		average = avg;
	}
	
	public int getHighCard()
	{
		return this.highCard;
	}
	
	public int getLowCard()
	{
		return this.lowCard;
	}
	
	public double getAverage()
	{
		return this.average;
	}
	
	public void setHighCard(int input)
	{
		this.highCard = input;
	}
	
	public void setLowCard(int input)
	{
		this.lowCard = input;
	}
	
	public void setAverage(double input)
	{
		this.average = input;
	}
}

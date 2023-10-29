package application;

public class User
{
	private String name;
	private int ID;
	private int rank;
	
	
	User()
	{
		name = "NULL USER";
		ID = 0000000;
		rank = 0;
	}
	
	User(String nName, int nID, int nRank)
	{
		name = nName;
		ID = nID;
		rank = nRank;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public int getRank()
	{
		return this.rank;
	}
	
	public void setName(String nName)
	{
		this.name = nName;
	}
	
	public void setID(int nID)
	{
		this.ID = nID;
	}
	
	public void setRank(int nRank)
	{
		this.rank = nRank;
	}
}
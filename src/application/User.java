package application;

import java.util.ArrayList;

public class User
{
	private String username;
	private String password;
	private int ID;
	private int rank;
	
	//Standin database instead of SQL.
	public static ArrayList<User> database = new ArrayList<User>();
	
	//toString override
	public String toString()
	{
		return "Username: " + username 
			 + "; Password: " + password
			 + "; User ID: " + ID;
	}
	
	//Access for the temporary database.
	public static int findUser(String inUser)
	{
		for(int i = 0; i < database.size() ; i++)
		{
			if(database.get(i).username.equals(inUser))
			{
				return i;
			}
		}
		return -1;
	}
	
	//Username restrictions:
	// 4 - 32 characters
	// Upper and Lower case + Numeric + "." + "-" + "_"
	// First character must be alphanumeric
	// Special chars must be followed by alphanumeric
	User()
	{
		username = "NULL USER";
		ID = 0000000;
		rank = 0;
	}
	
	User(String nName, String nPassword, int nID, int nRank)
	{
		username = nName;
		password = nPassword;
		ID = nID;
		rank = nRank;
	}
	
	public String getName()
	{
		return this.username;
	}
	
	public String getPassword()
	{
		return this.password;
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
		this.username = nName;
	}
	
	public void setPassword(String nPassword)
	{
		this.password = nPassword;
	}
	
	public void setID(int nID)
	{
		this.ID = nID;
	}
	
	public void setRank(int nRank)
	{
		this.rank = nRank;
	}
	
	public void setCodeName(String codeName)
	{
		this.username = codeName;
	}

}

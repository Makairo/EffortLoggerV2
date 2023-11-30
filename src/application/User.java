//User class for use with EffortLogger and Planning Poker
//Collaborators: Andrew Hejl
package application;

import java.util.ArrayList;
import java.util.List;

public class User
{
	private String username;
	private String password;
	private int ID;
	private int rank;
	private String codeName;
	
	//Standin database instead of SQL.
	//Pre seed the database with user logins.
			//Change yours!
	static User u0 = new User("****", "****", 0000, 0, "EMP000");
	static User u1 = new User("Jerry","password", 7701, 5, "EMP123");
	static User u2 = new User("Alice","password", 7702, 5, "EMP124");
	static User u3 = new User("Kyle","Titan", 7703, 5, "EMP125");
	static User u4 = new User("Andrew", "Bandit", 7704, 5, "EMP126");
	static User u5 = new User("Gavin","password", 7705, 5, "EMP127");
	public static ArrayList<User> database = new ArrayList<User>(List.of(u1, u2, u3, u4, u5));
	
	//toString override
	public String toString()
	{
		return "Username: " + username 
			 + "; Password: " + password
			 + "; User ID: " + ID
			 + "; Rank: " + rank + "\n";
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
		codeName = "NULL";
	}
	
	User(String nName, String nPassword, int nID, int nRank, String nCodeName)
	{
		username = nName;
		password = nPassword;
		ID = nID;
		rank = nRank;
		codeName = nCodeName;
		
	}
	
	//Get and set methods...
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
	
	public String getCodeName()
	{
		return this.codeName;
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
	public void setCodeName(String nCodeName)
	{
		this.codeName = nCodeName;
	}
	
}

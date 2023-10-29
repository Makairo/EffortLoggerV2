package application;

public class riskReductionHandling
{
	//Counter SQL Injection: Jerry
	
	//Proper Input Validation: Alice
	
	//Restricting Dangerous File Upload: Gavin
	
	//Ensuring and Requiring Authentication: Andrew
	public static int RequestRank(User inUser)
	{
		return inUser.getRank();
	}
	
	public static int RequestId(User inUser)
	{
		return inUser.getID();
	}
	
	public static Boolean AssertRank(User inUser, int rank) 
	{
		return inUser.getRank() == rank;
	}
	
	public static Boolean AssertID(User inUser, int ID)
	{
		return inUser.getID() == ID;
	}
	
	public static Boolean AssertUser(User inUser, int rank, int ID)
	{
		if(!AssertID(inUser, ID) || !AssertRank(inUser, rank))
		{
			return false;
		}
		return true;
	}
	
	public static Boolean Login(String username, String password)
	{
		int index = User.findUser(username);
		if(index == -1)
		{
			return false;
		}
		
		if(!password.equals(User.database.get(index).getPassword()))
		{
			return false;
		}
		
		return true;
		
	}
	
	//Ensuring Anonymity: Kyle
	
	public static String RequestName(User inUser)
	{
		return inUser.getName();
	}

	public static void setCodeName(User inUser, String codeName)
	{
		 inUser.setName(codeName);
	}
	
}


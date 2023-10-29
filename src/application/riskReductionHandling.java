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
		return false;
	}
	
	//Ensuring Anonymity: Kyle
	
	public static String RequestName(User inUser)
	{
		return inUser.getName();
	}

	public static void setCodeName(User inUser, int codeName)
	{
		 inUser.setName(codeName);
	}


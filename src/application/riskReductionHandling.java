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
	
	//Ensuring Anonymity: Kyle
}
package application;

public class Authorization 
{
	//Ensuring and Requiring Authentication: Andrew
		//Helper method
		public static int RequestRank(User inUser)
		{
			return inUser.getRank();
		}
		
		//Helper method
		public static int RequestId(User inUser)
		{
			return inUser.getID();
		}
		
		//Helper method
		public static Boolean AssertRank(User inUser, int rank) 
		{
			return inUser.getRank() == rank;
		}
		
		//Helper method
		public static Boolean AssertID(User inUser, int ID)
		{
			return inUser.getID() == ID;
		}
		
		//Asserts whether the user is valid for the information
		public static Boolean AssertUser(User inUser, int rank, int ID)
		{
			if(!AssertID(inUser, ID) || !AssertRank(inUser, rank))
			{
				return false;
			}
			return true;
		}
		
		//Handles user login for the login screen.
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
		
}

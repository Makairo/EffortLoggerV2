package application;

public class Authorization 
{
		//Ensuring and Requiring Authentication: Andrew
		//Helper method
		public static Boolean AssertRank(User inUser, int rank) 
		{
			return inUser.getRank() >= rank;
		}
		
		//Helper method
		public static Boolean AssertID(User inUser, int ID)
		{
			return inUser.getID() == ID;
		}
		
		//Added method to do a routine check for the user while program is running.
		//Combines previous two methods.
		//Suggested by Kyle
		//Asserts whether the user is valid for the information provided.
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
			if(index <= 0)
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

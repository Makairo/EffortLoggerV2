package application;

public class Anonymity 
{
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

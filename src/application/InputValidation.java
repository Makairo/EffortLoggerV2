package application;

public class InputValidation {
	//Ensuring inputs are accepted by defined parameters
	
	//Username restrictions:
	// 1. 4 - 32 characters
	// 2. Upper and Lower case + Numeric + "." + "-" + "_"
	// 3. First character must be alphanumeric
	// 4. Special chars must be followed by alphanumeric
	
	//1. Check that the username is between 4 to 32 characters in length
	public static Boolean checkLength(User inUser)
	{
		String userStr = inUser.getName();
		if(userStr.length() < 4 || userStr.length() > 32) {
			return false;
		}
		return true;
	}
	
	//2. Username consists of upper/lower/numeric/./-/_ characters
	public static Boolean checkInputType(User inUser)
	{
		 String userStr = inUser.getName();
		 char currChar;
		 
		 //alternative: if(userStr.contains("a"))...
		 for(int i = 0; i < userStr.length()-1; i++) {
			 currChar = userStr.charAt(i);
			 if(!(Character.isLetterOrDigit(currChar) || currChar == '.' || currChar == '-' || currChar == '_'))
			 {
				 return false;
			 }
		 }
		 return true;
	}
	
	//3. Username's first character is alphanumeric (a-z, 0-9)
	public static Boolean checkFirstChar(User inUser)
	{
		String userStr = inUser.getName();
		if(!(Character.isLetterOrDigit(userStr.charAt(0))) )
		{
			return false;
		}
		return true;
	}
	
	//4. If there is a special char ('.', '-', '_'), it must be followed by alphanumeric char (letter or number)
	public static Boolean checkSpecialChar(User inUser)
	{
		 String userStr = inUser.getName();
		 char currChar;
		 
		 for(int i = 0; i < userStr.length()-1; i++) {
			 currChar = userStr.charAt(i);
			 if(currChar == '.' || currChar == '-' || currChar == '_')
			 {
				 if(!Character.isLetterOrDigit(userStr.charAt(i+1)))
					 return false;
			 } 
		 }
		return true;
	}
	
	//If the username fulfills all 4 restrictions, it is valid. 
	public boolean returnValidity(User inUser)
	{
		boolean restr1 = checkLength(inUser);
		boolean restr2 = checkInputType(inUser);
		boolean restr3 = checkFirstChar(inUser);
		boolean restr4 = checkSpecialChar(inUser);
		
		if(restr1 == true && restr2 == true && restr3 == true && restr4 == true)
			return true;
		return false;
			
	}
	
}

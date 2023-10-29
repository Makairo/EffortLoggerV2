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

	// List of employee names
    	
        String[] employeeNames = {	
            "Derrick Rose", "John Smith", "Mary Johnson", "Alice Brown", "David Lee"
        };
        
        
       // Logic for changing employee name to a code name. i.e "EMP123"
        
        for (int i = 0; i < employeeNames.length; i++) {
            String oldName = employeeNames[i];
            String codeName = generateCodeName(i + 123);
            String newName = changeName(oldName, codeName);
            
            
       // Checks to see if the employee name hasn't been change to a code name
            
            if (!oldName.equals(newName)) {
                printNames(oldName, newName);
                System.out.println("Name Changed Successfully");
            } else {
                System.out.println("Name change failed for: " + oldName);
            }
        }
    }
    
    // Function to change employee name to code name
    public static String changeName(String employeeName, String codeName) {
       
        return codeName;
    }
    
    // Prints old employee name as well as new employee name for admins knowlegde
    public static void printNames(String oldName, String newName) {
        System.out.println("Old Name: " + oldName);
        System.out.println("New Name: " + newName);
    }
    
    // Generates code names
    public static String generateCodeName(int number) {
        return "EMP" + number;
    }

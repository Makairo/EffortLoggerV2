package application;

import java.util.Random;

public class Anonymity {
    // Ensuring Anonymity: Kyle
	
	
	// This function gets the users name
	
    public static String requestName(User inUser) {
        
        return inUser.getName();
    }

    // This function sets the code name for the employee to keep personal data hidden
    
    public static void setCodeName(User inUser) {
        String codeName = generateCodeName();
        inUser.setName(codeName);
    }

    // This function processes the Users in the data base
    
    public static void processUser(User user) {
        System.out.println("Original Name: " + user.getName());
        setCodeName(user);
        System.out.println("Updated Name: " + user.getName());
    }

    public static void generate(User user) {
        String codeName = generateCodeName();
        user.setName(codeName);
    }

    // This method generates a random code name.
    
    public static String generateCodeName() {
        Random rand = new Random();
        int codeNumber = rand.nextInt(1000) + 1; // Generate a random number between 1 and 1000
        return "EMP" + codeNumber;
    }
}

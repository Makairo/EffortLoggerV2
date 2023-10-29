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
    
    public static void processUser(User inUser) {
        System.out.println("Original Name: " + inUser.getName());
        setCodeName(inUser);
        System.out.println("Updated Name: " + inUser.getName());
    }

    public static void generate(User inUser) {
        String codeName = generateCodeName();
        inUser.setName(codeName);
    }

    // This method generates a random code name.
    
    public static String generateCodeName() {
        Random rand = new Random();
        int codeNumber = rand.nextInt(1000) + 1; // Generate a random number between 1 and 1000
        return "EMP" + codeNumber;
    }

// Check if the name has been changed to a code name.
    public static boolean isNameChanged(User inUser) {
    
        boolean nameChanged = !inUser.getName().equals(requestName(inUser));
        if (nameChanged) {
            System.out.println("Name Changed Successfully");
        } else {
            System.out.println("Codename not activated!");
        }
        return nameChanged;
    }
}

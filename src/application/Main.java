package application;
	
import java.io.Console;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;



public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.FXML"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		//Pre seed the database with user logins.
		//Change yours!
		User.database.add(new User("Jerry","password", 7701, 5));
		User.database.add(new User("Alice","password", 7702, 5));
		User.database.add(new User("Kyle","password", 7703, 5));
		User.database.add(new User("Andrew", "Bandit", 7704, 5));
		User.database.add(new User("Gavin","password", 7705, 5));
		
		launch(args);
		
		//CODE BELOW IS LAST RESORT CONSOLE IMPLEMENTATION
		//LOL I LOVE CARTER
		/*
		Scanner scanner = new Scanner(System.in);
		Boolean loggedin = false;
		Boolean exit = false;
		String userInput;
		int index;
		
		
		
		
		
		
		//Login Screen
		System.out.println("Welcome to EffortLogger!");
		System.out.println("Please Login: ");
		while(!loggedin && !exit)
		{
			System.out.println("Username (-1 to quit): ");
			userInput = scanner.nextLine();
			
			if(userInput.equals("-1"))
			{
				exit = true;
				return;
			}
			
			index = User.findUser(userInput);
			if(index == -1)
			{
				System.out.println("Invalid Username");
				continue;
			}
			
			System.out.println("Password: ");
			userInput = scanner.nextLine();
			if(!userInput.equals(User.database.get(index).getPassword()))
			{
				System.out.println("Invalid Password");
				continue;
			}
			
			loggedin = true;
			
			
		}
		
		//EffortLogger v Planning Poker Selection
		System.out.println("Please select EffortLogger or Planning Poker (-1 to logout): ");
		userInput = scanner.nextLine();
		while(loggedin)
		{
			if(userInput.equals("-1"))
			{
				loggedin = false;
				return;
			}
			if(userInput.equals("EF"))
			{
				//EffortLogger
			}
			if(userInput.equals("PP"))
			{
				//Planning Poker
			}
		}
		
		
		//EffortLogger
		
		//Planning Poker
		
		
		
		
		
		*/
	}
	
	
}

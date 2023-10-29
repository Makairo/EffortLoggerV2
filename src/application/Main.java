package application;
	
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
			Parent root = FXMLLoader.load(getClass().getResource("/Main.FXML"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		User.database.add(new User("Jerry","password", 7701, 5));
		User.database.add(new User("Alice","password", 7702, 5));
		User.database.add(new User("Kyle","password", 7703, 5));
		User.database.add(new User("Andrew", "Bandit", 7704, 5));
		User.database.add(new User("Gavin","password", 7705, 5));
		
		//Login Screen
		
		//EffortLogger v Planning Poker Selection
		
		//EffortLogger
		
		//Planning Poker
		
		
		
		
		
		//THIS IS CODE FOR JAVA FX IMPLEMENTATION
		//UNCOMMENT WHEN READY TO IMPLEMENT
		//launch(args);
	}
	
}

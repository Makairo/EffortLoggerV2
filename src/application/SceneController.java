package application;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneController 
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	public TextField usernameField;
	@FXML
	public TextField passwordField;
	@FXML
	public Button loginButton;
	@FXML
	public Label loginLabel;

	
	public void switchToMainScreen(ActionEvent event) throws IOException
	{
		try
		{
			String username = usernameField.getText();
			String password = passwordField.getText();
			if(riskReductionHandling.Login(username, password))
			{
				Parent root = FXMLLoader.load(getClass().getResource("Main.FXML"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}else
			{
				loginLabel.setText("Invalid Username / Password");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public void switchToLoginScreen(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("Login.FXML"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

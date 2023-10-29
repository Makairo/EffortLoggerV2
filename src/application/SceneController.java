/*Controller for EffortLogger JavaFX.
 * Collaborators: Andrew Hejl
 * 		-Initial commit 
 * */
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

	//Handles the login process.
	//Collaborators: Andrew Hejl
	public void switchToMainScreen(ActionEvent event) throws IOException
	{
		try
		{
			//Parse text from fields.
			String username = usernameField.getText();
			String password = passwordField.getText();
			//Login
			if(Authorization.Login(username, password))
			{
				Parent root = FXMLLoader.load(getClass().getResource("Main.FXML"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}else
			{
				//Invalid login, notify user.
				loginLabel.setText("Invalid Username / Password");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	//Handles the logout process.
	//Collaborators: Andrew Hejl
	public void switchToLoginScreen(ActionEvent event) throws IOException
	{
		//Simply reloads login page.
		Parent root = FXMLLoader.load(getClass().getResource("Login.FXML"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

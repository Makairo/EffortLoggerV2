/*Controller for EffortLogger JavaFX.
 * This controls the Login.FXML and Main.FXML files.
 * Collaborators: Andrew Hejl
 * 		-Initial commit 
 * */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneController 
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	private String activeCodeName;
	
	@FXML
	public Label userLabel;
	@FXML
	public TextField usernameField;
	@FXML
	public TextField passwordField;
	@FXML
	public Button loginButton;
	@FXML
	public Label loginLabel;
	

	//Handles the login process.
	public void switchToMainScreen(ActionEvent event) throws IOException
	{
		InputValidation validate = new InputValidation();
	    boolean isValid;
		
		try
		{
			//Parse text from fields.
			String username = usernameField.getText();
			String password = passwordField.getText();
			//Login
			
			User currUser = new User(username, password, 0000, 0, "");
            
            //Input Validation
            isValid = validate.returnValidity(currUser);
            if(isValid == false) {
                loginLabel.setText("Invalid username type, try again");
            }
            //end of Input Validation
			
			if(Authorization.Login(username, password))
			{
				activeCodeName = User.database.get(User.findUser(username)).getCodeName();
				System.out.println(activeCodeName);
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
	public void switchToLoginScreen(ActionEvent event) throws IOException
	{
		//Simply reloads login page.
		Parent root = FXMLLoader.load(getClass().getResource("Login.FXML"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//Handles transition to PlanningPoker Pane
	public void switchToPlanningPoker(ActionEvent event) throws IOException
	{
		//Simply reloads login page.
		Parent root = FXMLLoader.load(getClass().getResource("PlanningPoker.FXML"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}

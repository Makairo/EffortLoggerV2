/*Controller for EffortLogger JavaFX.
 * This controls the Login.FXML and Main.FXML files.
 * Collaborators: Andrew Hejl, Kyle Navratil
 * 		-Initial commit 
 * */
package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController implements Initializable
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	private String activeCodeName;
	private User currUser = User.database.get(0);
	private User tempUser = new User("","", 0 , 000, "EMP000");
	
	private ObservableList<String> options1 = 
			FXCollections.observableArrayList(
					"Business Project",
					"Development Project"
			);
	private ObservableList<String> options2_B = 
			FXCollections.observableArrayList(
					"Planning",
					"Information Gathering",
					"Information Understanding",
					"Verifying",
					"Outlining",
					"Drafting",
					"Finalizing",
					"Team Meeting",
					"Coach Meeting",
					"Stakeholder Meeting"
			);
	private ObservableList<String> options2_D = 
			FXCollections.observableArrayList(
					"Problem Understanding",
					"Conceptual Design Plan",
					"Requirements",
					"Conceptual Design",
					"Conceptual Design Review",
					"Detailed Design Plan",
					"Detailed Design/Prototype",
					"Detailed Design Review",
					"Implementation Plan",
					"Test Case Generation",
					"Solution Specification",
					"Solution Review",
					"Solution Implementation",
					"Unit/System Test",
					"Relection",
					"Repository Update"
			);
	
	private ObservableList<String> options3 = 
			FXCollections.observableArrayList(
					"Plans",
					"Deliverables",
					"Interuptions",
					"Defects",
					"Others"
			);
	
	private ObservableList<String> options4_1 = 
			FXCollections.observableArrayList(
					"Project Plan",
					"Risk Management Plan",
					"Conceptual Design Plan",
					"Detailed Design Plan",
					"Implementation Plan"
			);
	
	private ObservableList<String> options4_2 = 
			FXCollections.observableArrayList(
					"Conceptual Design",
					"Detailed Design",
					"Test Cases",
					"Solution",
					"Reflection",
					"Outline",
					"Draft",
					"Report",
					"User Defined",
					"Other"
			);
	
	private ObservableList<String> options4_3 = 
			FXCollections.observableArrayList(
					"Break",
					"Phone",
					"Teammate",
					"Visitor",
					"Other"
			);
	
	@FXML
	public Label userLabel;
	@FXML
	public Label box4Title;
	@FXML
	public TextField usernameField;
	@FXML
	public TextField passwordField;
	@FXML 
	public TextField otherText;
	@FXML
	public Button loginButton;
	@FXML
	public Button StartButton;
	@FXML
	public Button EndButton;
	@FXML
	public Label loginLabel;
	@FXML 
	public ComboBox<String> ProjectBox;
	@FXML 
	public ComboBox<String> LCBox;
	@FXML
	public ComboBox<String> EffortBox;
	@FXML
	public ComboBox<String> DeliverBox;
	

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
			//Send fields to temp user, for validiation.
           
			tempUser.setName(username);
			tempUser.setPassword(password);
            //Input Validation
            isValid = validate.returnValidity(tempUser);
            if(isValid == false) {
                loginLabel.setText("Invalid username type, try again");
            }
            //end of Input Validation
            //Login
            if (Authorization.Login(username, password)) {
            	//If valid, assign currUser to the logged in user.
            	currUser.setRank(User.database.get(User.findUser(username)).getRank());
            	currUser.setCodeName(User.database.get(User.findUser(username)).getCodeName());
                activeCodeName = currUser.getCodeName();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.FXML"));
                Parent root = loader.load();
                SceneController mainController = loader.getController();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                // Invalid login, notify user.
                loginLabel.setText("Invalid Username / Password");
            }
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	// Sets the users active code name
	  public void setActiveCodeName() {
	      userLabel.setText("Logged in as: " + currUser.getCodeName());
	    }
	  
	//Handles the logout process.
	public void switchToLoginScreen(ActionEvent event) throws IOException
	{
		//Clear user data.
		currUser = new User("", "", 1, 00000, "EMP000");
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
		//Checks if the user has the correct rank to access.
		if(Authorization.AssertRank(currUser, 2))
		{
			//Loads PP.
			Parent root = FXMLLoader.load(getClass().getResource("PlanningPoker.FXML"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
	}
	
	//Updates the lists to reflect alternate values
	public void UpdateLists() 
	{	
		ProjectBox.setItems(options1);
		ProjectBox.setValue(ProjectBox.getItems().get(0));
		if(ProjectBox.getValue() == "Business Project")
		{
			LCBox.setItems(options2_B);
			LCBox.setValue(LCBox.getItems().get(0));
		}
		else
		{
			LCBox.setItems(options2_D);
			LCBox.setValue(LCBox.getItems().get(0));
		}
		
		
		
		EffortBox.getItems().addAll(options3);
		EffortBox.setValue(EffortBox.getItems().get(0));
		box4Title.setText(EffortBox.getValue());
		DeliverBox.setDisable(false);
		otherText.setDisable(true);
		if(EffortBox.getValue() == "Plans")
		{
			DeliverBox.setItems(options4_1);
			DeliverBox.setValue(DeliverBox.getItems().get(0));
		}
		else if(EffortBox.getValue() == "Deliverables")
		{
			DeliverBox.setItems(options4_1);
			DeliverBox.setValue(DeliverBox.getItems().get(0));
		}
		else if(EffortBox.getValue() == "Interuptions")
		{
			DeliverBox.setItems(options4_1);
			DeliverBox.setValue(DeliverBox.getItems().get(0));
		}
		else
		{
			//NULL
		}
		
	}
	
	public void UpdateLists(ActionEvent event) throws IOException
	{
		if(event.getSource().equals(ProjectBox))
		{
			if(ProjectBox.getValue() == "Business Project")
			{
				LCBox.setItems(options2_B);
				LCBox.setValue(LCBox.getItems().get(0));
			}
			else
			{
				LCBox.setItems(options2_D);
				LCBox.setValue(LCBox.getItems().get(0));
			}
		}
		
		else
		{
			box4Title.setText(EffortBox.getValue());
			DeliverBox.setDisable(false);
			otherText.setDisable(true);
			if(EffortBox.getValue() == "Plans")
			{
				DeliverBox.setItems(options4_1);
				DeliverBox.setValue(DeliverBox.getItems().get(0));
			}
			else if(EffortBox.getValue() == "Deliverables")
			{
				DeliverBox.setItems(options4_2);
				DeliverBox.setValue(DeliverBox.getItems().get(0));
			}
			else if(EffortBox.getValue() == "Interuptions")
			{
				DeliverBox.setItems(options4_3);
				DeliverBox.setValue(DeliverBox.getItems().get(0));
			}
			else
			{
				//TEXT
				DeliverBox.setDisable(true);
				otherText.setDisable(false);
				
			}
		}
		
		
	}
	
	//Start EffortLog
	public void StartLog(ActionEvent event) throws IOException
	{
		Log.tempStartTime = LocalTime.now();
		Log.running = true;
		System.out.println("Started Log.");
	}
	
	//End EffortLog
	public void EndLog(ActionEvent event) throws IOException
	{
		if(Log.running == false) return;
		
		System.out.println("Ending Log.");
		String field1, field2, field3, field4;
		field1 = ProjectBox.getValue();
		field2 = LCBox.getValue();
		field3 = EffortBox.getValue();
		if(field3 == "Defects")
		{
			field4 = otherText.getText();
			DefectLog newLog = new DefectLog();
			newLog.setProject(field1);
			newLog.setLCS(field2);
			newLog.setDefectCategory(field4);
			newLog.setResolved(false);
			newLog.SetStartTime(Log.tempStartTime);
			newLog.SetEndTime();
			Log.defectLogs.add(newLog);
			 
		}
		else if(field3 == "Others")
		{
			field4 = otherText.getText();
			EffortLog newLog = new EffortLog();
			newLog.setProject(field1);
			newLog.setLCS(field2);
			newLog.setEffortCategory(field3);;
			newLog.setEffortType(field4);
			newLog.SetStartTime(Log.tempStartTime);
			newLog.SetEndTime();
			Log.effortLogs.add(newLog);
		}
		else
		{
			field4 = DeliverBox.getValue();
			EffortLog newLog = new EffortLog();
			newLog.setProject(field1);
			newLog.setLCS(field2);
			newLog.setEffortCategory(field3);;
			newLog.setEffortType(field4);
			newLog.SetStartTime(Log.tempStartTime);
			newLog.SetEndTime();
			Log.effortLogs.add(newLog);
		}
		
		System.out.println(Log.getEffortLogs());
		System.out.println(Log.getDefectLogs());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(userLabel != null)
		{
			setActiveCodeName();
			UpdateLists();
		}
		
	}
}

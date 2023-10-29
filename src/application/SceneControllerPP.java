/*Controller for EffortLogger JavaFX.
 * This controls the .
 * Collaborators: Andrew Hejl
 * 		-Initial commit 
 * */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class SceneControllerPP implements Initializable
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	private ActivityItem ActiveItem;
	
	@FXML
	public ChoiceBox<String> activitySelector;
	@FXML
	public TextField estimateBox;
	@FXML
	public TextField criteriaBox;
	@FXML
	public TextField newItemBox;
	@FXML
	public Button newItemButton;
	@FXML
	public Button newEstimateButton;
	@FXML
	public Label highCard;
	@FXML
	public Label lowCard;
	@FXML
	public Label estimate;
	@FXML
	public Label criteriaList;
	
	
	//Method to return to main application screen.
	public void switchToMainScreen(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("Main.FXML"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	public void createNewItem(ActionEvent event) throws IOException
	{
		String input = newItemBox.getText();
		ActivityItem.PPDatabase.add(new ActivityItem(input));
		newItemBox.clear();
		updateList();
	}
	
	public void pushNewEstimate(ActionEvent event) throws IOException
	{
		int newEstimate = Integer.parseInt(estimateBox.getText());
		String newCriteriaString = criteriaBox.getText();
		ActiveItem.AddEstimate(newEstimate);
		ActiveItem.AddCriteria(newCriteriaString);
		ActiveItem.createCard();
		estimateBox.clear();
		criteriaBox.clear();
	}
	
	public void updateList() 
	{
		if(ActivityItem.PPDatabase.isEmpty())
		{
			return;
		}
		for(int i = 0 ; i < ActivityItem.PPDatabase.size() ; i++)
		{
			activitySelector.getItems().add(ActivityItem.PPDatabase.get(i).getName());
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

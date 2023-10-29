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
		setActiveItem();
		if(ActiveItem.equals(null))
		{
			return;
		}
		
		int newEstimate = Integer.parseInt(estimateBox.getText());
		String newCriteriaString = criteriaBox.getText();
		ActiveItem.AddEstimate(newEstimate);
		ActiveItem.AddCriteria(newCriteriaString);
		estimateBox.clear();
		criteriaBox.clear();
		showActivityItem();
	}
	
	public void updateList() 
	{
		if(ActivityItem.PPDatabase.isEmpty())
		{
			return;
		}
		activitySelector.getItems().clear();
		for(int i = 0 ; i < ActivityItem.PPDatabase.size() ; i++)
		{
			activitySelector.getItems().add(ActivityItem.PPDatabase.get(i).getName());
		}
		
	}
	
	public void showActivityItem() throws IOException
	{
		setActiveItem();
		String newHigh = Integer.toString(ActiveItem.getCard().getHighCard());
		String newLow = Integer.toString(ActiveItem.getCard().getLowCard());
		String newAvg = Double.toString(ActiveItem.getCard().getAverage());
		highCard.setText(newHigh);
		lowCard.setText(newLow);
		estimate.setText(newAvg);
			
		//Planning Poker Card DONE
			
		//Start on Criteria...
		String newCriteria = ActiveItem.getCriteria();
		System.out.println(newCriteria);
		criteriaList.setText(newCriteria);
		
	}
	
	public void showActivityItem(ActionEvent event) throws IOException
	{
		setActiveItem();
		String newHigh = Integer.toString(ActiveItem.getCard().getHighCard());
		String newLow = Integer.toString(ActiveItem.getCard().getLowCard());
		String newAvg = Double.toString(ActiveItem.getCard().getAverage());
		highCard.setText(newHigh);
		lowCard.setText(newLow);
		estimate.setText(newAvg);
			
		//Planning Poker Card DONE
			
		//Start on Criteria...
		criteriaList.setText("<No current criteria>");
		String newCriteria = ActiveItem.getCriteria();
		System.out.println(newCriteria);
		criteriaList.setText(newCriteria);
		
	}
	
	private void setActiveItem()
	{
		int index = ActivityItem.findItem(activitySelector.getValue());
		System.out.println(index);
		if(index == -1)
		{
			ActiveItem = null;
		}
		else
		{
			//Value found, update items...
			ActiveItem = ActivityItem.PPDatabase.get(index);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

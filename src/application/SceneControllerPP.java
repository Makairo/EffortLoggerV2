/*
 * Controller for EffortLogger JavaFX.
 * This controls the .
 * Collaborators: Andrew Hejl
 * 		-Initial commit 
 * */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    public Button searchButton;
	@FXML
	public Label highCard;
	@FXML
	public Label lowCard;
	@FXML
	public Label estimate;
	@FXML
	public Label criteriaList;
	@FXML
	public Text criteriaLabel;
	@FXML
	public Button effortLogs;
	@FXML
	public Button defectLogs;

	
	
	//Method to return to main application screen.
	public void switchToMainScreen(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("Main.FXML"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	//Create item button handler
	public void createNewItem(ActionEvent event) throws IOException
	{
		String input = newItemBox.getText();
		ActivityItem.PPDatabase.add(new ActivityItem(input));
		newItemBox.clear();
		updateList();
	}
	
	public void showEffortLogs(ActionEvent event) throws IOException
	{
		criteriaLabel.setText("Effort Logs");
		String newCriteria = Log.getEffortLogs();
		System.out.println(newCriteria);
		criteriaList.setText(newCriteria);
		mainPaneUpdate();
	}
	
	public void showDefectLogs(ActionEvent event) throws IOException
	{
		criteriaLabel.setText("Defect Logs");;
		String newCriteria = Log.getDefectLogs();
		System.out.println(newCriteria);
		criteriaList.setText(newCriteria);
		mainPaneUpdate();
	}
	
	//Push New Estimate button handler
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
	
	//Helper method for updating the dropdown menu.
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
	
	//Helper method to display values associated with the Planning Poker Card.
	public void showActivityItem() throws IOException
	{
		//Get the Active Item to be displayed.
		setActiveItem();
		criteriaLabel.setText("Criteria List");
		
		//Conversions, set values.
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
		mainPaneUpdate();
	}
	
	//Helper method to display values associated with the Planning Poker Card.
	//Called by the "Show" button
	public void showActivityItem(ActionEvent event) throws IOException
	{
		//Get the Active Item to be displayed.
		setActiveItem();
				
		//Conversions, set values.
		String newHigh = Integer.toString(ActiveItem.getCard().getHighCard());
		String newLow = Integer.toString(ActiveItem.getCard().getLowCard());
		String newAvg = Double.toString(ActiveItem.getCard().getAverage());
		highCard.setText(newHigh);
		lowCard.setText(newLow);
		estimate.setText(newAvg);
					
		//Planning Poker Card DONE
					
		//Start on Criteria...
		criteriaLabel.setText("Criteria List");
		String newCriteria = ActiveItem.getCriteria();
		System.out.println(newCriteria);
		criteriaList.setText(newCriteria);
		mainPaneUpdate(); 
		
	}
	
	//Helper method to get the current selected item.
	private void setActiveItem()
	{
		int index = ActivityItem.findItem(activitySelector.getValue());
		System.out.println(index);
		if(index == -1)
		{
			//Set to null if there is no item in list.
			ActiveItem = null;
		}
		else
		{
			//Value found, update items...
			ActiveItem = ActivityItem.PPDatabase.get(index);
		}
	}

	public void searchBacklogItems(ActionEvent event) throws IOException {
        // Example usage
		System.out.println("Searching Backlog Items...");
        String itemName = "Example Item";
        int targetEstimate = 5;

        List<ActivityItem> foundItems = BackLogItem.searchItems(itemName, targetEstimate);

        // Display the details of the found items using BacklogItem.displayItemDetails
        for (ActivityItem item : foundItems) {
            BackLogItem.displayItemDetails(item);
        }
    }
	
	public void mainPaneUpdate() 
	{
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

}

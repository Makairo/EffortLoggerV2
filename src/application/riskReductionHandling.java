package application;

public class riskReductionHandling
{
	//Counter SQL Injection: Jerry
	
	//Proper Input Validation: Alice
	
	//Restricting Dangerous File Upload: Gavin
	
	//Ensuring and Requiring Authentication: Andrew
	public static int RequestRank(User inUser)
	{
		return inUser.getRank();
	}
	
	public static int RequestId(User inUser)
	{
		return inUser.getID();
	}
	
	public static Boolean AssertRank(User inUser, int rank) 
	{
		return inUser.getRank() == rank;
	}
	
	//Ensuring Anonymity: Kyle

	private TextField nameInput;
	private Label resultLabel;
	
	// Changes employee name to a "code name" to prevent personal data from being leaked
	// Allows admins to submit feedback to code name instead of personal name
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Employee Name Changer");

		// Input employee's name to be changed
		
		nameInput = new TextField();
		nameInput.setPromptText("Enter Employee Name");

		// Process for changing employee name to code name
		
		Button changeNameButton = new Button("Change Name");
		changeNameButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String employeeName = nameInput.getText();
				String newName = "EMP123";		// Can be replaced by userinput, just a place holder
				resultLabel.setText("Employee Name changed to: " + newName);
			}
		});
		
		// Prints old name and new name to align for Admin's sake
		
		Button printNamesButton = new Button("Print Names");
		printNamesButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String employeeName = nameInput.getText();
				String newName = "EMP123";
				System.out.println("Old Name: " + employeeName);
				System.out.println("New Name: " + newName);
			}
		});

		resultLabel = new Label("");
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(nameInput, changeNameButton, printNamesButton, resultLabel);
		vbox.setAlignment(javafx.geometry.Pos.CENTER);
		StackPane root = new StackPane();
		root.getChildren().add(vbox);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}

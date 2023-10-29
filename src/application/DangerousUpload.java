//GAVIN LODDER, DANGEROUS UPLOAD MITIGATION
package application;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DangerousUpload extends Application {

    // list of approved file types
    private final List<String> approvedFileTypes = Arrays.asList("pdf", "gdoc", "docx");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Upload Prototype");

        // create a filechooser to select files with pdf, gdoc, and docx extensions
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF, Google Docs, and Word Files", "*.pdf", "*.gdoc", "*.docx"));

        // create a button for file upload
        Button uploadButton = new Button("Upload File");
        uploadButton.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                String fileName = file.getName();
                String fileExtension = getFileExtension(fileName);

                // check if the selected file type is in the approved list
                if (approvedFileTypes.contains(fileExtension.toLowerCase())) {
                    // actions to save or add to files can be added here later 
                    // for now, it will just print a message letting the user know that their file has been uploaded
                    System.out.println("File uploaded successfully: " + fileName);
                    showAlert("File uploaded successfully.", AlertType.INFORMATION);
                } else {
                	// on the off chance another file type besides the specified is able to be uploaded, it will print file type not supported
                    showAlert("File type not supported.", AlertType.ERROR);
                }
            }
        });

        // create a simple layout
        VBox vbox = new VBox(uploadButton);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // extract the file extension from a filename to check the type
    private String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex > 0) {
            return filename.substring(dotIndex + 1);
        }
        return "";
    }

    // show an alert dialog with a given message either information or error
    private void showAlert(String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

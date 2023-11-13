package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class scene6Controller {
	@FXML
	public Stage stage;
	public Scene scene;
	public Parent root;
	
	
	// Scene 6

	@FXML
	public Label name_label;
	@FXML
	public Label id_label;
	@FXML
	public Label maj_label;
	@FXML
	public Label majOrjob_label;
	
	// Scene 5 
	@FXML
	private ImageView dropbox_imageview;
	@FXML
	private ImageView card_imageview;
	@FXML
	private Image myImage = new Image(getClass().getResourceAsStream("profil_blank.png"));
	@FXML
	public Image imageData;


	@FXML
	public void switchToScene1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void displayStudent(String first, String last,String ID, String major) { 
		name_label.setText(first+" "+last);
		id_label.setText(ID);
		majOrjob_label.setText("Major:");
		maj_label.setText(major);
	}
	
	public void displayFaculty(String first, String last,String ID, String job) {
		name_label.setText(first+" "+last);
		id_label.setText(ID);
		majOrjob_label.setText("Job:");
		maj_label.setText(job);
	}
	
	
	
	
    
	// Scene 5 controller 
	@FXML
	public void handleDragOver(DragEvent event) {
		if(event.getDragboard().hasFiles()) {
			event.acceptTransferModes(TransferMode.ANY);
		}
	}
	
	@FXML
	public void handleDrop(DragEvent event) throws IOException{
		List<File> files = event.getDragboard().getFiles();
		imageData = new Image(new FileInputStream(files.get(0)));
		dropbox_imageview.setImage(imageData);
		imageData = dropbox_imageview.getImage();
		
	}
	
	
}
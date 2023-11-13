package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class scene1Controller implements Initializable{
	@FXML
	public Stage stage;
	public Scene scene;
	public Parent root;
	
	
	public void switchToScene1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
		
	public void switchToScene2(ActionEvent event) throws IOException {
		
		
		root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void switchToScene4(ActionEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToScene5(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene5.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToScene7(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene7.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void invalid_category(ActionEvent event) throws IOException{
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/*
	dropbox_imageview.setOnDragOver(new EventHandler() {
				   public void handle(DragEvent event) {
				      if (event.getDragboard().hasFiles()) {
				         event.acceptTransferModes(TransferMode.ANY); 
				      }
				      event.consume();
				   }
			});
				   
			event.acceptTransferModes(TransferMode.ANY);
			dropbox_imageview.setOnDragDropped(new EventHandler&lt;DragEvent&gt;() {
				    public void handle(DragEvent event) {
				        List&lt;File&gt; files = event.getDragboard().getFiles();
				        System.out.println("Got " + files.size() + " files");
				        imageView.setImage(new Image(new FileInputStream(files.get(0))));

				        event.consume();
				     }
				});
	
	*/
	

}
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

public class scene7Controller implements Initializable{
	@FXML
	public Stage stage;
	@FXML
	public Scene scene;
	@FXML
	public Parent root;
	@FXML
	public Label False_label;
	@FXML
	public TextField search_box;
	
	@FXML
	public Label Name_label;
	@FXML
	public Label ID_label;
	@FXML
	public Label Sex_label;
	@FXML
	public Label Age_label;
	@FXML
	public Label Department_label;
	@FXML
	public Label gradOrund_label;
	@FXML
	public Label academicYear_label;
	
	@FXML
	public Label Job_label;
	@FXML
	public Label yearsWorked_label;

	
	public void switchToScene1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
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
	
	public void switchToIDscene(ActionEvent event) throws IOException {
		String idInput = search_box.getText();
		int idValue = functions.getId(idInput);
		if (idValue!=0) {
			int sOrf = (idValue/1000000000);
			if (sOrf==1) {
				root = FXMLLoader.load(getClass().getResource("Scene8.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				
				String name = functions.getName(idInput);
				System.getProperty("MY_STRING1", name);
				Name_label.setText("Jack Yohn");
				idTranslate(idValue);
				ID_label.setText(idInput);
				String ageString = System.getProperty("MY_INT1");
				Age_label.setText(ageString);
				String sexString = System.getProperty("MY_INT2");
				Sex_label.setText(sexString);
				String depString = System.getProperty("MY_INT3");
				Department_label.setText(depString);
				String gradOrundString = System.getProperty("MY_INT4");
				gradOrund_label.setText(gradOrundString);
				String academicYearString = System.getProperty("MY_INT5");
				academicYear_label.setText(academicYearString);
				
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}else if(sOrf==2) {
				switchToScene9(event);
				String name = functions.getName(idInput);
				System.setProperty("MY_STRING1", name);
				Name_label.setText("Jack Yohn");
				idTranslate(idValue);
				ID_label.setText(idInput);
				String ageString = System.getProperty("MY_INT1");
				Age_label.setText(ageString);
				String sexString = System.getProperty("MY_INT2");
				Sex_label.setText(sexString);
				String jobString = System.getProperty("MY_INT6");
				Job_label.setText(jobString);
				String yearsWorkedString = System.getProperty("MY_INT7");
				yearsWorked_label.setText(yearsWorkedString);
			}
			
			
		}else {
			False_label.setText("Invalid ID input try again");
			switchToScene7(event);
		}
	}
	
	public void switchToScene8(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene8.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToScene9(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene9.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	// 10 digits each
	//sOrf,0,0,dig4=year,dig5=grad/und,maj_dep,0,sex,age,age    
    //sOrf,0,0,dig4&dig5=job,years,years,sex,age,age
	public void idTranslate(int id) throws IOException {
		int previous=0;
		int age = id%100;
		String ageString = Integer.toString(age);
		System.setProperty("MY_INT1", ageString);
		previous +=age;
		int sex =((id%1000)-previous)/100;
		String sexString = Integer.toString(sex);
		System.setProperty("MY_INT2", sexString);
		previous+= (sex*100);
		int sOrf= id/1000000000;
		
		if (sOrf==1) {
			int dep = ((id%100000)-previous)/10000;
			previous+= (dep*10000);
			String depString = Integer.toString(dep);
			System.setProperty("MY_INT3", depString);
			previous+= (dep*10000);
			int gradOrund = ((id%1000000)-previous)/100000;
			previous+= (gradOrund*100000);
			String gradOrundString = Integer.toString(gradOrund);
			System.setProperty("MY_INT4", gradOrundString);
			int year = ((id%10000000)-previous)/1000000;
			previous+= (year*1000000);
			year = previous/1000000;
			String yearString = Integer.toString(year);
			System.setProperty("MY_INT5", yearString);
			
		}else if (sOrf==2) { 
			int years = ((id%1000000)-previous)/10000;
			String workString = Integer.toString(years);
			System.setProperty("MY_INT6", workString);
			previous+= (years*10000);			
			int job = ((id%10000000)-previous)/1000000;
			previous+= (job*1000000);
			job = previous/1000000;
			String jobString = Integer.toString(job);
			System.setProperty("MY_INT7", jobString);
		}
		
	}
	
	
	
	public void invalid_category(ActionEvent event) throws IOException{
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
        Name_label.setText("Initial Text");
        ID_label.setText("Initial Text");
        Sex_label.setText("Initial Text");
        Age_label.setText("Initial Text");
        Department_label.setText("Initial Text");
        gradOrund_label.setText("Initial Text");
        academicYear_label.setText("Initial Text");
        Job_label.setText("Initial Text");
        yearsWorked_label.setText("Initial Text");
	}
	
	
	
	

}
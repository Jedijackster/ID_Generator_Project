package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class scene2Controller implements Initializable{
	@FXML
	public Stage stage;
	public Scene scene;
	public Parent root;
	
	
	//for functions
	@FXML
	public TextField First_name_box;
	@FXML
	public TextField Last_name_box;
	@FXML
	private ComboBox<String> Age_choice;
	@FXML
	public CheckBox Male_check;
	@FXML
	public CheckBox Fem_check;
	@FXML
	private ComboBox<String> Academic_year_choice;
	@FXML
	//private String[] academicYear = {"Freshmen","Sophomore","Junior","Senior","Graduate"};
	String ageString;
	String academic_year;
	
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
	
	public void switchToScene3(ActionEvent event) throws IOException {
		//start of environment variable for name
		String first_name = First_name_box.getText();
        System.setProperty("MY_STRING1", first_name);
        String last_name =  Last_name_box.getText();
        System.setProperty("MY_STRING2", last_name);
		//For age field
        select_age(event);
        //For sex field
        int sex = 0;
        if (Male_check.isSelected()==true) {
        	sex = 1;
        }else if (Fem_check.isSelected()==true) {
        	sex = 2;
        }else if ((Fem_check.isSelected()==false)&&(Male_check.isSelected()==false)) {
        	switchToScene2(event);
        	// invalid_input();
        }
        String sex_inp=Integer.toString(sex);
        System.setProperty("MY_INT2", sex_inp);
        //for academicYear
        select_academ(event);
        //for gradOrund
        if (academic_year == "Graduate") {
        	System.setProperty("MY_STRING3", academic_year);
        	int gradOrund = 1;
        	String gradOrundString=Integer.toString(gradOrund);
            System.setProperty("MY_INT3", gradOrundString);
        }else if((academic_year.isBlank()==false)&&(academic_year!="Graduate")) {
        	System.setProperty("MY_STRING3", academic_year);  
        	int gradOrund = 0;
        	String gradOrundString=Integer.toString(gradOrund);
            System.setProperty("MY_INT3", gradOrundString);
        }else if (academic_year.isEmpty()==true) {
        	switchToScene2(event);
        }
        
        
		root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void invalid_category(ActionEvent event) throws IOException{
		
	}

	public void select_age(ActionEvent event) throws IOException{
		ageString = Age_choice.getSelectionModel().getSelectedItem().toString();
		System.setProperty("MY_INT1", ageString);
	}
	public void select_academ(ActionEvent event) throws IOException{
		academic_year = Academic_year_choice.getSelectionModel().getSelectedItem().toString();
        System.setProperty("MY_STRING4", academic_year);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		ObservableList<String> listage = FXCollections.observableArrayList("13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90");
		Age_choice.setItems(listage);
		ObservableList<String> AcademYear = FXCollections.observableArrayList("Freshmen","Sophomore","Junior","Senior","Graduate");
		Academic_year_choice.setItems(AcademYear);
	}


	
}
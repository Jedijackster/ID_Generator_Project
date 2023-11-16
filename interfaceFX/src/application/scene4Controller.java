package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

public class scene4Controller implements Initializable{
	@FXML
	public Stage stage;
	public Scene scene;
	public Parent root;
	
	
	//for functions
	@FXML
	ImageView myImageView;
	@FXML
	private Image myImage = new Image(getClass().getResourceAsStream("profil_blank.png"));
	
	@FXML
	private TextField First_name_box;
	@FXML
	private TextField Last_name_box;
	@FXML
	private ComboBox<String> Age_choice;
	@FXML
	private CheckBox Male_check;
	@FXML
	private CheckBox Fem_check;
	@FXML 
	private ComboBox<String> Profession_choice;
	@FXML
	private ComboBox<String> Years_worked;
	
	String ageString;
	String professionString;
	String yearsString;
	
	public void switchToScene1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
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
	
	public void switchToScene6(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene6.fxml"));	
		root = loader.load();	
		String first_name = First_name_box.getText();
        String last_name =  Last_name_box.getText();
		
        select_age(event);
		int age = Integer.parseInt(System.getProperty("MY_INT1"));
		
		int sex = 0;
        if (Male_check.isSelected()==true) {
        	sex = 1;
        }else if (Fem_check.isSelected()==true) {
        	sex = 2;
        }else if ((Fem_check.isSelected()==false)&&(Male_check.isSelected()==false)) {
        	switchToScene4(event);
        	// invalid_input();
        }
        select_profession(event);
		professionString = System.getProperty("MY_STRING1");
		
		select_worked(event);
		yearsString = System.getProperty("MY_INT2");
		int years = Integer.parseInt(yearsString);
		
		
		faculty id1 = new faculty();
		id1.first_name = first_name;
		id1.last_name = last_name;
		id1.age = age;
		id1.sOrf = 2;
		id1.sex = sex;
		id1.job = professionString;
		id1.years = years;
		id1.id = functions.id_gen_staff(2,sex,age,professionString,years,id1);
		
		String idString = Integer.toString(id1.id);
		
		scene6Controller scene6Controller = loader.getController();
		scene6Controller.displayFaculty(first_name, last_name, idString, professionString);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		
		stage.show();
	}
	
	public void select_age(ActionEvent event) throws IOException{
		ageString = Age_choice.getSelectionModel().getSelectedItem().toString();
		System.setProperty("MY_INT1", ageString);
		
	}
	public void select_profession(ActionEvent event) throws IOException{
		professionString = Profession_choice.getSelectionModel().getSelectedItem().toString();
		System.setProperty("MY_STRING1", professionString);
	}
	public void select_worked(ActionEvent event) throws IOException{
		yearsString = Years_worked.getSelectionModel().getSelectedItem().toString();
		System.setProperty("MY_INT2", yearsString);
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		ObservableList<String> listage = FXCollections.observableArrayList("13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90");
		Age_choice.setItems(listage);
		ObservableList<String> listjobs = FXCollections.observableArrayList("Accountant", "Administrative Assistant", "Admissions Officer", "Athletic Coach", "Cafeteria Staff", "Career Counselor", "Event Planner", "Facilities Manager", "Financial Aid Counselor", "Groundskeeper", "Human Resources Manager", "IT Support Specialist", "Lab Technician", "Librarian", "Professor", "Public Relations Specialist", "Registrar", "Research Assistant", "Security Officer", "Student Affairs Coordinator");
		Profession_choice.setItems(listjobs);
		ObservableList<String> listyears = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40");
		Years_worked.setItems(listyears);
	}
	
	
}
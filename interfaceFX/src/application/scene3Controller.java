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

public class scene3Controller implements Initializable{
	@FXML
	public Stage stage;
	public Scene scene;
	public Parent root;
	
	
	//for functions
	@FXML
	public ComboBox<String> Major_choice;
	@FXML
	public ComboBox<String> Department_choice;
	@FXML
	private String[] Department = {"College of Architechture","College of Business",
			"College of Education", "College of Engineering","College of Liberal Arts",
			"College of Nursing and Health","College of Science", "School of Social Work"};
	String department;
	String maj_specify;

	public void switchToScene1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToScene3(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void switchToScene6(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene6.fxml"));	
		root = loader.load();	

		// Opens environment variable to transport from void functions and scene2Controller
		String first_name = System.getProperty("MY_STRING1");
		String last_name = System.getProperty("MY_STRING2");
		String ageString = System.getProperty("MY_INT1");
		String sexString = System.getProperty("MY_INT2");
		String yearString = System.getProperty("MY_STRING3");
		String gradOrundString= System.getProperty("MY_INT3");
		// translates into integers for id generator use
		int age = Integer.parseInt(ageString);
		int sex = Integer.parseInt(sexString);
		int gradOrund = Integer.parseInt(gradOrundString);
		
		select_depart(event);
		department = System.getProperty("MY_STRING4");
		select_major(event);
		maj_specify = System.getProperty("MY_STRING5");
		
		student id1 = new student();
		id1.first_name = first_name;
		id1.last_name = last_name;
		id1.age = age;
		id1.sOrf = 1;
		id1.sex = sex;
		id1.majdep = department;
		id1.majfoc = maj_specify;
		id1.academyear = yearString;
		id1.gradOrund = gradOrundString;
		id1.id = functions.id_gen_student(1, sex, age, gradOrund, department, id1);
		
		String idString = Integer.toString(id1.id);
		functions.storeStudent(id1);
		
		scene6Controller scene6Controller = loader.getController();
		
		scene6Controller.displayStudent(first_name,last_name, idString, maj_specify);
		
		//root = FXMLLoader.load(getClass().getResource("Scene6.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void invalid_category(ActionEvent event) throws IOException{
		
	}
	
	
	public void select_depart(ActionEvent event) {
		department = Department_choice.getSelectionModel().getSelectedItem().toString();
        System.setProperty("MY_STRING4", department);
	}
	public void select_major(ActionEvent event) {
		maj_specify = Major_choice.getSelectionModel().getSelectedItem().toString();
        System.setProperty("MY_STRING5", maj_specify);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		ObservableList<String> Departments = FXCollections.observableArrayList("College of Architechture","College of Business","College of Education", "College of Engineering","College of Liberal Arts","College of Nursing and Health","College of Science", "School of Social Work");
		Department_choice.setItems(Departments);
		ObservableList<String> MajList = FXCollections.observableArrayList("Accounting","Aerospace Engineering","Anthropology","Architecture","Biochemistry","Biology","Business Administration","Chemical Engineering","Chemistry","Civil Engineering","Communications","Computer Engineering","Computer Science","Criminal Justice","Economics","Electrical Engineering","Elementary Education","English","Environmental Science","Finance","Graphic Design","History","Human Resource Management","Industrial Engineering","Information Technology","International Relations","Journalism","Kinesiology","Linguistics","Management","Marketing","Mathematics","Mechanical Engineering","Microbiology","Music","Nursing","Nutrition","Philosophy","Physics","Political Science","Psychology","Public Health","Public Relations","Social Work","Sociology","Software Engineering","Spanish","Sports Management","Statistics","Supply Chain Management","Theater","Urban Planning","Veterinary Medicine","Web Development","Zoology");
		Major_choice.setItems(MajList);
	}
	
}
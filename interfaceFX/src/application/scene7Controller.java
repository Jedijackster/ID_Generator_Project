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

public class scene7Controller {
	
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
	public Label Name_labelStudent;
	@FXML
	public Label Name_labelFaculty;
	@FXML
	public Label ID_labelStudent;	
	@FXML
	public Label ID_labelFaculty;
	@FXML
	public Label Sex_labelStudent;	
	@FXML
	public Label Sex_labelFaculty;
	@FXML
	public Label Age_labelStudent;
	@FXML
	public Label Age_labelFaculty;
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
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene8.fxml"));	
				root = loader.load();
				scene7Controller controller = loader.getController();

				String name = functions.getName(idInput);
				controller.Name_labelStudent.setText(name);
				/*String getName = Name_labelStudent.getText();
				System.out.println(getName);*/
				
				idTranslate(idValue);
				controller.ID_labelStudent.setText(idInput);
				String ageString = System.getProperty("MY_INT1");
				controller.Age_labelStudent.setText(ageString);
				String sexString = System.getProperty("MY_INT2");
				controller.Sex_labelStudent.setText(sexString);
				String depString = System.getProperty("MY_INT3");
				controller.Department_label.setText(depString);
				String gradOrundString = System.getProperty("MY_INT4");
				controller.gradOrund_label.setText(gradOrundString);
				String academicYearString = System.getProperty("MY_INT5");
				controller.academicYear_label.setText(academicYearString);
				
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();

			}else if(sOrf!=1) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene9.fxml"));	
				root = loader.load();
				scene7Controller controller = loader.getController();
				
				String name = functions.getName(idInput);
				controller.Name_labelFaculty.setText(name);
				idTranslate(idValue);
				controller.ID_labelFaculty.setText(idInput);
				String ageString = System.getProperty("MY_INT1");
				controller.Age_labelFaculty.setText(ageString);
				String sexString = System.getProperty("MY_INT2");
				controller.Sex_labelFaculty.setText(sexString);
				String yearsWorkedString = System.getProperty("MY_INT6");
				controller.yearsWorked_label.setText(yearsWorkedString);
				String jobString = System.getProperty("MY_INT7");
				controller.Job_label.setText(jobString);
				
				
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
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
		String sexString = sexSelect(sex);
		System.setProperty("MY_INT2", sexString);
		previous+= (sex*100);
		int sOrf= id/1000000000;
		
		if (sOrf==1) {
			
			
			int dep = ((id%100000)-previous)/10000;
			previous+= (dep*10000);
			previous+= (dep*10000);
			String depString = depSelect(dep);
			System.setProperty("MY_INT3", depString);
			int gradOrund = ((id%1000000)-previous)/100000;
			previous+= (gradOrund*100000);
			String gradOrundString = gradOrundSelect(gradOrund);
			System.setProperty("MY_INT4", gradOrundString);
			int year = ((id%10000000)-previous)/1000000;
			previous+= (year*1000000);
			year = previous/1000000;
			String yearString = yearSelect(year);
			System.setProperty("MY_INT5", yearString);
			
		}else if (sOrf!=1) { 
			int years = ((id%10000)-previous)/1000;
			previous+= (years*1000);
			String workString = Integer.toString(years);
			System.setProperty("MY_INT6", workString);
			int job = ((id%1000000)-previous)/100000;
			previous+= (job*1000000);
			String jobString = jobSelect(job);
			System.out.println(jobString);
			System.setProperty("MY_INT7", jobString);
		}
		
	}
	
	public String depSelect(int dep) {
		String department ="";
		
		if (dep ==1) {
			department ="College of Architechture";
		}else if(dep ==2) {
			department ="College of Business";
		}else if(dep ==3) {
			department ="College of Education";
		}else if(dep ==4) {
			department ="College of Engineering";
		}else if(dep ==5) {
			department ="College of Liberal Arts";
		}else if(dep ==6) {
			department ="College of Nursing and Health";
		}else if(dep ==7) {
			department ="College of Science";
		}else if(dep ==8) {
			department ="School of Social Work";
		}
		return department;
	}
	
	public String sexSelect(int sex) {
		String sexString = "";
		if (sex ==1) {
			sexString = "Male";
		}else if(sex ==2) {
			sexString = "Female";
		}
		
		return sexString;
	}

	public String gradOrundSelect(int gradOrund) {
		String gradOrundString = "";
		
		if (gradOrund ==1) {
			gradOrundString = "Undergraduate student";
		}else if (gradOrund ==2) { 
			gradOrundString = "Graduate student";
		}
		
		return gradOrundString;
	}
	
	public String yearSelect(int year) {
		String yearString = "";
		
		if (year ==1) {
			yearString = "Freshman";
		}else if (year==2) {
			yearString = "Sophomore";
		}else if (year==3) {
			yearString = "Junior";
		}else if (year==4) {
			yearString = "Senior";
		}
		return yearString;
	}
	
	public String jobSelect(int job) {
		String jobString="";
		if (job ==1) {
			jobString = "Accountant";
		}else if (job ==2) {
			jobString = "Administrative Assistant";
		}else if (job ==3) {
			jobString ="Admissions Officer";
		}else if (job ==4) {
			jobString = "Athletic Coach";
		}else if (job ==5) {
			jobString = "Cafeteria Staff";
		}else if (job ==6) {
			jobString = "Career Counselor";
		}else if (job ==7) {
			jobString = "Event Planner";
		}else if (job ==8) {
			jobString = "Facilities Manager";
		}else if (job ==9) {
			jobString = "Financial Aid Counselor";
		}else if (job ==10) {
			jobString = "Groundskeeper";
		}else if (job ==11) {
			jobString = "Human Resources Manager";
		}else if (job ==12) {
			jobString = "IT Support Specialist";
		}else if (job ==13) {
			jobString = "Lab Technician";
		}else if (job ==14) {
			jobString = "Librarian";
		}else if (job ==15) {
			jobString = "Professor";
		}else if (job ==16) {
			jobString = "Public Relations Specialist";
		}else if (job ==17) {
			jobString = "Registrar";
		}else if (job ==18) {
			jobString = "Research Assistant";
		}else if (job ==19) {
			jobString = "Security Officer";
		}else if (job ==20) {
			jobString = "Student Affairs Coordinator";
		}
		
		
		return jobString;
	}
	
	public void invalid_category(ActionEvent event) throws IOException{
		
	}
	
	

}
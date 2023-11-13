package application;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;

public class functions {

    // Stores member data to database.txt
    static void storeStudent(student object){
        try{
            File database = new File("database.txt");
            database.createNewFile();
            FileWriter Writer = new FileWriter("database.txt");
            String data = object.createDisplay();
            Writer.append(data);
            Writer.close();
        }
        catch(IOException e){
            System.out.println("Could not open database.txt");

        }

    }
    static void storeFaculty(faculty object){
        try{
            File database = new File("database.txt");
            database.createNewFile();
            FileWriter Writer = new FileWriter("database.txt");
            String data = object.createDisplay();
            Writer.append(data);
            Writer.close();
        }
        catch(IOException e){
            System.out.println("Could not open database.txt");

        }

    }

    public static int id_gen_staff(int sOrf,int sex,int age,String job, int years,faculty object) { 
        
        int dig5 = job_search(object);
        //sOrf,0,0,dig4&dig5=job,0,years,years,sex,age,age
        int id = sOrf*1000;
        id += dig5;
        id = id * 10;
        id = id * 10;
        id += years;
        id = id * 10;
        id += sex;
        id = id * 100;
        id += age;     
           
        return id;
    }
    
    static int id_gen_student(int sOrf,int sex,int age,int gradOrund, String department,student object) { 
        
        int dig4=0,dig5=0;
        /* maj_dep calls dep_search that takes String input from combobox on scene3 
        and assigns a digit in the id to show what department the students major is in */
        int maj_dep= dep_search(object);;
       
        //dig4 for year, dig5 for if grad=2 or under=1
        if("Graduate".equals(object.academyear)) {
        	dig4 = 0;
           	dig5 = 2;
        }else if ("Senior".equals(object.academyear)) {
        	dig4 = 4;
            dig5 = 1;
        }else if ("Junior".equals(object.academyear)) {
        	dig4 = 3;
            dig5 = 1;
        }else if ("Sophomore".equals(object.academyear)) {
        	dig4 = 2;
            dig5 = 1;
        }else if ("Freshmen".equals(object.academyear)) {
        	dig4 = 1;
            dig5 = 1;
        }
        
        
        //sOrf,0,0,dig4=year,dig5=grad/und,maj_dep,0,sex,age,age         
        int id = sOrf*1000;
        id += dig4;
        id = id*10;
        id += dig5;
        id = id * 10;
        id += maj_dep;
        id = id * 10;
        //id += stval2;
        id = id * 10;
        id += sex;
        id = id * 100;
        id += age;
        
        return id;
    }
    
    public static int getId(String ID) throws IOException {
    	BufferedReader reader1 = new BufferedReader(new FileReader("database.txt"));  
    	int IDNum=0;
    	String line1 = reader1.readLine();   
    	int lineNum = 1;  
    	boolean areEqual = false;
    	while (line1 != null) {
    		if (line1.equals(ID) || line1.equalsIgnoreCase(ID)) {
    		    areEqual = true; 
    		    break;
    		}
    		line1 = reader1.readLine();
    	    lineNum++;
    	}
    	if(areEqual==true){
    	    System.out.println("This is the ID you're looking for");
    	    ID = line1;
    	} else {
    		
    	    System.out.println("This is not the ID you're looking for");
    	    
    	}
    	reader1.close();
    	
    	IDNum = Integer.parseInt(ID);
    	return IDNum;
    }
    
    public static String getName(String ID) throws IOException{
    	BufferedReader reader1 = new BufferedReader(new FileReader("database.txt"));  
    	String name="";
    	String line1 = reader1.readLine();   
    	int lineNum = 1;  
    	boolean areEqual = true;
    	while (line1 != null || ID != null){
    		if(line1 == ID){
    			areEqual = false; 
    	        break;
    		} else if(! line1.equalsIgnoreCase(ID)) {
    			areEqual = false; 
    	        break;
    	    }
    	    line1 = reader1.readLine();  
    	    lineNum++;
    	}
    	if(areEqual){
    	    System.out.println("This is the ID you're looking for");
    	    name = Files.readAllLines(Paths.get("database.txt")).get(lineNum+1);
    	    
    	} else {
    		
    	    System.out.println("This is not the ID you're looking for");
    	    
    		
    	}
    	reader1.close();
    	return name; 
    }
    
    public static String getMaj(String ID) throws IOException{
    	BufferedReader reader1 = new BufferedReader(new FileReader("database.txt"));  
    	String major="";
    	String line1 = reader1.readLine();   
    	int lineNum = 1;  
    	boolean areEqual = true;
    	while (line1 != null || ID != null){
    		if(line1 == ID){
    			areEqual = false; 
    	        break;
    		} else if(! line1.equalsIgnoreCase(ID)) {
    			areEqual = false; 
    	        break;
    	    }
    	    line1 = reader1.readLine();  
    	    lineNum++;
    	}
    	if(areEqual){
    	    System.out.println("This is the ID you're looking for");
    	    major = Files.readAllLines(Paths.get("database.txt")).get(lineNum+2);
    	    
    	} else {
    		
    	    System.out.println("This is not the ID you're looking for");
    	    
    	}
    	reader1.close();
    	
    	return major;
    }
    	
  	
  	
    public static int job_search(faculty object) {
    	int job = 0;

    	if ("Accountant".equals(object.job)) {
    	    job += 1;
    	} else if ("Administrative Assistant".equals(object.job)) {
    	    job += 2;
    	} else if ("Admissions Officer".equals(object.job)) {
    	    job += 3;
    	} else if ("Athletic Coach".equals(object.job)) {
    	    job += 4;
    	} else if ("Cafeteria Staff".equals(object.job)) {
    	    job += 5;
    	} else if ("Career Counselor".equals(object.job)) {
    	    job += 6;
    	} else if ("Event Planner".equals(object.job)) {
    	    job += 7;
    	} else if ("Facilities Manager".equals(object.job)) {
    	    job += 8;
    	} else if ("Financial Aid Counselor".equals(object.job)) {
    	    job += 9;
    	} else if ("Groundskeeper".equals(object.job)) {
    	    job += 10;
    	} else if ("Human Resources Manager".equals(object.job)) {
    	    job += 11;
    	} else if ("IT Support Specialist".equals(object.job)) {
    	    job += 12;
    	} else if ("Lab Technician".equals(object.job)) {
    	    job += 13;
    	} else if ("Librarian".equals(object.job)) {
    	    job += 14;
    	} else if ("Professor".equals(object.job)) {
    	    job += 15;
    	} else if ("Public Relations Specialist".equals(object.job)) {
    	    job += 16;
    	} else if ("Registrar".equals(object.job)) {
    	    job += 17;
    	} else if ("Research Assistant".equals(object.job)) {
    	    job += 18;
    	} else if ("Security Officer".equals(object.job)) {
    	    job += 19;
    	} else if ("Student Affairs Coordinator".equals(object.job)) {
    	    job += 20;
    	}

    	return job;
    }
   
    public static int dep_search(student object) {
    	try {
    		int dep=0;
        	
        	if (("College of Architechture".equals(object.majdep))==true) {
        		dep +=1;
        	}else if(("College of Business".equals(object.majdep))==true) {
        		dep +=2;
        	}else if(("College of Education".equals(object.majdep))==true) {
        		dep +=3;
        	}else if(("College of Engineering".equals(object.majdep))==true) {
        		dep +=4;
        	}else if(("College of Liberal Arts".equals(object.majdep))==true) {
        		dep +=5;
        	}else if(("College of Nursing and Health".equals(object.majdep))==true) {
        		dep +=6;
        	}else if(("College of Science".equals(object.majdep))==true) {
        		dep +=7;
        	}else if(("School of Social Work".equals(object.majdep))==true) {
        		dep +=8;
        	}
        	return dep;
    	}
    	catch (Exception e){
    		System.out.println(e);
    	}
		return 0;
    	
    }
}

package project;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
public class functions {
    static void id_tran(int[] id){ //translates id# values into strings for use in classes
        
    }
    
    // function that returns an array of objects that has first part of user info
    // will modify code to write object to file
    void storeStudent(student object){
        try{
            File database = new File("database.txt");
            database.createNewFile();
            FileWriter Writer = new FileWriter("database.txt");
            String data = object.createDisplay();
            Writer.write(data);
        }

    }
// Left off here - tried to store user info as printable array of objects 
// Reevaluate because you will need to replace with user input from buttons and text boxes anyway
// Translating user input from numbers to strings is dumb
    // second part of user info
    static Object info_arr2(Object[] arr,int sOrf){
        int oglen = arr.length;
        int targlen = 0;
        if(sOrf==1){
            targlen = oglen+4;
            for (int i = oglen; i < targlen; i++){

            }
        } else if(sOrf==2){
            targlen = oglen+1;
            for (int i = oglen; i < targlen; i++){
                
            }
        }


        return arr;
    }
    
    static int maj_ret(int inp_val){ // Returns major for id_gen
        Scanner temp_store = new Scanner(System.in); 
        int majspec=0;
        if (inp_val == 1) {
            System.out.println("Enter Engineering major:\n1) CSE\n2) AeroSpace\n3) EE\n4) Other");
            majspec = temp_store.nextInt();
            
        }else if(inp_val == 2) {
            System.out.println("Enter Liberal Arts major:\n1)");
            majspec = temp_store.nextInt();
        } else if(inp_val == 3) {  
            System.out.println("Enter Science:\n1)");
            majspec = temp_store.nextInt();
        } else {
            System.out.println("Bad input");
        }

        temp_store.close();
        return majspec;
    }

    static int id_gen_staff(int sOrf,int sex,int age, faculty object) { 
        Scanner temp_store = new Scanner(System.in);
        int stval1=0, stval2=0; 
        int dig4=0,dig5=0;
        System.out.println("Here are your input options:\n1) Professor\2)Other\nInput job here: ");
        int job = temp_store.nextInt();
        if (job ==1){ 
            dig4 = 1;
            object.job = "Professor";
        } else if (job==2){
            dig4=2;
            System.out.println("Specify: ");
            object.job = temp_store.nextLine();
        }
        dig5=0;

        //sOrf,0,0,dig4=year,dig5=grad/und,maj_dep,major,sex,
        //int intarray[] = {sOrf,0,0,dig4,dig5,stval1,stval2,sex,age_det(age)};
        int id = sOrf*1000;
        id += dig4;
        id = id*10;
        id += dig5;
        id = id * 10;
        id += stval1;
        id = id * 10;
        id += stval2;
        id = id * 10;
        id += sex;
        id = id * 100;
        id += age%100;
        temp_store.close();   
        return id;
    }
    static int id_gen_student(int sOrf,int sex,int age, student object) { 
        Scanner temp_store = new Scanner(System.in);
        int stval1=0, stval2=0; 
        
        int dig4=0,dig5=0;
        System.out.println("Here are your input options:\n1-4: Freshman-Senior Undergrad\n5-8: Freshman-Senior Graduate");
        System.out.println("Give your academic year: "); 
        int year = temp_store.nextInt();
        object.year = year;
        System.out.println("Here are your input options:\n1) Engineering\n2) Liberal Arts\n3) Science\n 4)Other");
        System.out.println("Give your major department: ");
        stval1= temp_store.nextInt();
        if(stval1 == 1)
        {
            object.majdep = "Engineering";
        }
        else if(stval1== 2)
        {
            object.majdep = "Liberal Arts";
        }
        else if(stval1 == 3)
        {
            object.majdep= "Science";
        }
        else
        {
            System.out.println("Specify");
            object.majdep = temp_store.nextLine();
        }
        stval2 = maj_ret(stval1);
        switch (year) { //dig1 for year, dig2 for if grad=1 or under=0
            case 1: 
            dig4=1;dig5=0;break;
            case 2:
            dig4=2;dig5=0;break;
            case 3:
            dig4=3;dig5=0;break;
            case 4:
            dig4=4;dig5=0;break;
            //no longer undergrad
            case 5:
            dig4=1;dig5=1;break;
            case 6:
            dig4=2;dig5=1;break;
            case 7:
            dig4=3;dig5=1;break;
            case 8: 
            dig4=4;dig5=1;break;
            default:
            break;
        }
        if(dig5 == 1)
        {
            object.gradOrund = "Graduate";
        }
        else
        {
            object.gradOrund = "Undergraduate";
        }
		/*
		 * //sOrf,0,0,dig4=year,dig5=grad/und,maj_dep,major,sex, //int intarray[] =
		 * {sOrf,0,0,dig4,dig5,stval1,stval2,sex,age_det(age)};
		 */        
        int id = sOrf*1000;
        id += dig4;
        id = id*10;
        id += dig5;
        id = id * 10;
        id += stval1;
        id = id * 10;
        id += stval2;
        id = id * 10;
        id += sex;
        id = id * 100;
        id += age%100;
        temp_store.close();   
        return id;
    }
}

import java.util.Scanner;


public class functions {
    static void id_tran(int[] id){ //translates id# values into strings for use in classes
        
    }
    
    // function that returns an array of objects that has first part of user info
    static Object[] info_arr1(String name, int age,int sex, int sOrf){
        Object[] ret ={};
        if(name != null && !name.isEmpty()){ret[0] = name;}
        if((age>0)&&(age<100)){ret[1]=age;}
        if(sex==1){ret[2]="Male";}  else if(sex==2){ret[2]="Female";}
        if(sOrf==1){ret[3]="Student";} else if(sOrf==2){ret[3]="Staff";}

        return ret;
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

    static void print_info(Object[] arr){ //unused as of rn,
        for(int i=0; i<arr.length; ){
            switch(i+1){
                case 1: 
                System.out.println("Name: ");
                break;
                case 2:
                System.out.println("Age: ");
                break;
                case 3:
                System.out.println("Sex: ");
                break;
            }
            System.out.print(arr[i]);
        }
    }
    
    
    static int age_det(int age){
        int num=0;
        int i=0;
        do{
            i++;
        }while(i!=age);
        num = i/10;
        return num;
    }

    static int year() {
        Scanner temp_store = new Scanner(System.in);
        System.out.println("Here are your input options:\n1-4: Freshman-Senior Undergrad\n5-8: Freshman-Senior Graduate");
        System.out.println("Give your academic year: "); 
        int year = temp_store.nextInt();
        temp_store.close();
        return year;
    }

    // function that houses all the questions and returns their answers as int
    static int maj_dep(){ // not used rn, probably should cut it out
        Scanner temp_store = new Scanner(System.in);
        System.out.println("Here are your input options:\n1) Engineering\n2) Liberal Arts\n3) Science");
        System.out.println("Give your major department: ");
        int maj= temp_store.nextInt();
        
        temp_store.close();
        return maj;
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

    static int[] id_gen(int sOrf,int sex,int age) { 
        Scanner temp_store = new Scanner(System.in);
        int stval1=0, stval2=0; 
        
        int dig4=0,dig5=0;
        
        if (sOrf==1) {// Not done
            System.out.println("Here are your input options:\n1-4: Freshman-Senior Undergrad\n5-8: Freshman-Senior Graduate");
            System.out.println("Give your academic year: "); 
            int year = temp_store.nextInt();
            System.out.println("Here are your input options:\n1) Engineering\n2) Liberal Arts\n3) Science");
            System.out.println("Give your major department: ");
            stval1= temp_store.nextInt();
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
            

        } else if (sOrf==2) {// dig4 for if Professor or not dig5 not used
            System.out.println("Here are your input options:\n1) Professor\n2) Faculty\nInput job here: ");
            int job = temp_store.nextInt();
            if (job ==1){ 
                dig4 = 1;
            } else if (job==2){
                dig4=2;
            }
            dig5=0;
        }

        //sOrf,0,0,dig4=year,dig5=grad/und,maj_dep,major,sex,
        int intarray[] = {sOrf,0,0,dig4,dig5,stval1,stval2,sex,age_det(age)};
        temp_store.close();   
        return intarray;
    }
}

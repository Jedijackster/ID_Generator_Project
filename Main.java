
import java.util.Scanner;
    


public class Main {
    public static void main(String[] args) throws Exception{ 
        Scanner temp_store = new Scanner(System.in);
        int sOrf = 0, sex = 0;
        int ver =0;
        int age = 0;
        System.out.println("Give your name: ");
        String name = temp_store.nextLine(); 

        System.out.println("Give your age: ");
        age = temp_store.nextInt(); 
        while(age <0)
        {
            System.out.println("Invalid Input, Try Again");
            age = temp_store.nextInt(); 
        }
        
        
        ver =0;
        do{
            System.out.println("Here are your input options:\n1) Male\n2) Female");
            System.out.println("Input here: ");
            sex = temp_store.nextInt();
            if (sex==1){
                ver =1;

            }else if(sex==2){
                ver =1;
            }else {continue;}
        }while(ver!=1);

        ver =0;
        do{
            System.out.println("Here are your input options:\n1) Student\n2) Faculty");
            System.out.println("Input here: ");
            sOrf = temp_store.nextInt();
            if (sOrf==1){
                ver =1;
            }else if(sOrf==2){
                ver =1;
            }else {continue;}
        }while(ver!=1);
        // Student or faculty var
        if (sOrf==1){
            student id1 = new student();
            id1.name = name;
            id1.age = age;
            if(sex == 1)
            {
                id1.sex ="Male";
            }
            else
            {
                id1.sex= "Female";
            }
            id1.id = functions.id_gen_student(sOrf,sex,id1.age, id1); // Takes inputs for id# generator 
            id1.display();
        } else if (sOrf==2){
            faculty id1 = new faculty();
            id1.name = name;
            id1.age = age;
            if(sex == 1)
            {
                id1.sex ="Male";
            }
            else
            {
                id1.sex= "Female";
            }
            id1.id = functions.id_gen_staff(sOrf,sex,age,id1); // Takes inputs for id# generator
            id1.display();
        }
        
        System.out.println("\nName:"+name+"\nAge:"+age);
        
        
        //inp_print(name,age,maj); 
        
        
        temp_store.close();
    }
}
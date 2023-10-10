
import java.util.Scanner;
import functions;
    
    class member{
        public String name;
        public int age;
        public int sex;

        class student extends member{
            public int majdep;
            public int majfoc;
            public int year;
            public int gradOrund;
        }

        class faculty extends member{
            public int job;
        }   
    }

public class Main {
    public static void main(String[] args) throws Exception{ 
        Scanner temp_store = new Scanner(System.in);
        int sOrf = 0, sex = 0;
        int ver =0;
        int[] idnum ={};

        System.out.println("Give your name: ");
        String name = temp_store.nextLine(); 

        System.out.println("Give your age: ");
        int age = temp_store.nextInt(); 
        
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
        
    
        member indiv1 = new member();
        if (sOrf==1){
            member.student id1 = indiv1.new student();
            id1.name = name;
            id1.age = age;
            id1.sex = sex;
            idnum = functions.id_gen(sOrf,id1.sex,id1.age); // Takes inputs for id# generator 
        } else if (sOrf==2){
            member.faculty id1 = indiv1.new faculty();
            id1.name = name;
            id1.age = age;
            id1.sex = sex;
            idnum = functions.id_gen(sOrf,id1.sex,id1.age); // Takes inputs for id# generator
        }
        
        System.out.println("\nName:"+name+"\nAge:"+age);
        System.out.print("\nID #: ");
        for (int i = 0; i< idnum.length; i++) { //Prints out each element of the id array
            System.out.print(idnum[i]);
        }
        //inp_print(name,age,maj); 
        
        
        temp_store.close();
    }
}
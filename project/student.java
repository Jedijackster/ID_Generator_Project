package project;
public class student extends member{
        public String majdep;
        public int majfoc;
        public int year;
        public String gradOrund;
        public void display() {
        	super.display();
        	System.out.println(", "+majdep+", "+majfoc+", "+year+", "+gradOrund);;
        }
    }

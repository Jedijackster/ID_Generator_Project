package project;
public class student extends member{
        public String majdep;
        public int majfoc;
        public int year;
        public String gradOrund;
        public String createDisplay() {
        	String returnString = super.createDisplay() + ", "+majdep+", "+majfoc+", "+year+", "+gradOrund;
        	return returnString;
        }
        public void display()
        {
            System.out.println(createDisplay());
        }
    }

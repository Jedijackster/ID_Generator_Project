package application;
public class student extends member{
		
        public String majdep;
        public String majfoc;
        public String academyear;
        public String gradOrund;
       /* public String createDisplay() {
        	String returnString = super.createDisplay() +majdep+", "+majfoc+", "+academyear+", "+gradOrund;
        	return returnString;
        }*/
        public void display()
        {
            System.out.println(createDisplay());
        }
    }

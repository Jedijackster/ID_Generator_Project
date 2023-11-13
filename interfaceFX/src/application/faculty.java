package application;
public class faculty extends member{
    public String job;
    public int years;
    /*public String createDisplay() {
        String returnString = super.createDisplay() + ", "+job;
        return returnString;
    }*/
    public void display()
    {
        System.out.println(createDisplay());
    }
}  

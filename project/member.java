package project;
public class member{
    public String name;
    public int age;
    public String sex;
    public int id;
    public String createDisplay() {
    	String returnString= (name+", "+age+", "+sex+", "+id);
        return returnString;
    }

 
}
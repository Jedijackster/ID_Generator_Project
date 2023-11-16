package application;
public class member{
    public String first_name;
    public String last_name;
    public String name= first_name+" "+last_name;
    public int age;
    public int sex;
    public int id;
	public int sOrf;
    public String createDisplay() {
    	String idString= Integer.toString(id);
    	String returnString = ("\n"+idString);
        return returnString;
    }
    public String createDisplay2() {
    	String returnString2= ("\n"+first_name+" "+last_name);
        return returnString2;
    }
 
}
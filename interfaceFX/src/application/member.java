package application;
public class member{
    public String first_name;
    public String last_name;
    public String name= first_name+" "+last_name;
    public int age;
    public int sex;
    public int id;
	public int sOrf;
    // fix createDisplay so sex is converted from int to String for returnString.
    public String createDisplay() {
    	String returnString= (id+" \n"+name+"\n ");
        return returnString;
    }

 
}
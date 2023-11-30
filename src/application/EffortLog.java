//EffortLog for use with EffortLogger and Planning Poker
//Extends Log.java
//Collaborators: Andrew Hejl
package application;

public class EffortLog extends Log
{
	private String effortCategory;
	private String effortType;
	
	public EffortLog()
	{
		effortCategory = "";
		effortType = "";
	}
	
	public EffortLog(String inDesc)
	{
		effortCategory = "";
		effortType = "";
	}
	
	public String getEffortCategory()
	{
		return effortCategory;
	}
	
	public void setEffortCategory(String input)
	{
		effortCategory = input;
	}
	
	public String getEffortType()
	{
		return effortType;
	}
	
	public void setEffortType(String input)
	{
		effortType = input;
	}
	
	public String toString()
	{
		return "Effort Log[" + this.getID() +"]:\n" +
		"Project: " + this.getProject() + "\n" +
		"Life Cycle Step: " + this.getLCS() + "\n" +
		"Effort Type: " + this.getEffortType() + "\n" +
		"Effort Category: " + this.getEffortCategory() + "\n";
	}
}
//DefectLog for use with EffortLogger and Planning Poker
//Extends Log.java
//Collaborators: Andrew Hejl
package application;

public class DefectLog extends Log
{
	private String defectCategory;
	private Boolean resolved;
	
	public DefectLog()
	{
		defectCategory = "";
		resolved = false;
	}
	
	public DefectLog(String inDesc)
	{
		defectCategory = "";
		resolved = false;
	}
	
	public Boolean isResolved()
	{
		return resolved;
	}
	
	public void setResolved(Boolean input)
	{
		resolved = input;
	}
	
	public String getDefectCategory()
	{
		return defectCategory;
	}
	
	public void setDefectCategory(String input)
	{
		defectCategory = input;
	}
	
	public String toString()
	{
		return "Effort Log[" + this.getID() +"]:\n" +
		"Project: " + this.getProject() + "\n" +
		"Life Cycle Step: " + this.getLCS() + "\n" +
		"Resolved?: " + this.isResolved() + "\n" +
		"Defect Category: " + this.getDefectCategory() + "\n";
	}
}


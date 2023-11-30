//Base Log class for use with EffortLogger and Planning Poker
//Collaborators: Andrew Hejl
package application;

import java.time.LocalTime;
import java.util.ArrayList;


public class Log
{
	public static Boolean running = false;
	public static LocalTime tempStartTime = LocalTime.MIN;
	//Temp database for effort and defect logs.
	public static ArrayList<EffortLog> effortLogs = new ArrayList<EffortLog>();
	public static ArrayList<DefectLog> defectLogs = new ArrayList<DefectLog>();
	//Static counter, no dupe IDs.
	private static int IDCounter = 1;
	
	private int LogID;
	private String project;
	private String LCS;
	private LocalTime StartTime;
	private LocalTime EndTime;
	
	public Log()
	{
		this.LogID = IDCounter++;
		this.project = "EMPTY LOG";
		this.LCS = "EMPTY LOG";
		this.StartTime = LocalTime.MIN;
		this.EndTime = LocalTime.MIN;
	}
	
	public Log(String in1, String in2)
	{
		this.LogID = IDCounter++;
		this.project = in1;
		this.LCS = in2;
		this.StartTime = LocalTime.MIN;
		this.EndTime = LocalTime.MIN;
	}
	
	public int getID()
	{
		return this.LogID;
	}
	
	public String getProject()
	{
		return this.project;
	}
	
	public String getLCS()
	{
		return this.LCS;
	}
	
	public String getStartTime()
	{
		return this.StartTime.toString();
	}
	
	public String getEndTime()
	{
		return this.EndTime.toString();
	}
	
	public void setProject(String in)
	{
		this.project = in;
	}
	
	public void setLCS(String in)
	{
		this.LCS = in;
	}
	
	public void SetStartTime()
	{
		this.StartTime = LocalTime.now();
	}
	
	public void SetStartTime(LocalTime time)
	{
		this.StartTime = time;
	}
	
	public void SetEndTime()
	{
		this.EndTime = LocalTime.now();
	}

	public static String getEffortLogs()
	{
		String val = "";
		for(int i = 0 ; i < effortLogs.size() ; i++)
		{
			val += effortLogs.get(i).toString();
		}
		return val;
	}
	
	public static String getDefectLogs()
	{
		String val = "";
		for(int i = 0 ; i < defectLogs.size() ; i++)
		{
			val += defectLogs.get(i).toString();
		}
		return val;
	}
	
	public static void AddEffortLog(EffortLog input)
	{
		effortLogs.add(input);
	}
	
	public static void AddDefectLog(DefectLog input)
	{
		defectLogs.add(input);
	}
	
}


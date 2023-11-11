package application;

import java.time.LocalTime;
import java.util.ArrayList;


public class Log
{
	//Temp database for effort and defect logs.
	public static ArrayList<Log> effortLogs;
	public static ArrayList<Log> defectLogs;
	//Static counter, no dupe IDs.
	private static int IDCounter = 1;
	
	private int LogID;
	private String desc;
	private LocalTime StartTime;
	private LocalTime EndTime;
	
	public Log()
	{
		this.LogID = IDCounter++;
		this.desc = "EMPTY LOG";
	}
	
	public Log(String inDesc)
	{
		this.LogID = IDCounter++;
		this.desc = inDesc;
	}
	
	public int getID()
	{
		return this.LogID;
	}
	
	public String getDesc()
	{
		return this.desc;
	}
	
	public String getStartTime()
	{
		return this.StartTime.toString();
	}
	
	public String getEndTime()
	{
		return this.EndTime.toString();
	}
	
	public void setDesc(String inDesc)
	{
		this.desc = inDesc;
	}
	
	public void SetStartTime()
	{
		this.StartTime = LocalTime.now();
	}
	
	public void SetEndTime()
	{
		this.EndTime = LocalTime.now();
	}
}


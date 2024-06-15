/**
 * Name: Naylene Rondon
 * 
 * Florida Tech CIS 2503
 * 7.5 Programming Assignment
 * 
 * Date Last Modified: 2/24/24
 * 
 * Purpose:
 * Amusement class to define ride type, waits, duration, and capacity
 */
public class Amusement extends Thread
{
	//variables
private String rideType;
private int waiting;
private int riding;
private int capacity;
private long duration; //in milliseconds
private boolean running = false;

//Gets
public String getType()
{
	return rideType;
}

public int getWait()
{
	return waiting;
}

public int getRide()
{
	return riding;
}

public int getCapacity()
{
	return capacity;
}

public long getDuration()
{
	return duration;
}

public boolean getRun()
{
	return running;
}

//Sets
public void setType(String ride)
{
	rideType = ride;
}

public void setWait(int wait)
{
	waiting = wait;
}

public void setRide(int ride)
{
	riding = ride;
}

public void setCapacity(int cap)
{
	capacity = cap;
}

public void setDuration(long millisecond)
{
	duration = millisecond;
}

public void setRun(boolean run)
{
	running = run;
}

public void run() //override run function 
{
	running = true;
	try 
	{
		sleep(duration);
	} catch (InterruptedException e) 
	{
		e.printStackTrace();
	}
	running = false;
}


//Allows declaration
public Amusement (
		String rideType,
		int capacity,
		long duration
		)
{
	this.rideType = rideType;
	this.capacity = capacity;
	this.duration = duration;
}


}

/**
 * Name: Naylene Rondon
 * 
 * Florida Tech CIS 2503
 * 7.5 Programming Assignment
 * 
 * Date Last Modified: 2/24/24
 * 
 * Purpose:
 * Regularly updates the amount of people waiting in line
 */

//imports
import java.util.*;

public class ThemePark extends Thread
{
	//Variables
	public static ArrayList <Amusement> rides= new ArrayList<Amusement>();
	public static Queue <Integer> attendees = new LinkedList <Integer> ();
	
	public static void main (String[]args) //main
	{

		//Local variables for user command
		String userCommand = "";
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		//Add Amusements
		Amusement horses = new Amusement("Carousel",57,1500);
		Amusement bigFoot = new Amusement("Roller Coaster",23,1000);
		Amusement dashing = new Amusement("Bumper Cars",33,1500);
		Amusement cryptKeeper = new Amusement("Tower Drop",24,5000);
		Amusement chaos = new Amusement("Children Coaster",51,1000);
		
		rides.add(horses);
		rides.add(bigFoot);
		rides.add(dashing);
		rides.add(cryptKeeper);
		rides.add(chaos);
		
		
		
		
		for (int i = 0; i < rides.size()*2; i++) //add random numbers under 1000 for the amount of people waiting
		{
			int randomNumber = random.nextInt(1, 1000);
			attendees.add(randomNumber);
		}
		
		
		initalWaits();//Set Initial Wait values
		while(true)
		{
			rideCheck();
			System.out.println("Type End to Stop. Type anything else to continue \n");
			userCommand = input.nextLine();
			if (userCommand.equalsIgnoreCase("END"))//check for user input
			{
				break;
			}
		}
	}
	
	public static void initalWaits() //initiate waits
	{
		System.out.println("Morning wait Times: ");
		for (Amusement ride : rides) //Sets wait times for all the rides
		{
			Thread thread = new Thread(ride);
			thread.start();
			
			ride.setWait(attendees.poll());
			System.out.println(ride.getType() + " has a " + ride.getWait() + " people waiting.");
		}
		System.out.println();
	}
	
	public static void rideCheck() //checks if the ride is running, if not begins the ride
	{
		System.out.println("Live Updates: ");
		for (Amusement ride : rides)
		{
			
			if(ride.getRun()==false) //ride is not running
			{
				ride.run();
				attendees.add(ride.getRide());
				if (ride.getWait() > ride.getCapacity()) //adjust the waiting value based off capacity and whether the ride is full or not
				{
					ride.setRide(ride.getCapacity());
					ride.setWait(ride.getWait()-ride.getCapacity());
				}
				else 
				{
					ride.setRide(ride.getWait());
				}
				ride.setWait(ride.getWait()+attendees.poll());
				System.out.println(ride.getType() + " has a " + ride.getWait() + " people waiting.");
			}
			else //Just gets the wait time
			{
				System.out.println(ride.getType() + " has a " + ride.getWait() + " people waiting.");
			}
		}
		

	}
}

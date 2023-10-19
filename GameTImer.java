import java.io.IOException;
import java.lang.String;

public class GameTimer 
{
	public static void main(String[] args)
	{
		int time = 30;

		while(time >= 0)
		{
			//Display countdown image for the current time
			System.out.println(time + " seconds left.");

			//Do the delay 
			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{}

			//Decrement the time remaining in the timer.
			time--;
		}
	}
}







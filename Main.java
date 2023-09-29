import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		//Create a SplashScreen Object
		SplashScreen splashScreen = new SplashScreen();

		//Creates an EntryScreen Object
		EntryScreen entryScreen = new EntryScreen();

		//Creates a DataBaseConnector Object
		DatabaseConnector database = new DatabaseConnector("jdbc:postgresql://db.gkeebcixaqkelmnqriql.supabase.co:5432/postgres",
		"postgres", "UA7ashu40JCkUNHwYymL");

		try {
            // Make photon image appear for 3 seconds before disappearing
            Thread.sleep(3000);
            splashScreen.dispose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		//Connect to the server
		udpBaseServer_2.baseServer();

		//Connect to the database
		database.connect();

	}


}

//To Do list:
//1. We need to figure out how to connect the database with the entryscreen.
//2. Need to find a way to delay the entry screen until after the splashscreen.



import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		//Create a SplashScreen Object
		SplashScreen splashScreen = new SplashScreen();


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

		//Creates an EntryScreen Object
		EntryScreen entryScreen = new EntryScreen();

		//Connect to the server
		udpBaseServer_2.baseServer();

		//Connect to the database
		database.connect();

		// Player player1 = new Player(1, "Jimmy", "Neutron", "Alpha");
		// database.addPlayer(player1);

		// database.searchByID(1);
		// database.searchByID(2);


	}


}
//To Do list:
//1. We need to figure out how to connect the database with the entryscreen.



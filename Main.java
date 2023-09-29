import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		SplashScreen splashScreen = new SplashScreen();
		EntryScreen entryScreen = new EntryScreen();
		try {
            // Make photon image appear for 3 seconds before disappearing
            Thread.sleep(3000);
            splashScreen.dispose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		udpBaseServer_2.baseServer();
	}


}

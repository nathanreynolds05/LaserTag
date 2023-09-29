import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;

public class Main 
{
	public static void main(String[] args)
	{
		//udpBaseServer_2 serverStart = new udpBaseServer_2();
		//serverStart.serverStart();
		SplashScreen splashScreen = new SplashScreen();
		try {
            // Make photon image appear for 3 seconds before disappearing
            Thread.sleep(3000);
            splashScreen.dispose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}


}


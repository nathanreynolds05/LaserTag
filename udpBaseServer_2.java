// Java program to illustrate Server side
// Implementation using DatagramSocket
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
  
public class udpBaseServer_2
{
	public static void baseServer() throws IOException
	{
		// Step 1 : Create a socket to listen at port 1234
        DatagramSocket ds = new DatagramSocket(7500);
        byte[] receive = new byte[65535];
  
        DatagramPacket DpReceive = null;
        while (true)
        {
  
            // Step 2 : create a DatgramPacket to receive the data.
            DpReceive = new DatagramPacket(receive, receive.length);
  
            // Step 3 : revieve the data in byte buffer.
            ds.receive(DpReceive);
  
            System.out.println("Client:-" + data(receive));
  
            // Clear the buffer after every message.
            receive = new byte[65535];
        }
	}
   
    // A utility method to convert the byte array
    // data into a integer representation.
    public static int data(byte[] a)
    {
		return ByteBuffer.wrap(a).getInt();
    }
}

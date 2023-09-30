public static void baseClient() throws IOException
	{
		// Step 1:Create the socket object for
		// carrying the data.
		DatagramSocket ds = new DatagramSocket();

		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;

		// loop while user not enters "bye"
		//for loop to iterate through all elements in the arrayList
		for (int i = 0; i < info.size(); i++)
		{
			//loops over all elements in the arrayList
			//System.out.println(info.get(i));
			
			//String will take the input of whatever is in the arrayList at i
			int inp = info.get(i);
			//System.out.println("This is inp: " + inp);
			// convert the String input into the byte array.
			buf = ByteBuffer.allocate(Integer.BYTES).putInt(inp).array();
			// Step 2 : Create the datagramPacket for sending
			// the data.
			//System.out.println("This is buf: " + buf);
			DatagramPacket DpSend =
				new DatagramPacket(buf, buf.length, ip, 7500);

			// Step 3 : invoke the send call to actually send
			// the data.
			ds.send(DpSend);
		}
		

		// break the loop if user enters "bye"
		//if (inp.equals("bye"))
		
	}

//clientt.java
// A Java program for a Client
import java.net.*;
import java.io.*;

 class clientt
{
	// initialize socket and input output streams
	private Socket socket		 = null;
	private DataInputStream input = null;
	private DataOutputStream out	 = null;
		private DataInputStream in	 = null;

	// constructor to put ip address and port
	public clientt(String address, int port)
	{
		// establish a connection
		try
		{
			socket = new Socket(address, port);
			System.out.println("Connected");

			// takes input from terminal
			input = new DataInputStream(System.in);
			in = new DataInputStream(
				new BufferedInputStream(socket.getInputStream()));
			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());
		}
		catch(UnknownHostException u)
		{
			System.out.println(u);
		}
		catch(IOException i)
		{
			System.out.println(i);
		}

		// string to read message from input
		String line = "";

		// keep reading until "Over" is input
		while (!line.equals("Over"))
		{
			try
			{
				line = input.readLine();
				out.writeUTF(line);
			}
			catch(IOException i)
			{
				System.out.println(i);
			}
		}
				

System.out.println("received data");
				while (!line.equals("Over"))
			{
				try
				{
					line = in.readUTF();
					System.out.println(line);
					//data=data+line;

				}
				catch(IOException i)
				{
					System.out.println(i);
				}
			}


		// close the connection
		try
		{
			out.close();
			input.close();
			
			socket.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}

	public static void main(String args[])
	{
		clientt client = new clientt("127.0.0.1", 5000);
	}
}

//servert.java
// A Java program for a Server
import java.net.*;
import java.io.*;

 class servert
{
	//initialize socket and input stream
	private Socket		 socket = null;
	private ServerSocket server = null;
	private DataInputStream in	 = null;
	private DataOutputStream out	 = null;
	private DataInputStream input = null;

	// constructor with port
	public servert(int port)
	{
		// starts server and waits for a connection
		try
		{
			server = new ServerSocket(port);
			System.out.println("Server started");

			System.out.println("Waiting for a client ...");

			socket = server.accept();
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("Client accepted");

			// takes input from the client socket
			in = new DataInputStream(
				new BufferedInputStream(socket.getInputStream()));

			String line = ""; String data="";

			// reads message from client until "Over" is sent
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

			 data=reverse(data);
			 while (!line.equals("\n"))
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
			System.out.println("Closing connection");

			// close connection
			socket.close();
			in.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}
	 public static String reverse(String str){
    StringBuilder sb=new StringBuilder(str);
    sb.reverse();
    return sb.toString();
}

	public static void main(String args[])
	{
		servert server = new servert(5000);
	}
}

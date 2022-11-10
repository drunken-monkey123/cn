import java.util.*;
import java.io.*;
import java.net.*;
public class tcps
{
	public static void main(String args[])
	{
	try
	{
		System.out.println("==============================");
		System.out.println("Enter the port address");
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
			System.out.println("==============================");
		ServerSocket ss = new ServerSocket(n);
		Socket s = ss.accept();
			System.out.println("Receiving data from client");
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		String str = new String(dis.readUTF());
		String b="";
		for(int i=0;i<str.length();i++)
			b=str.charAt(i)+b;
			System.out.println("Sending data to client");
		out.writeUTF(b);
			System.out.println("==============================");
		ss.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}

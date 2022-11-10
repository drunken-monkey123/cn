import java.util.*;
import java.io.*;
import java.net.*;
public class tcpc
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
				System.out.println("==============================");
		Socket s = new Socket("localhost",n);
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		System.out.println("Enter the String");
		String a = sc.next();
			System.out.println("==============================");
				System.out.println("Sending data to server!!!");
		out.writeUTF(a);
		String b = new String(dis.readUTF());
			System.out.println("==============================");

			System.out.println("Receiving data from server!!!");
		System.out.println(b);
			System.out.println("==============================");
		
		s.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}

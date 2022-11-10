//client

//java tcp cli
import java.io.*;
import java.util.*;
import java.net.*;
public class c
{
	public static void main(String args[]) throws Exception
	{
		Scanner in=new Scanner(System.in);
		String x;
		try
		{
			String[] msg={"Rollno","Name","Dept","M1","M2","CGPA"};
			int i,j;
		Socket skt=new Socket("localhost",2222);
		DataOutputStream odos=new DataOutputStream(skt.getOutputStream());
		DataInputStream odis=new DataInputStream(skt.getInputStream());

		BufferedReader obr=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("--------------------------------------------------------\n");
					
		System.out.println("***Welcome to SP locker*** ");
		System.out.println("--------------------------------------------------------\n");
					
		System.out.print("enter user name :  ");
		String user = in.next();
		System.out.println();
		System.out.print("enter password :  ");
		String pass = in.next();
		System.out.println();
		System.out.println("--------------------------------------------------------\n");
	
		odos.writeUTF(user);
		odos.writeUTF(pass);
		while(true)
		{
			  String ans=odis.readUTF();
		if(ans.equals("exit"))
			break;	
		
			else if(ans.equals("e"))
			{
				System.out.println("     **Alert!!**  ");
				
				System.out.println("\nenter valid credential!!");
				System.out.println("--------------------------------------------------------\n");

				break;
			}
			else
			{
					System.out.println("--------------------------------------------------------\n");
					System.out.println("Rollno     Name          Dept     M1      M2   CGPA");
					System.out.println("--------------------------------------------------------\n");

					for(i=0;i<ans.length();i++)
					{
						if(ans.charAt(i)!=',')
						{
							System.out.print(ans.charAt(i));
						}
						else{
							System.out.print("     ");
							
						}
					}System.out.println("\n--------------------------------------------------------\n");

					System.out.println();
			}
		
		}skt.close();
	
	}catch(ConnectException ex){System.out.println("Server Not Avaliable 404 Error Found");}
	}
}
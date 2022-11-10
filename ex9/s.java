// server

//java tcp ser
import java.io.*;
import java.net.*;
import java.util.*;
public class s
{
	public static void main(String args[]) throws Exception
	{
		Scanner in=new Scanner(System.in);
		String x="";
		int b,c=0;
		try
		{
			ServerSocket skt=new ServerSocket(2222);
			Socket sk=skt.accept();
			System.out.println("Connected");
			DataInputStream odis=new DataInputStream(sk.getInputStream());
			DataOutputStream odos=new DataOutputStream(sk.getOutputStream());

			
			FileReader fr1=new FileReader("up.txt");  
		BufferedReader br1=new BufferedReader(fr1); 
String line1;
			int flag1=0,flag2=0;
				String user=odis.readUTF();
				String pass=odis.readUTF();
			
				
				while((line1=br1.readLine())!=null)  
{  
  if(user.equals(line1.substring(0,7)))
  {
	  flag1=1;
  }
	  if(pass.equals(line1.substring(8,line1.length())))
	  {
		  flag2=1;
	  }
			

}
fr1.close(); 
			if(flag1!=1&&flag2!=1)
			{
				
				odos.writeUTF("e");
				sk.close();
			
				return;
			}
				
				System.out.println("\n\n**Sending Student information to User**");	
			String file=user.substring(2,4)+".txt";

		FileReader fr=new FileReader(file);  
		BufferedReader br=new BufferedReader(fr); 
		StringBuffer sb=new StringBuffer();    
		String line;
		if(user.substring(0,2).equals("fa")){
while((line=br.readLine())!=null)  
{  
  
odos.writeUTF(line); 
}
odos.writeUTF("exit");
		}
		
		else
		{
			while((line=br.readLine())!=null)  
{  
  if(line.substring(0,3).equals(user.substring(4,user.length())))
  {
    odos.writeUTF(line); 
	break;
  }
}
odos.writeUTF("exit");
		}


sk.close();
fr.close();    

  
	
			
		}catch(EOFException exp){}
		catch(Exception ep){}
	}
}
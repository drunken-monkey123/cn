//surprice UDP S
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;
import java.lang.*;
public class udps
{

	public static String find(String s)
	{
		int b,k=0,flag=0,temp=0,cnt=0,i,j;

		String str="Not Found";

		int sm=Integer.parseInt(s.substring(s.length()-1,s.length()));
	
			System.out.println(sm);

			int[] ss=new int[sm];
			int s1=(int)Math.sqrt(sm);
			for(i=0;i<ss.length;i++)
				{
					ss[i]=Integer.parseInt(s.substring(s.length()-(sm+1)+i,s.length()-sm+i));
					
				}	
				b=s.length()-i-1;
				int b1=(int)Math.sqrt(b);
				System.out.println(b);
				int[] bb=new int[b];
			for(i=0;i<bb.length;i++)
				{
					bb[i]=Integer.parseInt(s.substring(i,i+1));
				
				}


				System.out.println("===============");
		for( i=0;i<bb.length;i++)
		{

			for( j=0;j<ss.length;j++)
		{
				
				temp=i;

				if(bb[i]==ss[j])
				{
					cnt++;
				
				if(cnt==s1)
				{
					i=i+b1-1;

					if(j==ss.length-1)
						{
						flag=1;
						str="Found";
						return str;
						}
			
						cnt=0;

				}
				else{
					i=i+1;
				
				}

				}
				

			}  cnt=0;  i=temp;
 		}

 		return str;
       
	}
	public static void main(String[] args) throws IOException
	{
		DatagramSocket ds = new DatagramSocket(1234);
		   System.out.println("Receiving data from client....");
		   	System.out.println("===============");
		
		byte[] receive = new byte[65535];
		DatagramPacket DpReceive = null;
		
		DpReceive = new DatagramPacket(receive, receive.length);
		ds.receive(DpReceive);

		String s="";
		s=(data(receive)).toString();
		System.out.println(s);
		
     String str=find(s);

		DatagramSocket dss = new DatagramSocket();
		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;
		
		buf=str.getBytes();
		DatagramPacket DpSend =new DatagramPacket(buf, buf.length, ip, 1238);
		   System.out.println("Sending data to client....");
		   	System.out.println("===============");
		dss.send(DpSend);	
	}

	public static StringBuilder data(byte[] a)
	{
		if (a == null)
			return null;
		StringBuilder ret = new StringBuilder();
		int i = 0;
		while (a[i] != 0)
		{
			ret.append((char) a[i]);
			i++;
		}
		return ret;
	}
}

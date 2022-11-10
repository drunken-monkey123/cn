//surprice UDP C

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class udpc
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
     
int b,s1,k=0,flag=0,temp=0,cnt=0,i,j;
        Scanner c = new Scanner(System.in);
        b=c.nextInt();   s1=c.nextInt();
System.out.println("===============");
        int[][] big = new int[b][b];
        int[][] small = new int[s1][s1];

        int[] bb=new int[b*b];
        int[] ss=new int[s1*s1];
        String s="";

        for( i=0;i<b;i++)
            for( j=0;j<b;j++)
                {
                big[i][j]=c.nextInt();
                bb[k++]=big[i][j];
                s=s+Integer.toString(big[i][j]);
                }
        
        System.out.println("===============");
        k=0;
        for( i=0;i<s1;i++)
            for( j=0;j<s1;j++)
                {
                small[i][j]=c.nextInt();
                ss[k++]=small[i][j];
                 s=s+Integer.toString(small[i][j]);
                }
        System.out.println("===============");
            s=s+Integer.toString(ss.length);
            


        buf = s.getBytes();
        System.out.println("Sending data to server....");
        System.out.println("===============");
        DatagramPacket DpSend =new DatagramPacket(buf, buf.length, ip, 1234);
        ds.send(DpSend);


        
        DatagramSocket dsr = new DatagramSocket(1238);
        byte[] receive = new byte[65535];
        DatagramPacket DpReceive = null;

        
        DpReceive = new DatagramPacket(receive, receive.length);
        dsr.receive(DpReceive);
          System.out.println("Receiving data from server....");
        String t="";
        t=(data(receive)).toString();
        System.out.println(t);
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

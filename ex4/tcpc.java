//client

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
class client {
   public static void main(String args[]) {
      try {

         Socket skt = new Socket("localhost", 1234);
	
	Scanner c=new Scanner(System.in);
	System.out.println("enter the data to be reversed :");
	String data=c.nextLine();
	
	 PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
         System.out.print("Sending string: '" + data + "'\n");
   out.print(data);
         out.close();
   
     //  Socket skt = new Socket("localhost", 1234);
         BufferedReader in = new BufferedReader(new
            InputStreamReader(skt.getInputStream()));
         System.out.print("Received string: '");

         while (!in.ready()) {}
         System.out.println(in.readLine()); // Read one line and output it

         System.out.print("'\n");
         in.close();
	 skt.close();
      }
      catch(Exception e) {
         System.out.print("Whoops! It didn't work!\n");
      }
   }
}

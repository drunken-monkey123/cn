//even cn surprise


//server

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;

class server {
   public static void main(String args[]) {
    
    
   
  
      try {
         ServerSocket srvr = new ServerSocket(1234);
         Socket skt = srvr.accept();
         System.out.print("Server has connected!\n");
	  BufferedReader in = new BufferedReader(new
            InputStreamReader(skt.getInputStream()));
         System.out.print("Received string: '");
		       String data="";

         while (!in.ready()) {
		 //char ch=(char)in.read();
	       // data=data+ch;

	 }
	 data=(String)in.readLine();
	 data=reverse(data);
        System.out.println("data: " +data);
         PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
       
         out.print(data);
         out.close();
         skt.close();
         srvr.close();
           System.out.print("Sending string: '" + data + "'\n");
      }
      catch(Exception e) {
         System.out.print("Whoops! It didn't work!\n");
      }
   }

   public static String reverse(String str){
    StringBuilder sb=new StringBuilder(str);
    sb.reverse();
    return sb.toString();
}
}


/*
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

         BufferedReader in = new BufferedReader(new
            InputStreamReader(skt.getInputStream()));
         System.out.print("Received string: '");

         while (!in.ready()) {}
         System.out.println(in.readLine()); 

         System.out.print("'\n");
         in.close();
	 skt.close();
      }
      catch(Exception e) {
         System.out.print("Whoops! It didn't work!\n");
      }
   }
}


*/
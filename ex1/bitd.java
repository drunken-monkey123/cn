//bitdadskjl

import java.io.*;
import java.util.*;

public class bitd {
	
public static String readFile(String fileName)throws IOException{

	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	        try {
			        StringBuilder sb = new StringBuilder();
				        String line = br.readLine();

					        while (line != null) {
							            sb.append(line);
								                sb.append("\n");
										            line = br.readLine();
										            }
						        return sb.toString();
							    } finally {
								            br.close();
									        }
}
	public static void main(String[] args) throws IOException
	{
		int i;
	     String s=readFile("bitf.txt");
	
		System.out.println("Stuffed data from client: " + s);
		String b="";
		System.out.println("Unstuffed data: ");
		int cnt = 0;
                char[] start=new char[8];
		char[] end=new char[10];
		for(i=0;i<8;i++)
		{
			start[i]=s.charAt(i);
		
		}
		int count=2,j=0,flag=1;
		String txt="";
		char test;
		String end1="";
		end1=end1+s.substring(s.length()-9,s.length()-1);
		  txt=txt+s.substring(8,s.length()-9);

		String s1=String.valueOf(start);
	
			
		String s2=String.valueOf(end1);
		String s3="01111110";
	txt=txt+s.substring(8,s.length()-9);
	

for(i=0;i<txt.length();i++)
		{
			b=b+txt.charAt(i);
			if((Integer.parseInt(String.valueOf(txt.charAt(i))))==1)
			{
				j++;
				if(j==5)
				{
					if((Integer.parseInt(String.valueOf(txt.charAt(i+1))))==0)
					{
					i++;
					j=0;
					}
					else
					{
						System.out.println("Message Error");
						return;
					}
				}
			}
			if((Integer.parseInt(String.valueOf(txt.charAt(i))))==0)
			{
				j=0;
			}
		}


//		System.out.println(s1+"\n"+s2);	
		if(s2.equals(s3)&&s1.equals(s3))
		{
//		System.out.println("hi");
		if(flag==1)
		{	
			
		for (i = 8; i < s.length() - 9; i++) {
			char ch = s.charAt(i);
			if (ch == '1') {
				cnt++;
				System.out.print(ch);

				if (cnt == 5) {
					i++;
					cnt = 0;
				}
			}
			else {

				
				System.out.print(ch);

			
				cnt = 0;
			}
		}
		System.out.println();
		}
		else
		{
			System.out.println("it is message error occured!");
		}
		}
		
		else if(!s1.equals(s3))
		{
			System.out.println("it is starting error occured!");
		}
		else if(!s2.equals(s3))
		{
			System.out.println("it is ending error occured!");
		}
		else
		{
			System.out.println("unidentified error occured!");
		}

	}
}


import java.io.*;
import java.util.*;

public class chard {
	
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
		int i,flag1=0,flag2=0;

	     String str1=readFile("charf.txt");
	String str2="";
		System.out.println("Stuffed data from client: " + str1);

		System.out.println("Unstuffed data: ");
		int p=str1.length()-1;
		if((str1.charAt(0)=='s')&&(str1.charAt(1)=='t')&&(str1.charAt(2)=='x'))
		{
			flag1=1;
		}
	
		 if((str1.charAt(p-3)=='e')&&(str1.charAt(p-2)=='t')&&(str1.charAt(p-1)=='x'))
		{
			flag2=1;
	
	        }
		if((flag1==1)&&(flag2==1))
		{
		
		  for(i=3;i<p-3;i++)
    {
        
	    
	    if((str1.charAt(i)=='d')&&(str1.charAt(i+1)=='l')&&(str1.charAt(i+2)=='e')&&(str1.charAt(i+3)=='d')&&(str1.charAt(i+4)=='l')&&(str1.charAt(i+5)=='e'))
        {
            i=i+3;
        }
	
	    if((str1.charAt(i)=='d')&&(str1.charAt(i+1)=='l')&&(str1.charAt(i+2)=='e')&&(str1.charAt(i+3)=='e')&&(str1.charAt(i+4)=='t')&&(str1.charAt(i+5)=='x'))
        {
            i=i+3;
        }

	
        str2=str2+str1.substring(i,i+1);
    }
    System.out.println("received data is         "+str2);
		}
		else if(flag1==0)
		{
			System.out.println("starting error occured!");
		}
		else if(flag2==0)
		{
			System.out.println("ending error occured!");
		}
		else
		{
			System.out.println("unidentified error occured!");
		}
    }		

	}



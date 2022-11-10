import java.io.*;
import java.util.Scanner;
public class chars {
	public static void main(String[] args) throws IOException,StringIndexOutOfBoundsException
	{
		
        Scanner k =new Scanner (System.in);
        System.out.println("enter the string\t");
        String s=k.nextLine();
         String str1;
         String str2="";
        int i,m,j;
        m=s.length();  
        System.out.println("original data     "+s);
       str1="stx";
       for(i=0;i<=m-1;i++)
       {
         if((s.charAt(i)=='d')&&(s.charAt(i+1)=='l')&&(s.charAt(i+2)=='e'))
        {
        str1=str1+"dle";
        }
	if((s.charAt(i)=='e')&&(s.charAt(i+1)=='t')&&(s.charAt(i+2)=='x'))
	{
	   str1=insertString(str1,"dle",i+2);
	//	str1=str1+"dle";		
	}
        str1=str1+s.substring(i,i+1);
       }
    str1=str1+"etx";
    int p=str1.length();
    System.out.println(" The transmitting data      "+str1);


	
		   try{    
           FileWriter fw=new FileWriter("/home/elcot/Documents/computer network/ex1/charf.txt");    
           fw.write(str1);    
           fw.close();    
          }catch(Exception e){System.out.println(e);}   
	
	}

	public static String insertString(
		String originalString,
		String stringToBeInserted,
		int index)
	{

		
		String newString = new String();

		for (int i = 0; i < originalString.length(); i++) {

			
			
			newString += originalString.charAt(i);

			if (i == index) {

							
				newString += stringToBeInserted;
			}
		}

		
		return newString;
	}
}



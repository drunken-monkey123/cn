import java.util.*;
import java.lang.*;
public class a{
	public static void main(String[] args) {
		int b,k=0,flag=0,temp=0,cnt=0,i,j;
		//Scanner c = new Scanner(System.in);
	//	b=c.nextInt(); //  s=c.nextInt();

	//	int[][] big = new int[b][b];
		//int[][] small = new int[s][s];
	//	int[] bb=new int[b*b];
	//	int[] ss=new int[s*s];

		//String s="12345678956864"; 
		String str="Not Found";
		//char sm=(s.charAt(s.length()-1));
		int sm=Integer.parseInt(s.substring(s.length()-1,s.length()));
		// sm=s.length()-1;
	//	for(int i=0;i<ss.length;i++)
			System.out.println(sm);

			int[] ss=new int[sm];
			int s1=(int)Math.sqrt(sm);
			for(i=0;i<ss.length;i++)
				{
					ss[i]=Integer.parseInt(s.substring(s.length()-(sm+1)+i,s.length()-sm+i));
					System.out.println(ss[i]);
				}	System.out.println("===============");
				b=s.length()-i-1;
				int b1=(int)Math.sqrt(b);
				System.out.println(b);
				int[] bb=new int[b];
			for(i=0;i<bb.length;i++)
				{
					bb[i]=Integer.parseInt(s.substring(i,i+1));
					System.out.println(bb[i]);
				}


				System.out.println("===============");
		for( i=0;i<bb.length;i++)
		{
			//System.out.println("tej0 : "+i);
			for( j=0;j<ss.length;j++)
		{
				
				temp=i;
				//System.out.println("tej0 : "+temp);
				if(bb[i]==ss[j])
				{
					cnt++;
				
				if(cnt==s1)
				{
					i=i+b1-1;
			//		System.out.println("tej1 : "+i);
					if(j==ss.length-1)
						{
						flag=1;
						str="Found";
						//return;
						}
					//j=j+s-1; 
						cnt=0;

				}
				else{
					i=i+1;
				
				}

				}
				

			}  cnt=0;  i=temp;
 		}
       
       
}

}
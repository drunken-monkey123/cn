import java.util.*;
public class m{
	public static void main(String[] args) {
		int b,s,k=0,flag=0,temp=0,cnt=0,i,j;
		Scanner c = new Scanner(System.in);
		b=c.nextInt();   s=c.nextInt();

		int[][] big = new int[b][b];
		int[][] small = new int[s][s];
		int[] bb=new int[b*b];
		int[] ss=new int[s*s];

		for( i=0;i<b;i++)
			for( j=0;j<b;j++)
				{
				big[i][j]=c.nextInt();
				bb[k++]=big[i][j];
				}
		
		System.out.println("===============");
		k=0;
        for( i=0;i<s;i++)
			for( j=0;j<s;j++)
				{
				small[i][j]=c.nextInt();
				ss[k++]=small[i][j];
				}
		System.out.println("===============");

	//	for(int i=0;i<ss.length;i++)
	//		System.out.println(ss[i]);

		for( i=0;i<bb.length;i++)
		{
			for( j=0;j<ss.length;j++)
		{

				temp=i;
				
				if(bb[i]==ss[j])
				{
					cnt++;
				
				if(cnt==s)
				{
					i=i+b-1;
					if(j==ss.length-1)
						{
						flag=1;
						System.out.println("found");
						return;
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
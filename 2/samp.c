#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main()
{
	char msg[11],temp[2],msg1[4],cnt1[2]; int i,cnt=0,j=0;
scanf("%s",msg);
	temp[0]=msg[0];
	
for(i=0;i<sizeof(msg);i++)
{
if(temp[0]==msg[i])

    {	    cnt++;}
else
	{
		msg1[j]=temp[0];
		j++;
	//	printf("1:%c  ::",msg1[--j]);
		  sprintf(cnt1, "%d", cnt);  
		msg1[j]=cnt1[0];
	//	printf("%c\n",msg1[j]);
		j=j++;
		temp[0]=msg[i];
		cnt=1;
		 
		}
		}
		printf("111: %s",msg1);
		return 0;
		}

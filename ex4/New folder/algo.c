#include<stdio.h>
#include<string.h>
char hexadecimal[100]={""};
void hexa(int x)
{
	char hex[100];
	int rem,i,j=0;
	printf("hexa = %d",x);
	while(x>0)
	{
		rem=x%16;
		if(rem<10)
		{
		hex[j]=45+rem+'0';
	    j++;
		}
		else
		{
		hex[j]=55+rem+'0';
		j++;
		}
		x=x/16;
	}
	
	for(i=0;i<strlen(hex);i++)
		strncat(hexadecimal,&hex[i],1);
}
int main()
{
	char s[100];
	scanf("%s",s);
	int i,j,k,count=0,flag=0;
	char s1[100]={""},s2[100]={""};
	k=0;
	for(i=0;i<strlen(s);i++)
	{
		for(j=0;j<strlen(s1);j++)
		{                                   
			if(s1[j]==s[i])
			flag=1;
		}
		if(flag==0)
		{
			//s1[k]=s[i];
			strncat(s1,&s[i],1);
			k++;
		}
		flag=0;
	}
		printf("the ele %s",s1);
	k=0;
	for(i=0;i<strlen(s1);i++)
	{
		for(j=0;j<strlen(s);j++)
		{
			//if(s[i]==s1[j])
			if((s[j]==s1[i]))
			{
			count++;
			printf("%d",count);
			}
		}
	strncat(s2,&s1[i],1);
	hexa(count);
	strcat(s2,hexadecimal);
	printf("%s",s2);
	count=0;	
	
	}
	printf("the sdhf  is :%s",s2);
}

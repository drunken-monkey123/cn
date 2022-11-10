#include<stdio.h>
#include<string.h>
char hexadecimal[100]={""};
void hexa(int decnum)
{
    int  rem, i=0,k=0;
    char hexnum[50];

    while(decnum!=0)
    {
        rem = decnum%16;
        if(rem<10)
            rem = rem+48;
        else
            rem = rem+55;
        hexnum[i] = rem;
        i++;
        decnum = decnum/16;
    } char hex[3];
    printf("\nEquivalent Value in Hexadecimal = ");
    for(i=i-1; i>=0; i--)
       {// printf("%c", hexnum[i]);
            hex[k]=hexnum[i];
            k++;
       }
 


	printf("-----hexa = %s\n",hex);
    
	for(i=0;i<strlen(hex);i++)
		strncat(hexadecimal,&hex[i],1);
    strcpy(hex,"  ");
    printf("%s--\n",hex);
}
int main()
{
	char s[100];
	//strcpy(s,msg);
    scanf("%s",s);
	int i,j,k,count=0,flag=0;`
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
	//	printf("the element is %s\n",s1);
	k=0;
	for(i=0;i<strlen(s1);i++)
	{
		for(j=0;j<strlen(s);j++)
		{
			//if(s[i]==s1[j])
			if((s[j]==s1[i]))
			{
			count++;
		//	printf("%d-",count);
			}
		}
	strncat(s2,&s1[i],1);
	hexa(count);
	strcat(s2,hexadecimal);
    strcpy(hexadecimal,"");
//	printf("%s",s2);
	count=0;	
	
	}
	printf("the output  is :%s\n---> ",s2);
   char ans[25];
    int leng, g,g1=0;
    leng = strlen(s2);
  for(g = leng - 1; g >= 0; g--) {
        ans[g1]=s2[g];
        if(g!=0)
            g1++;        
    }
    printf("%s",ans);
 
}
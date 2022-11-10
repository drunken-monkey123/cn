#include"myhead.h"

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
 


//	printf("-----hexa = %s\n",hex);
    
	for(i=0;i<strlen(hex);i++)
		strncat(hexadecimal,&hex[i],1);
    strcpy(hex,"  ");
    printf("%s--\n",hex);
}


int main()
{
	int sd,b,l,ad,len;
	char msg[10];
	struct sockaddr_in server,client;
	printf("enter the port address\n");
	int port=0;
	scanf("%d",&port);
	server.sin_family = AF_INET;
	server.sin_port =htons(port);
	server.sin_addr.s_addr = htonl(INADDR_ANY);
	sd = socket(AF_INET,SOCK_STREAM,0);
	if(sd>0)
		printf("SUCCESS");
	else
		printf("Error");
	b=bind(sd,(struct sockaddr*)&server,sizeof(server));
	if(b>0)
		printf("Success");
	else
		printf("Errorb");
	l=listen(sd,5);
	if(l==0)
		printf("Syccess");
	else
		printf("Error");
	len = sizeof(client);
	ad=accept(sd,(struct sockaddr*)&client,&len);
	if(ad>0)
		printf("success");
	else
		printf("ERROR");
	printf("Connection establised");
	
		recv(ad,msg,100,0);
		printf("\n client :%s",msg);
		printf("\nServer");
		//	scanf("%s",msg);
		char s[100];
	strcpy(s,msg);
  	 // scanf("%s",s);
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
//	printf("hello");
	printf("the output  is :%s\n---> ",s2);
 /*  char ans[10];
    int leng, g,g1=0;
    leng = strlen(s2);
    printf("hello");
  for(g = leng - 1; g >= 0; g--) {
        ans[g1]=s2[g];
       // if(g!=0)
            g1++;        
    }
    printf("the output is : %s ",ans);*/
	    strcpy(msg,"");
	    strcpy(msg,s2);
	    printf("--> %s",msg);
		
		send(ad,msg,100,0);
		
			close(sd);
}

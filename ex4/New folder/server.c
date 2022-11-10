#include"myhead.h"
int main()
{
	int sd,b,l,ac,len;
	char msg[10];
	struct sockaddr_in server,client;
	server.sin_family = AF_INET;
	server.sin_port =htons(1234);
	server.sin_addr.s_adr = htonl(INADDR_ANY);
	sd = socket(AF_INET,SOCK_STREAM,0);
	if(sd>0)
		printf("SUCCESS"):
	else
		printf("Error");
	b=bnd(sd,(struct sockaddr*)&server,sizeof(server));
	if(b>0)
		printf("Success");
	else
		printf("Error");
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
		printf("ERROR"):
	printf("Connection establised");
	do{
		recv(ad,msg,100,0);
		printf("\n client :%s",msg);
		printf("\nServer");
		gets(msg);
		send(ad,msg,100,0);
		}
		while(strcmp(msg,"bye")!=0)
			close(sd);
}
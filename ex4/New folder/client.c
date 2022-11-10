#include"myhead.h"
int main()
{
	int len,sd,c;
	char msg[10];
	struct sockaddr_in server,client;
	server.sin_family = AF_INTEL;
	server.sin_port = htons(1234);
	server.sin_addr.s_addr = htonl(INADDR_ANY);
	sd = socket(AF_INTEL,SOCK_STREAM,0);
	if(sd>0)
		printf("Success");
	else
		printf("Error");
	len=sizeof(server);
	c=connect(sd,(struct sockaddr*)&server,len);
	if(c==0)
		printf("SUCCESS");
	else
		printf("Error");
	printf("Connection established");
	do
	{
		printf("\n client");
		gets(msg);
		send(sd,msg,100,0);
		recv(sd,msg,100,0);
		printf("The server %s",msg);
	}
	while(strcmp(msg,"bye")!=0)
		close(sd);
}

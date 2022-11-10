#include "Myhead.h"
int main()
{
   int n,i,le;
   printf("\n enter the port number ");
   scanf("%d",&n);
   int sd,b,l,ac,len;
   struct sockaddr_in server , client;
   char msg[2000];
   server.sin_family = AF_INET;
   server.sin_addr.s_addr =htonl(INADDR_ANY);
   server.sin_port = htons(n);
   sd= socket(AF_INET ,SOCK_STREAM,0);
   if (sd>0)
   {
       printf("created socket");
   }
   else
   puts("error in Socket creation");
   le=sizeof(server);
   b=bind(sd,(struct sockaddr *)&server,le);
   if(b>=0)
       printf("bind successs");
   else
       puts("bind failed");
   listen(sd,1);
   len=sizeof(client);
   int ad = accept(sd,(struct sockaddr *)&client,&len);
   if (ad == 0)
       printf("accept success");
   else
       puts(" \n  accepted");
   do
   {
    recv(ad,msg,100,0);
    printf("\n client message =  %s",msg);
    printf("\nEnter msg");
    scanf("%s",msg);
    send(ad,msg,100,0);
   } while(strcmp(msg,"bye")!=0);
   close(sd);
   }

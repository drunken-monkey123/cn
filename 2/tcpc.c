#include "Myhead.h"
#include<stdio.h>
#include<string.h>
#include<sys/socket.h>
#include<arpa/inet.h>
int main()
{
    int sd,c,n;
    printf("\n enrter the port number   ");
     scanf("%d",&n);
    struct sockaddr_in server;
    char msg[1000];
    server.sin_addr.s_addr = htonl(INADDR_ANY);
    server.sin_family =AF_INET;
    server.sin_port = htons(n);
    sd = socket(AF_INET , SOCK_STREAM , 0);
    if (sd >0)
    {
        printf(" created socket");
    }
    else
    printf("Socket error");

    int len=sizeof(server);
    c=connect(sd ,(struct sockaddr *)&server , len);
    if(c==0)
    {
        printf("connected");

    }
   else
    puts("not Connected\n");
  do
 {
  printf("\n enter the message  ");
  scanf("%s",msg);
  send(sd,msg,100,0);
  recv(sd,&msg,100,0);
   printf("%s",msg);
  }while(strcmp(msg,"bye")!=0);
    close(sd);
    return 0;
}

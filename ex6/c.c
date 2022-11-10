#include"Myhead.h"

int main()

{

        int sd,b,l,ac,len;

        char msg[100],n[10];

        printf("Client");

        struct sockaddr_in server,client;

        server.sin_family = AF_INET;

        printf("Enter the port address");

        int h;char temp[10];

        scanf("%d",&h);

        server.sin_port = htons(h);

        server.sin_addr.s_addr = htonl(INADDR_ANY);

        sd = socket(AF_INET,SOCK_DGRAM,0);

        if(sd>0)

                printf("socket Success\n");

        else

                printf("socket Error\n");

        b=bind(sd,(struct sockaddr*)&client,sizeof(client));

        if(b>=0)

                printf("Binding is success\n");

        else

                printf("Bind error\n");

/*	do{

        printf("Enter the message\n");

        scanf("%s",msg);

        printf("enter the no of rotation\n");

        scanf("%s",n);

	strcpy(temp,msg);

        sendto(sd,msg,100,0,(struct sockaddr*)&server,sizeof(server));

        sendto(sd,n,1,0,(struct sockaddr*)&server,sizeof(server));

        printf("Msg sent\n");

        len = sizeof(server);*/

        recvfrom(sd,(char *)msg,100,0,(struct sockaddr*)&server,&len);

        printf("\n------------------------------\nThe rotated msg : ");

        printf("%s\n----------------------------------",msg);

//	}while(temp!="q");

        close(sd);

}

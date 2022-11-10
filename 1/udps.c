#include"Myhead.h"
int main()
{
        int sd,b,l,ac,len,d,i,j;
        char msg[100],n[10],temp;
        printf("Client");
        struct sockaddr_in server,client;
        server.sin_family = AF_INET;
        printf("Enter the port address");
        int h;
        scanf("%d",&h);
        server.sin_port = htons(h);
        server.sin_addr.s_addr = htonl(INADDR_ANY);
        sd = socket(AF_INET,SOCK_DGRAM,0);
        if(sd>0)
                printf("socket Success\n");
        else
                printf("socket Error\n");
        b=bind(sd,(struct sockaddr*)&server ,sizeof(server));
        if(b>=0)
                printf("Binding is success\n");
        else
                printf("Bind error\n");
        len=sizeof(client);
        

        do
	{
	recvfrom(sd,(char *)msg,100,0,(struct sockaddr*)&client,&len);
	printf("\n---------------------------------------------------------\n%s\n",msg);
        recvfrom(sd,(char *)n,1,0,(struct sockaddr*)&client,&len);
        printf("\n---------------------------------------------------------\n%s\n",n);
        d=atoi(n);
        for(i=0;i<d;i++)
        {
                temp=msg[strlen(msg)-1];
                for(j=strlen(msg)-1;j>=1;j--)
                        msg[j]=msg[j-1];
                msg[0]=temp;
        }
        printf("\n---------------------------------------------------------\n%s\n",msg);
        sendto(sd,msg,100,0,(struct sockaddr*)&client,sizeof(client));
	}while(msg!="q");
	close(sd);
}

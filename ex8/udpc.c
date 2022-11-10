#include"Myhead.h"
int main()
{
        int sd,b,l,ac,len;
        char msg[200],n[10],temp[2];
        printf("Client");
        struct sockaddr_in server,client;
        server.sin_family = AF_INET;
      
        server.sin_port = htons(2222);
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
	
	printf("enter the number of nodes\n");
	int n1,i,j;
	scanf("%d",&n1);
        sprintf(n,"%d",n1);
        sendto(sd,n,1,0,(struct sockaddr*)&server,sizeof(server));
	int mat[n1][n1];
	printf("enter the adjacent matrix \n");
	for(i=0;i<n1;i++)
                for(j=0;j<n1;j++)
                      {
                          scanf("%d",&mat[i][j]);
                      
                      }


        for(i=0;i<n1;i++)
                for(j=0;j<n1;j++)
                {
                        sprintf(msg,"%d",mat[i][j]);
                        sendto(sd,msg,10,0,(struct sockaddr*)&server,sizeof(server));
                }

        


        printf("\nInformation about Graph has sent successfully!!");
           
        printf("\n ****** \n"); 
        printf("Enter the node to calculate the shortest path\n  -->   ");
        int u;
        scanf("%d",&u);
        sprintf(n,"%d",u);
        printf("Request sent successfully!!");
        sleep(3);
         sendto(sd,n,1,0,(struct sockaddr*)&server,sizeof(server));

         printf("Result received from the server!!\n");

         printf("\n+==============================+\n");
         printf("|    Vertex      Distance ");
      printf("\n+==============================+\n");
         for(i=0;i<n1;i++)
         {
                     printf("+==============================+\n");
                    recvfrom(sd,(char *)n,10,0,(struct sockaddr*)&server,&len); 
                    recvfrom(sd,(char *)msg,100,0,(struct sockaddr*)&server,&len); 
                    printf("|  %5s \t %4s  \n",n,msg);
                    sleep(1.5);

         }

          printf("+==============================+\n");
        close(sd);
         
}

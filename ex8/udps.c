#include"Myhead.h"
#include <limits.h>
#include <stdbool.h>
#include <stdio.h>

int n1;
int dist[10];
 

int minDistance(int dist[], bool sptSet[])
{

    int min = INT_MAX, min_index;
 
    for (int v = 0; v < n1; v++)
        if (sptSet[v] == false && dist[v] <= min)
            min = dist[v], min_index = v;
 
    return min_index;
}
 

void dijkstra(int graph[n1][n1], int src)
{

 
    bool sptSet[n1]; 
 

    for (int i = 0; i < n1; i++)
        dist[i] = INT_MAX, sptSet[i] = false;
 

    dist[src] = 0;

    for (int count = 0; count < n1 - 1; count++) {

        int u = minDistance(dist, sptSet);
 
        sptSet[u] = true;
 
       
        for (int v = 0; v < n1; v++)
 
         
            if (!sptSet[v] && graph[u][v]
                && dist[u] != INT_MAX
                && dist[u] + graph[u][v] < dist[v])
                dist[v] = dist[u] + graph[u][v];
    }
 

    
}

int main()
{
        int sd,b,l,ac,len,d,i,k,j;
        char msg[100],n[10],temp,n2[10],nod[2],dis[10];
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
        b=bind(sd,(struct sockaddr*)&server ,sizeof(server));
        if(b>=0)
                printf("Binding is success\n");
        else
                printf("Bind error\n");
        len=sizeof(client);
        

      
        recvfrom(sd,(char *)n,1,0,(struct sockaddr*)&client,&len);
         n1=atoi(n);
        int mat[n1][n1];
      
        
        printf("Receiving Graph from Client!!\n");

          for(i=0;i<n1;i++)
               { for(j=0;j<n1;j++)
                {
                        recvfrom(sd,(char *)msg,10,0,(struct sockaddr*)&client,&len);
                        mat[i][j]=atoi(msg);
                        printf("%2d  ",mat[i][j]);
                }
                printf("\n");
               }
         recvfrom(sd,(char *)n2,1,0,(struct sockaddr*)&client,&len);
         int u=atoi(n2);

        printf("Calculating Shortest path\n");
        dijkstra(mat , u);
     
        printf("Result sent to Client Successfully\n");
        for(i=0;i<n1;i++)
        {
                sprintf(nod,"%d",i);
                sprintf(dis,"%d",dist[i]);
                sendto(sd,nod,2,0,(struct sockaddr*)&client,sizeof(client));
                sendto(sd,dis,10,0,(struct sockaddr*)&client,sizeof(client));
        }
	close(sd);
}

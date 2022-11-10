#include<stdio.h>
#include<string.h>
int main()
{
	char a[100],temp;
	int s,j,i;
	printf("Enter the string\n");
	scanf("%s",a);
	printf("Enter the no of iter\n");
	scanf("%d",&s);
	for(i=0;i<s;i++)
	{
		temp=a[strlen(a)-1];
		for(j=strlen(a)-1;j>=1;j--)
		{
			a[j]=a[j-1];
		}
		a[0]=temp;
	}
	printf("%s",a);
}

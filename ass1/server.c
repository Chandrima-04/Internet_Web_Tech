#include<stdio.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<string.h>
#include<time.h>

int main(){
	int socket1,socket2;
	char buffer[1024];
	struct sockaddr_in serveraddr;
	struct sockaddr_storage serverstorage;
	socklen_t addr_size;
	socket1 = socket(PF_INET,SOCK_STREAM,0);
	serveraddr.sin_family = AF_INET;
	serveraddr.sin_port = htons(7891);
	serveraddr.sin_addr.s_addr = inet_addr("10.24.109.21");
	bind(socket1, (struct sockaddr *)&serveraddr, sizeof(serveraddr));
	if(listen(socket1,5) == 0)
		printf("Listening!!\n");
	else
		printf("Error!!!");
	addr_size = sizeof(serverstorage);
	socket2 = accept(socket1,(struct sockaddr *)&serverstorage,&addr_size);
	struct timeval tv;
	gettimeofday(&tv,NULL);
	//curtime = tv.tv_sec;
	strcpy(buffer,ctime(&tv));
	send(socket2,&buffer,sizeof(buffer),0);
	return 0;	
}

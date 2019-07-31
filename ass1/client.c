#include<stdio.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<string.h>

int main(){
	int socket1;
	char buffer[1024];
	socklen_t addr_size;
	struct sockaddr_in clientaddr;
	socket1 = socket(PF_INET,SOCK_STREAM,0);
	clientaddr.sin_family = AF_INET;
	clientaddr.sin_port = htons(7891);
	clientaddr.sin_addr.s_addr = inet_addr("127.0.0.1");
	addr_size = sizeof(clientaddr);
	connect(socket1, (struct sockaddr *)&clientaddr, addr_size);
	recv(socket1, buffer, 1024, 0);
	printf("Data received: %s",buffer);   
	return 0;
}

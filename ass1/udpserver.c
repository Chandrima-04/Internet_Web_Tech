#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdlib.h>
#include<time.h>

int main(){
	int udpSocket, nBytes;
	char buffer[1024],buffer1[1024];
	struct sockaddr_in serverAddr, clientAddr;
	struct sockaddr_storage serverStorage;
	socklen_t addr_size, client_addr_size;
	udpSocket = socket(PF_INET, SOCK_DGRAM, 0);
	serverAddr.sin_family = AF_INET;
	serverAddr.sin_port = htons(7891);
	serverAddr.sin_addr.s_addr = inet_addr("10.24.109.21");
	memset(serverAddr.sin_zero, '\0', sizeof serverAddr.sin_zero);  
	bind(udpSocket, (struct sockaddr *) &serverAddr, sizeof(serverAddr));
	addr_size = sizeof serverStorage;
	nBytes = recvfrom(udpSocket,buffer,1024,0,(struct sockaddr *)&serverStorage, &addr_size);
	printf("%s",buffer);
	struct timeval tv;
	time_t curtime;
	gettimeofday(&tv,NULL);
	strcpy(buffer1,ctime(&tv));
   	sendto(udpSocket,buffer1,sizeof buffer1,0,(struct sockaddr *)&serverStorage,addr_size);
	return 0;
}

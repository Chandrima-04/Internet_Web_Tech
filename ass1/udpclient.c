#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>

int main(){
	int clientSocket, portNum, nBytes;
	char buffer[1024],buffer1[1024];
	struct sockaddr_in serverAddr;
	socklen_t addr_size;
	serverAddr.sin_family = AF_INET;
	serverAddr.sin_port = htons(7891);
	serverAddr.sin_addr.s_addr = inet_addr("127.0.0.1");
	memset(serverAddr.sin_zero, '\0', sizeof serverAddr.sin_zero); 

	clientSocket = socket(PF_INET, SOCK_DGRAM, 0); 
	addr_size = sizeof serverAddr;
	printf("Type a sentence to send to server:\n");
    fgets(buffer,1024,stdin);
    printf("You typed: %s",buffer);
	nBytes = strlen(buffer) + 1;
	sendto(clientSocket,buffer,nBytes,0,(struct sockaddr *)&serverAddr,addr_size);
    nBytes = recvfrom(clientSocket,buffer1,1024,0,NULL, NULL);
	printf("Received from server: %s\n",buffer1);
	return 0;
}

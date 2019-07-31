import java.net.*;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Date;

class server{
	public static void main(String argv[]) throws Exception{
		String buffer;
        ServerSocket socket1 = new ServerSocket(7891);
		Socket connectionSocket = socket1.accept();
        DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());
        System.out.println("Connected...");
        buffer = new Date().toString();
        out.writeBytes(buffer);    
        socket1.close();
    }
}

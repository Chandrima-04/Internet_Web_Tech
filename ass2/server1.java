import java.net.*;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Date;
import java.util.*;

class server1{
	public static void main(String argv[]) throws Exception{
		String buffer1,buffer2;
        ServerSocket socket1 = new ServerSocket(7891);
        Socket socket2 = new Socket("localhost", 7891);
		Socket connectionSocket = socket1.accept();
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new DataOutputStream(connectionSocket.getOutputStream());
        PrintWriter pwrite = new PrintWriter(out, true);
        InputStream in = connectionSocket.getInputStream();
        BufferedReader istream = new BufferedReader(new InputStreamReader(in));
        System.out.println("Connected...");
        while(true){
        	if((buffer1 = istream.readLine())!=null){
        		System.out.println(buffer1);
        	}
        	buffer2 = keyRead.readLine();
        	pwrite.println(buffer2);
    	}
    }
}

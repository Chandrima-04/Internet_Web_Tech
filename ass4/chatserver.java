import java.io.*;
import java.net.*;
public class chatserver extends Thread{
	public static void main(String[] args) throws Exception{
		ServerSocket sersock = new ServerSocket(7891);
    	//Socket sock = sersock.accept( );    
    	//System.out.println("Connected...");                      
    	/*BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	OutputStream out = sock.getOutputStream();
    	PrintWriter pwrite = new PrintWriter(out, true);
 		InputStream istream = sock.getInputStream();
    	BufferedReader inp = new BufferedReader(new InputStreamReader(istream));*/
 		String receiveMessage, sendMessage;              
    	while(true){
    		Socket sock = sersock.accept( ); 
    		cThread t = new cThread(sock);
    		t.start();
    		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    		OutputStream out = sock.getOutputStream();
    		PrintWriter pwrite = new PrintWriter(out, true);
 			InputStream istream = sock.getInputStream();
    		BufferedReader inp = new BufferedReader(new InputStreamReader(istream));
    		if((receiveMessage = inp.readLine()) != null){
    			System.out.print("Client: ");
        		System.out.println(receiveMessage);        
        	}
        	System.out.print("Me: ");       
        	sendMessage = in.readLine();
        	pwrite.println(sendMessage);            
        	pwrite.flush();
    	}              
	}                    
}
class cThread extends Thread{
	Socket sock;
	boolean running = true;
	cThread(Socket s){
		sock = s;
	}
}



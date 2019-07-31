import java.io.*;
import java.net.*;
public class chatclient{
	public static void main(String[] args) throws Exception{
    	Socket sock = new Socket("localhost", 7891);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(out, true);
        InputStream istream = sock.getInputStream();
        BufferedReader inp = new BufferedReader(new InputStreamReader(istream));
 		String receiveMessage, sendMessage;              
        while(true){
        	System.out.print("Me: ");
        	sendMessage = in.readLine();  
        	pwrite.println(sendMessage);       
        	pwrite.flush();                   
        	if((receiveMessage = inp.readLine()) != null){
        		System.out.print("Server: ");
            	System.out.println(receiveMessage); 
        	}        
      	}              
    }                    
}    

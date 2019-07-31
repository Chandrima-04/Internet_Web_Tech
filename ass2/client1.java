import java.net.*;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Date;
import java.util.*;

class client1{
	public static void main(String argv[]) throws Exception{
		String buffer,sentence;
		Scanner in = new Scanner(System.in);
		Socket client = new Socket("localhost", 7891);
  		DataOutputStream out = new DataOutputStream(client.getOutputStream());
  		PrintWriter pwrite = new PrintWriter(out, true);
  		BufferedReader inp = new BufferedReader(new InputStreamReader(client.getInputStream()));
  		sentence = in.nextLine();
  		pwrite.println(sentence + '\n');
  		buffer = inp.readLine();
  		System.out.println(buffer);
  		
  		client.close();
	}
}

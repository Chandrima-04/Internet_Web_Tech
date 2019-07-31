import java.net.*;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Date;

class client{
	public static void main(String argv[]) throws Exception{
		String buffer,sentence;
		Socket client = new Socket("localhost", 7891);
  		DataOutputStream out = new DataOutputStream(client.getOutputStream());
  		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
  		buffer = in.readLine();
  		System.out.println(buffer);
  		sentence = "Thank you!!";
  		out.writeBytes(sentence + '\n');
  		client.close();
	}
}

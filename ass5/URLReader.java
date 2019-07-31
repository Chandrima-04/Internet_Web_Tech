import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JOptionPane;
public class URLReader {
    public static void main(String[] args) throws Exception {
    	System.getProperties().put("proxySet","true");
		System.getProperties().put("proxyHost","10.24.0.1");
		System.getProperties().put("proxyPort","8080");
		String s; 
		s = JOptionPane.showInputDialog("Enter URL");
        URL google = new URL(s);
        BufferedReader in = new BufferedReader(new InputStreamReader(google.openStream()));
		BufferedWriter out = new BufferedWriter(new FileWriter("browser.html"));
        String line;
        while ((line = in.readLine()) != null){
        	
        	out.write(line);
        	out.newLine();
    	}
    	in.close();
    	out.close();
  	}
    
}


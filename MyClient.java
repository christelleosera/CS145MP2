import java.io.*;
import java.net.*;

public class MyClient{
  public static void main(String args[]) {

		String temp = "";
				
		try{
			Socket s = new Socket("127.0.0.1", 8888);
			MyConnection conn = new MyConnection(s);
			System.out.println("Client connected!");
	
			temp = conn.getMessage();
			MyClientWindow w = new MyClientWindow(Integer.parseInt(temp), conn);
			w.setVisible(true); 
		
		} catch (Exception e){}
		
	}
}


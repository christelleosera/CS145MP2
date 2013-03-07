import java.io.*;
import java.net.*;

public class MyClient{
  public static void main(String args[]) {
		int points = 250, i, playernum;
		String temp = "";
		
		try{
			Socket s = new Socket("127.0.0.1", 8888);
			System.out.println("Client connected!");
			MyConnection conn = new MyConnection(s);
			temp = conn.getMessage();
			MyClientWindow w = new MyClientWindow(Integer.parseInt(temp));
			w.setVisible(true); 
		/*	while(points > 0){
				System.out.print("Enter message: ");
				InputStreamReader reader = new InputStreamReader(System.in);
				BufferedReader read = new BufferedReader(reader);
				String msgOut = read.readLine();
				
				/*CHECKING TO BE DONE BEFORE SENDING (sa GUI pala to ichecheck since yung command na text doon manggagaling):
					- check if location specified is empty
					- check if the player has enough points
				*/
				
		/*		conn.sendMessage(msgOut);
				
				String msgIn = conn.getMessage();
				
				if(msgIn.charAt(0) == '$'){
					points = points - Integer.parseInt(msgIn.substring(1));
					System.out.println("POINTS: " + points);
				}
			}
		*/
		} catch (Exception e){}
		
	}
}


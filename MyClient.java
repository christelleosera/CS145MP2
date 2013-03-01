import java.io.*;
import java.net.*;

public class MyClient{
  public static void main(String args[]) {
		int points = 250, i;
		try{
			Socket s = new Socket("127.0.0.1", 8888);
			System.out.println("Client connected!");
			MyConnection conn = new MyConnection(s);

			while(points > 0){
				System.out.print("Enter message: ");
				InputStreamReader reader = new InputStreamReader(System.in);
				BufferedReader read = new BufferedReader(reader);
				String msgOut = read.readLine();
				
				/*CHECKING TO BE DONE BEFORE SENDING:
					- check if location specified is empty
					- check if the player has enough points
					- check if location specified is valid (sa area niya talaga)
							--> feeling ko di na kailangan tong location kasi
							 	pde naman idisable yung board nung opponent :D
				*/
				
				conn.sendMessage(msgOut);
				
				String msgIn = conn.getMessage();
				
				if(msgIn.charAt(0) == '$'){
					points = points - Integer.parseInt(msgIn.substring(1));
					System.out.println("POINTS: " + points);
				}
			}
		} catch (Exception e){}
		
	}
}


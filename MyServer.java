import java.io.*;
import java.net.*;


public class MyServer {
  public static void main(String args[]) {
	int playerNum = 1;	
	int i, j;
	MyConnection connArray[] = new MyConnection[2];	
	Character board[][] = new Character[4][12];
	
	//initialize the board
	for(i=0; i<=3; i++){
		for(j=1; j<=10; j++){
			board[i][j] = new Character(null, -1, -1, -1, -1, -1);
		}
	}
	
			
		try {
			System.out.println("Server: Starting...");
			ServerSocket ssocket = new ServerSocket(8888);

			System.out.println("Server: Waiting for connections...");
			
			while(playerNum <= 2){
				Socket socket = ssocket.accept(); // waiting
				System.out.print("Server: somebody connected!");
				System.out.println(socket.getInetAddress());
				//start thread
				new ServerListener(socket, playerNum, connArray[playerNum], board);
				playerNum++;
			}

		} catch (Exception e){ e.printStackTrace(); }
	}
}


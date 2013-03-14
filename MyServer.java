import java.io.*;
import java.net.*;


public class MyServer {
	
	public static void main(String args[]) {
		int playerNum = 0;	
		int i, j;
		MyConnection connArray[] = new MyConnection[2];	
		Character board[][] = new Character[4][12];
		Boolean done[] = new Boolean[2];
		done[0] = false;
		done[1] = false;
		
		//initialize the board
		for(i=0; i<=3; i++){
			for(j=1; j<10; j++){
				board[i][j] = new Character();
			}
		}
		
		//cupcakes
		board[0][0] = new Character("cupcake", 0, 300, 0, 0, 0, 0);
		board[1][0] = new Character("cupcake", 0, 300, 0, 1, 0, 0);
		board[2][0] = new Character("cupcake", 0, 300, 0, 2, 0, 0);
		board[3][0] = new Character("cupcake", 0, 300, 0, 3, 0, 0);
		
		board[0][9] = new Character("cupcake", 0, 300, 0, 0, 11, 1);
		board[1][9] = new Character("cupcake", 0, 300, 0, 1, 11, 1);
		board[2][9] = new Character("cupcake", 0, 300, 0, 2, 11, 1);
		board[3][9] = new Character("cupcake", 0, 300, 0, 3, 11, 1);
		
				
		try {
			System.out.println("Server: Starting...");
			ServerSocket ssocket = new ServerSocket(8888);

			System.out.println("Server: Waiting for connections...");
			
			while(playerNum <= 2){
				Socket socket = ssocket.accept(); // waiting
				System.out.print("Server: somebody connected!");
				System.out.println(socket.getInetAddress());
				//start thread
				ServerListener s = new ServerListener(socket, playerNum, connArray[playerNum], board, done);
				s.start();
				
				playerNum++;
			}

		} catch (Exception e){ e.printStackTrace(); }
	}
	
	
}


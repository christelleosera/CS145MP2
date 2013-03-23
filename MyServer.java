import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.net.*;


public class MyServer {
	
	public static void main(String args[]) {
		int playerNum = 0;	
		int i, j;
	//	List<MyConnection> connList = new ArrayList<MyConnection>();
		List<Clients> clientsList = new ArrayList<Clients>();
	//	MyConnection connArray[] = new MyConnection[2];	
		Character board[][] = new Character[4][12];
		Boolean done[] = new Boolean[2];
		done[0] = false;
		done[1] = false;
		
		//initialize the board
		for(i=0; i<4; i++){
			for(j=0; j<10; j++){
				board[i][j] = new Character();
			}
		}
						
		try {
			System.out.println("Server: Starting...");
			ServerSocket ssocket = new ServerSocket(8888);

			System.out.println("Server: Waiting for connections...");
			
			while(playerNum <= 2){
				Socket socket = ssocket.accept(); // waiting
				MyConnection conn = new MyConnection(socket);
				System.out.print("Server: somebody connected!");
				System.out.println(socket.getInetAddress());
				//start thread
				Clients c = new Clients();
				c.conn = conn;
				c.board = board;
				clientsList.add(c);
				ServerListener s = new ServerListener(socket, playerNum, conn, clientsList, board, done);
				s.start();
				
				playerNum++;
			}

		} catch (Exception e){ e.printStackTrace(); }
	}
	
	
}


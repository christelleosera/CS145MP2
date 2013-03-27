import java.io.*;
import javax.swing.*;
import java.net.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;


public class ServerListener extends Thread{
	/*players*/
	private static final int PLAYER1 = 0;
	private static final int PLAYER2 = 1;
	
	Socket s;
	int playerNum;
	MyConnection conn;
	List<Clients> clientsList;
	Character board[][] = new Character[4][10];
	Boolean done[];
	int i,j;
	
	public ServerListener(Socket s, int playerNum, MyConnection conn, List<Clients> clientsList, Character board[][], Boolean done[]){
		this.playerNum = playerNum;
		this.s = s;
		this.conn = conn;
		this.clientsList = clientsList;
		this.board = board;
		this.done = done;
		this.conn.sendMessage("" + playerNum + ""); //send the client his/her player number

		//start();
	}
	
	public void run(){
		try{	
			String msgIn = "";
			//initialize board
			for(i=0; i<4; i++){
				for(j=0; j<10; j++){
					this.board[i][j] = new Character();
				}
			}
			while(true){
				msgIn = conn.getMessage();
				if(msgIn.equals("DONE")){
					//get player's board
					receiveBoard(conn, this.board, playerNum);
					
					//update copy of board for both players
					updateBoards(clientsList, this.board, playerNum);
					done[playerNum] = true;
					
					if(done[PLAYER1] && done[PLAYER2]){	
						//get a copy of combined board
						copyBoard(clientsList, this.board); 
					
						//send copy of board to both players
						sendToAll();

						fightStart(board, conn, clientsList);
					}
				}
			}
			
			
		
			//msgIn syntax:	CREATE charactername rowNum colNum
			
	/*
			System.out.println("nag exit ako");
			done[playerNum] = true;
			if(done[PLAYER1] && done[PLAYER2])
					fightStart(board);
		*/	
		}catch(Exception e){e.printStackTrace();}	
		
	
	}
	
	//para sabay sabay magsstart magfire. :D
	private void fightStart(Character board[][], MyConnection conn, List<Clients> clientsList){
		System.out.println("fightStart!");
		int i=0, j=0;
		/*for(i=0; i<4; i++){
			for(j=1; j<9; j++){
				if(board[i][j].isOccupied())
					board[i][j].attack(board, conn, clientsList);
			}
		}*/
		
		//row1
		if(board[0][1].isOccupied())
			board[0][1].attack(board, conn, clientsList);
		if(board[0][8].isOccupied())
			board[0][8].attack(board, conn, clientsList);
		if(board[0][2].isOccupied())
			board[0][2].attack(board, conn, clientsList);
		if(board[0][7].isOccupied())
			board[0][7].attack(board, conn, clientsList);
		if(board[0][3].isOccupied())
			board[0][3].attack(board, conn, clientsList);
		if(board[0][6].isOccupied())
			board[0][6].attack(board, conn, clientsList);
		if(board[0][4].isOccupied())
			board[0][4].attack(board, conn, clientsList);
		if(board[0][5].isOccupied())
			board[0][5].attack(board, conn, clientsList);
		
		//row2
		if(board[1][1].isOccupied())
			board[1][1].attack(board, conn, clientsList);
		if(board[1][8].isOccupied())
			board[1][8].attack(board, conn, clientsList);
		if(board[1][2].isOccupied())
			board[1][2].attack(board, conn, clientsList);
		if(board[1][7].isOccupied())
			board[1][7].attack(board, conn, clientsList);
		if(board[1][3].isOccupied())
			board[1][3].attack(board, conn, clientsList);
		if(board[1][6].isOccupied())
			board[1][6].attack(board, conn, clientsList);
		if(board[1][4].isOccupied())
			board[1][4].attack(board, conn, clientsList);
		if(board[1][5].isOccupied())
			board[1][5].attack(board, conn, clientsList);
		
		//row3
		if(board[2][1].isOccupied())
			board[2][1].attack(board, conn, clientsList);
		if(board[2][8].isOccupied())
			board[2][8].attack(board, conn, clientsList);
		if(board[2][2].isOccupied())
			board[2][2].attack(board, conn, clientsList);
		if(board[2][7].isOccupied())
			board[2][7].attack(board, conn, clientsList);
		if(board[2][3].isOccupied())
			board[2][3].attack(board, conn, clientsList);
		if(board[2][6].isOccupied())
			board[2][6].attack(board, conn, clientsList);
		if(board[2][4].isOccupied())
			board[2][4].attack(board, conn, clientsList);
		if(board[2][5].isOccupied())
			board[2][5].attack(board, conn, clientsList);
		
		//row3
		if(board[3][1].isOccupied())
			board[3][1].attack(board, conn, clientsList);
		if(board[3][8].isOccupied())
			board[3][8].attack(board, conn, clientsList);
		if(board[3][2].isOccupied())
			board[3][2].attack(board, conn, clientsList);
		if(board[3][7].isOccupied())
			board[3][7].attack(board, conn, clientsList);
		if(board[3][3].isOccupied())
			board[3][3].attack(board, conn, clientsList);
		if(board[3][6].isOccupied())
			board[3][6].attack(board, conn, clientsList);
		if(board[3][4].isOccupied())
			board[3][4].attack(board, conn, clientsList);
		if(board[3][5].isOccupied())
			board[3][5].attack(board, conn, clientsList);
		
	}

	public void sendBoard(MyConnection conn, Character board[][]){
		int i=0, j=0;
		for(i=0; i<4; i++){
			for(j=0; j<10; j++){
				conn.sendMessage("" + board[i][j].name + "");
				conn.sendMessage("" + board[i][j].damage + "");
				conn.sendMessage("" + board[i][j].life + "");
				conn.sendMessage("" + board[i][j].cost + "");
				conn.sendMessage("" + board[i][j].rowNum + "");
				conn.sendMessage("" + board[i][j].colNum + "");
				conn.sendMessage("" + board[i][j].owner + "");
			}
		}
	
	}
	
	public void receiveBoard(MyConnection conn, Character board[][], int player){
		int i=0, j=0;
		String temp="";
		if(player == PLAYER1){
			for(i=0; i<4; i++){
				for(j=0; j<5; j++){
					temp = conn.getMessage();
					System.out.println(i + "-" + j + "-" + temp);
					board[i][j].name = temp;
					board[i][j].damage = Integer.parseInt(conn.getMessage());
					board[i][j].life = Integer.parseInt(conn.getMessage());
					board[i][j].cost = Integer.parseInt(conn.getMessage());
					board[i][j].rowNum = Integer.parseInt(conn.getMessage());
					board[i][j].colNum = Integer.parseInt(conn.getMessage());
					board[i][j].owner = Integer.parseInt(conn.getMessage());
				
				}
			}
		}
		else if(player == PLAYER2){
			for(i=0; i<4; i++){
				for(j=5; j<10; j++){
					temp = conn.getMessage();
					System.out.println(i + "-" + j + "-" + temp);
					board[i][j].name = temp;
					board[i][j].damage = Integer.parseInt(conn.getMessage());
					board[i][j].life = Integer.parseInt(conn.getMessage());
					board[i][j].cost = Integer.parseInt(conn.getMessage());
					board[i][j].rowNum = Integer.parseInt(conn.getMessage());
					board[i][j].colNum = Integer.parseInt(conn.getMessage());
					board[i][j].owner = Integer.parseInt(conn.getMessage());
				
				}
			}
		}
	}

	private void updateBoards(List<Clients> clientsList, Character[][] board, int playerNum){
		Iterator itr = clientsList.iterator();
		int i=0, j=0;
		while(itr.hasNext()){
			Clients client = (Clients) itr.next();
			if(playerNum == PLAYER1){
				//copy board of player1
				for(i=0; i<4; i++){
					for(j=0; j<5; j++){
						client.board[i][j] = board[i][j];
					}
				}
				
			}
			else if(playerNum == PLAYER2){
				//copy board of player2
				for(i=0; i<4; i++){
					for(j=5; j<10; j++){
						client.board[i][j] = board[i][j];
					}
				}
			}
		}	
	}
	
	private void copyBoard(List<Clients> clientsList, Character[][] board){
		Iterator itr = clientsList.iterator();
		int i=0, j=0;
		Clients client = (Clients) itr.next();

		for(i=0; i<4; i++){
			for(j=0; j<10; j++){
				client.board[i][j] = board[i][j];
			}
		}
					
	}
	
	private void sendToAll(){
		Iterator itr = clientsList.iterator();
		while(itr.hasNext()){
			Clients c = (Clients) itr.next();
			MyConnection current = c.conn;
			current.sendMessage("UPDATE");
			sendBoard(current,board);

		}	
	}
}

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.net.*;

import javax.swing.JOptionPane;



public class AttackThread extends Thread{
	/*players*/
	private static final int PLAYER1 = 0;
	private static final int PLAYER2 = 1;
	
	Character board[][];
	int rowNum;
	int colNum;
	MyConnection conn;
	List<Clients> clientsList;
	
	//public AttackThread(Character board[][], int rowNum, int colNum){
	public AttackThread(Character board[][], int rowNum, int colNum, MyConnection conn, List<Clients> clientsList){
		this.board = board;
		this.rowNum = rowNum;
		this.colNum = colNum;
		this.conn = conn;
		this.clientsList = clientsList;
		start();

	}
	
	public void run(){
		int oppColNum=-1; //location of opponent
		int i=0;
		int opponentCount=0;
		Boolean winner = false;
		while(!winner){
			synchronized(board[rowNum][colNum]){
				if(!iStillExists(board)) break;
				
				if(board[rowNum][colNum].name.equals("donut")){
					//damage on all rows
					for(i=0; i<4; i++){s
						 oppColNum = findNearestOpponent(i);
						 if(oppColNum != -1 && iStillExists(board)){ // if an opponent exists
							damageOpponent(rowNum, oppColNum);
							opponentCount++;
							//this.sendBoard(conn, board);
							sendToAll(board);
							
						}
					}
					if(opponentCount == 0)
						break;
					opponentCount = 0;
					
					//may checker din if deads na yung opponents
				}
				
				else{
					//INSERT CODE FOR FIND NEAREST OPPONENT HERE - should return the location of nearest opponent
					oppColNum = findNearestOpponent(rowNum);
					if(oppColNum != -1 && iStillExists(board)){ // if an opponent exists
						damageOpponent(rowNum, oppColNum);	
						//this.sendBoard(conn, board);
						sendToAll(board);
					} else{
						
						System.out.println("WALA NA AKONG KALABAN! O__O break naa! ");
						//this.sendBoard(conn, board);
						sendToAll(board);
						break;
					}
				}
				winner = checkWinner(board);
			}
			
		}
		sendToAll(board);
		System.out.println("ako si " + board[rowNum][oppColNum].name + " at dedz na ko.");
		//code to display board
		//code to send board to client

	}
	
	//returns column number of nearest opponent
	private int findNearestOpponent(int rowNum){
		int i=0;
		if(board[rowNum][colNum].owner == PLAYER1){
			for(i=5; i<10; i++){
				if(board[rowNum][i].isOccupied() == true){
					return i;
				}
			}
		}
		else{
			for(i=4; i>=0; i--){
				if(board[rowNum][i].isOccupied() == true){
					return i;
				}
			}	
		}
		
		//if no opponent is found, return -1
		return -1;
	}
	
	private void damageOpponent(int oppRowNum, int oppColNum){
		synchronized(board[rowNum][colNum]){
			if(iStillExists(board) && board[rowNum][colNum].owner != board[oppRowNum][oppColNum].owner){
				System.out.println("Location ng kalaban ko: " + oppRowNum + " , " + oppColNum + " " + board[rowNum][colNum].owner);
				//change the values of oppRowNum & oppColNum
				board[oppRowNum][oppColNum].life = board[oppRowNum][oppColNum].life - board[rowNum][colNum].damage;
				//^ life of opponent = old life - damage of this character;
				System.out.println("YES I AM " + board[rowNum][colNum].name + "of player " + board[rowNum][colNum].owner + " and I am damaging " + board[oppRowNum][oppColNum].name + " new life: " + board[oppRowNum][oppColNum].life);
				
				if(board[oppRowNum][oppColNum].life <= 0){ // if deads na
					board[oppRowNum][oppColNum].reset();
				}
				
			}
		}
	}
	
	private boolean iStillExists(Character board[][]){
		if(board[rowNum][colNum].name == "")
			return false;
		else
			return true;
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
	
	private void sendToAll(Character board[][]){
		
		Iterator itr = clientsList.iterator();
		while(itr.hasNext()){
			Clients c = (Clients) itr.next();
			MyConnection current = c.conn;
			synchronized(current){
				current.sendMessage("UPDATE");
				sendBoard(current,board);
			}
		}	
	}
	
	private void sendWinner(int winner){
		
		Iterator itr = clientsList.iterator();
		while(itr.hasNext()){
			Clients c = (Clients) itr.next();
			MyConnection current = c.conn;
			synchronized(current){
				current.sendMessage("ENDGAME" + winner);
			}
		}	
	}

	private boolean checkWinner(Character board[][]){
		int i=0,j=0;
		//for player1
		if(board[0][9].owner == -1 || board[1][9].owner == -1 || board[2][9].owner == -1 || board[3][9].owner == -1 ){
			sendWinner(PLAYER1);
			//JOptionPane.showMessageDialog(null, "PLAYER1 wins!");
			return true;
		}
		else if(board[0][0].owner == -1 || board[1][0].owner == -1 || board[2][0].owner == -1 || board[3][0].owner == -1 ){
			//JOptionPane.showMessageDialog(null, "PLAYER2 wins!");
			sendWinner(PLAYER2);
			return true;
		}
		return false;
	}
}

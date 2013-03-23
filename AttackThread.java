import java.io.*;
import java.net.*;



public class AttackThread extends Thread{
	/*players*/
	private static final int PLAYER1 = 0;
	
	Character board[][];
	int rowNum;
	int colNum;
	MyConnection conn;
	
	//public AttackThread(Character board[][], int rowNum, int colNum){
	public AttackThread(Character board[][], int rowNum, int colNum, MyConnection conn){
		this.board = board;
		this.rowNum = rowNum;
		this.colNum = colNum;
		this.conn = conn;
		start();
	}
	
	public void run(){
		int oppColNum=-1; //location of opponent
		int i=0;
		int opponentCount=0;
		
		while(true){
			
			
			synchronized(board[rowNum][colNum]){
				if(!iStillExists(board)) break;
				
				if(board[rowNum][colNum].name.equals("donut")){
					//damage on all rows
					for(i=0; i<4; i++){
						 oppColNum = findNearestOpponent(i);
						 if(oppColNum != -1 && iStillExists(board)){ // if an opponent exists
							damageOpponent(rowNum, oppColNum);
							opponentCount++;
							this.sendBoard(conn, board);
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
						this.sendBoard(conn, board);
					} else{
						//System.out.println("WALA NA AKONG KALABAN! O__O break naa! ");
						this.sendBoard(conn, board);
						break;
					}
				}
			}
		}
		//System.out.println("ako si " + board[rowNum][colNum].name + " at dedz na ko.");
		//code to display board
		//code to send board to client

	}
	
	//returns column number of nearest opponent
	private int findNearestOpponent(int rowNum){
		int i=0;
		if(board[rowNum][colNum].owner == PLAYER1){
			for(i=6; i<12; i++){
				if(board[rowNum][i].isOccupied() == true){
					return i;
				}
			}
		}
		else{
			for(i=5; i>=0; i--){
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
			if(iStillExists(board)){
			//	System.out.println("Location ng kalaban ko: " + oppRowNum + " , " + oppColNum);
				//change the values of oppRowNum & oppColNum
				board[oppRowNum][oppColNum].life = board[oppRowNum][oppColNum].life - board[rowNum][colNum].damage;
				//^ life of opponent = old life - damage of this character;
			//	System.out.println("YES I AM " + board[rowNum][colNum].name + " and I am damaging " + board[oppRowNum][oppColNum].name + " new life: " + board[oppRowNum][oppColNum].life);
				
				if(board[oppRowNum][oppColNum].life <= 0){ // if deads na
					board[oppRowNum][oppColNum].reset();
				}
			}
		}
	}
	
	private boolean iStillExists(Character board[][]){
		if(board[rowNum][colNum].name == null)
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
}

import java.io.*;
import java.net.*;


public class AttackThread extends Thread{
  Character board[][];
	int rowNum;
	int colNum;
	
	public AttackThread(Character board[][], int rowNum, int colNum){
		this.board = board;
		this.rowNum = rowNum;
		this.colNum = colNum;
		start();
	}
	
	public void run(){
		int oppRowNum, oppColNum; //location of opponent
		
		if(board[rowNum][colNum].name.equals("donut")){
			//damage on all rows
			//may checker din if deads na yung opponents
		}
		
		else{
			//INSERT CODE FOR FIND NEAREST OPPONENT HERE - should return the location of nearest opponent
			//change the values of oppRowNum & oppColNum
			
			board[oppRowNum][oppColNum].life = board[oppRowNum][oppColNum].life - board[rowNum][colNum].damage;
			//^ life of opponent = old life - damage of this character;
		
			if(board[oppRowNum][oppColNum].life <= 0){ // if deads na
				board[oppRowNum][oppColNum].name = null;
				board[oppRowNum][oppColNum].damage = -1;
				board[oppRowNum][oppColNum].life = -1;
				board[oppRowNum][oppColNum].cost = -1;
			}
		}
		
		//code to display board
		//code to send board to client

	}
	
}

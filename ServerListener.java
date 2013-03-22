import java.io.*;
import java.net.*;


public class ServerListener extends Thread{
	/*players*/
	private static final int PLAYER1 = 0;
	private static final int PLAYER2 = 1;
	
	Socket s;
	int playerNum;
	MyConnection conn;
	Character board[][] = new Character[4][10];
	Boolean done[];
	int i,j;
	
	public ServerListener(Socket s, int playerNum, MyConnection conn, Character board[][], Boolean done[]){
		for(i=0; i<4; i++){
			for(j=0; j<10; j++){
				this.board[i][j] = new Character();
			}
		}
		this.playerNum = playerNum;
		this.s = s;
		this.conn = conn;
		this.board = board;
		this.done = done;

		//start();
	}
	
	public void run(){
		try{
			
			MyConnection conn = new MyConnection(s);
				
			//send the client his/her player number
			conn.sendMessage("" + playerNum + "");	
			//conn.sendMessage("KOY-koy");
		//	this.sendBoard(conn, board);
			String msgIn = "";
			//msgIn syntax:	CREATE charactername rowNum colNum
			
	/*		while((msgIn = conn.getMessage()) != null && msgIn.equals("DONE") == false){
				String token ="";
				int i = 0;
				System.out.println(msgIn);
				if(msgIn.substring(0,6).equals("CREATE")){
				
					//parsing stuff
					i = 7;
					while(msgIn.charAt(i) != ' ') {
						token = token + msgIn.charAt(i);
						i++;
					}
					
					String charName = token;
					token = "";
					int rowNum = msgIn.charAt(i+1) - 48;
					int colNum = msgIn.charAt(i+3) - 48;
					
					/*///if the specified location is not empty
		/*			if(board[rowNum][colNum].name != null){
						String msgOut = "Cannot insert. Location already taken by another character.$";
						break;
					}*/ //yung checking pala sa client natin ilalagay pati yung pag-check kung enough yung points
					
					//else get the details
			
		/*			if(charName.equals("gingerbread")){
						board[rowNum][colNum] = new Character(charName, 20, 100, 25, rowNum, colNum,  playerNum);	
					}
					
					else if(charName.equals("jellybean")){
						board[rowNum][colNum] = new Character(charName, 0, 200, 50, rowNum, colNum,  playerNum);
					}
					
					else if(charName.equals("gummybear")){
						board[rowNum][colNum] = new Character(charName, 10, 100, 15, rowNum, colNum,  playerNum);
					}
					
					else if(charName.equals("candycane")){
						board[rowNum][colNum] = new Character(charName, 0, 200, 50, rowNum, colNum,  playerNum);
					}
					
					else if(charName.equals("chocnut")){
						board[rowNum][colNum] = new Character(charName, 30, 100, 40, rowNum, colNum,  playerNum);
					}
					
					else if(charName.equals("donut")){
						board[rowNum][colNum] = new Character(charName, 10, 100, 100, rowNum, colNum,  playerNum);
					}
					
					String msgOut = "$" + board[rowNum][colNum].cost;
					conn.sendMessage(msgOut);
					
				}
				
			}
			System.out.println("nag exit ako");
			done[playerNum] = true;
			if(done[PLAYER1] && done[PLAYER2])
					fightStart(board);
		*/	
		}catch(Exception e){e.printStackTrace();}	
		
	
	}
	
	//para sabay sabay magsstart magfire. :D
	private void fightStart(Character board[][]){
		System.out.println("fightStart!");
		int i=0, j=0;
		for(i=0; i<4; i++){
			for(j=1; j<9; j++){
				if(board[i][j].isOccupied())
					board[i][j].attack(board);
			}
		}
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

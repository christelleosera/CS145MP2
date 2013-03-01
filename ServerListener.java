import java.io.*;
import java.net.*;


public class ServerListener extends Thread{
  Socket s;
	int playerNum;
	MyConnection conn;
	Character board[][];
	
	public ServerListener(Socket s, int playerNum, MyConnection conn, Character board[][]){
		this.playerNum = playerNum;
		this.s = s;
		this.conn = conn;
		this.board = board;
		start();
	}
	
	public void run(){
		try{
			MyConnection conn = new MyConnection(s);
				
			String msgIn = "";
			//msgIn syntax:	CREATE charactername rowNum colNum
			
			while((msgIn = conn.getMessage()) != null && msgIn.equals("DONE") == false){
				String token ="";
				int i = 0;
				
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
					
					/*//if the specified location is not empty
					if(board[rowNum][colNum].name != null){
						String msgOut = "Cannot insert. Location already taken by another character.$";
						break;
					}*/ //yung checking pala sa client natin ilalagay pati yung pag-check kung enough yung points
					
					//else get the details
					board[rowNum][colNum].name = charName;
					if(charName.equals("gingerbread")){
						board[rowNum][colNum].damage = 20;
						board[rowNum][colNum].life = 100;
						board[rowNum][colNum].cost = 25;
					}
					
					else if(charName.equals("jellybean")){
						board[rowNum][colNum].damage = 0;
						board[rowNum][colNum].life = 200;
						board[rowNum][colNum].cost = 50;
					}
					
					else if(charName.equals("gummybear")){
						board[rowNum][colNum].damage = 10;
						board[rowNum][colNum].life = 100;
						board[rowNum][colNum].cost = 15;
					}
					
					else if(charName.equals("candycane")){
						board[rowNum][colNum].damage = 0;
						board[rowNum][colNum].life = 200;
						board[rowNum][colNum].cost = 50;
					}
					
					else if(charName.equals("chocnut")){
						board[rowNum][colNum].damage = 30;
						board[rowNum][colNum].life = 100;
						board[rowNum][colNum].cost = 40;
					}
					
					else if(charName.equals("donut")){
						board[rowNum][colNum].damage = 10;
						board[rowNum][colNum].life = 100;
						board[rowNum][colNum].cost = 100;
					}
					
					String msgOut = "$" + board[rowNum][colNum].cost;
					conn.sendMessage(msgOut);
					
				}
			}
			
		}catch(Exception e){e.printStackTrace();}	
		
	
	}



}

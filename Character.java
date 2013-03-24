import java.io.*;
import java.util.List;
import java.net.*;

public class Character{
	String name;
	int damage;
	int life;
	int cost;
	int rowNum;
	int colNum;
	int owner;
	//MyConnection conn;
	
	public Character(){
		this.reset();
	}
	
	public Character(String name, int damage, int life, int cost, int rowNum, int colNum, int player){
		this.name = name;
		this.damage = damage;
		this.life = life;
		this.cost = cost;
		this.rowNum = rowNum;
		this.colNum = colNum;
		this.owner = player; 
		//this.conn = conn;
	}
	
	public void attack(Character board[][], MyConnection conn, List<Clients> clientsList){
		//eto nalang ipa-pass since given the rownum and colnum, pwede natin maaccess yung character na nasa position na yun, thus pwede natin malaman yung damage niya
		AttackThread at = new AttackThread(board, this.rowNum, this.colNum, conn, clientsList);
		
	}

	public boolean isOccupied(){
		if(this.owner == -1)
			return false;
		else
			return true;
	}
	
	public void reset(){
		this.name = "";
		this.damage = -1;
		this.life = -1;
		this.cost = -1;
		this.rowNum = -1;
		this.colNum = -1;
		this.owner = -1;
	}

}

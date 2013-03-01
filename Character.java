import java.io.*;
import java.net.*;

public class Character{
  String name;
	int damage;
	int life;
	int cost;
	int rowNum;
	int colNum;
	
	public Character(String name, int damage, int life, int cost, int rowNum, int colNum){
		this.name = name;
		this.damage = damage;
		this.life = life;
		this.cost = cost;
		this.rowNum = rowNum;
		this.colNum = colNum;
	}
	
	public void attack(Character board[][]){
		//eto nalang ipa-pass since given the rownum and colnum, pwede natin maaccess yung character na nasa position na yun, thus pwede natin malaman yung damage niya
		new AttackThread(board, this.rowNum, this.colNum);
	}






}

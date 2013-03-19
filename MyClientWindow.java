import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;


public class MyClientWindow extends JFrame{
	
	/*players*/
	private static final int PLAYER1 = 0;
	
	int player;
	public Character board[][] = new Character[4][10];
	private JPanel bg = new MyClientPanel(board);
	MyConnection conn;

	private ImageIcon candy1_p1 = new ImageIcon("images/card_candycane_p1.png");
	private ImageIcon candy2_p1 = new ImageIcon("images/card_chocnut_p1.png");
	private ImageIcon candy3_p1 = new ImageIcon("images/card_donut_p1.png");
	private ImageIcon candy4_p1 = new ImageIcon("images/card_gingerbreadman_p1.png");
	private ImageIcon candy5_p1 = new ImageIcon("images/card_gummybear_p1.png");
	private ImageIcon candy6_p1 = new ImageIcon("images/card_jellybean_p1.png");
	
	private ImageIcon candy1_p2 = new ImageIcon("images/card_candycane_p2.png");
	private ImageIcon candy2_p2 = new ImageIcon("images/card_chocnut_p2.png");
	private ImageIcon candy3_p2 = new ImageIcon("images/card_donut_p2.png");
	private ImageIcon candy4_p2 = new ImageIcon("images/card_gingerbreadman_p2.png");
	private ImageIcon candy5_p2 = new ImageIcon("images/card_gummybear_p2.png");
	private ImageIcon candy6_p2 = new ImageIcon("images/card_jellybean_p2.png");
	
	private ImageIcon go_btn = new ImageIcon("images/go_btn.png");
	
//	private Border emptyBorder = BorderFactory.createEmptyBorder();
	
	/*player 1 items*/
	JPanel player1 = new JPanel();

	JButton button1_p1 = new JButton(candy1_p1);
	JButton button2_p1 = new JButton(candy2_p1);
	JButton button3_p1 = new JButton(candy3_p1);
	JButton button4_p1 = new JButton(candy4_p1);
	JButton button5_p1 = new JButton(candy5_p1);
	JButton button6_p1 = new JButton(candy6_p1);
	
	/*player 2 items*/
	JPanel player2 = new JPanel();
	JButton button1_p2 = new JButton(candy1_p2);
	JButton button2_p2 = new JButton(candy2_p2);
	JButton button3_p2 = new JButton(candy3_p2);
	JButton button4_p2 = new JButton(candy4_p2);
	JButton button5_p2 = new JButton(candy5_p2);
	JButton button6_p2 = new JButton(candy6_p2);
	
	/*button*/
	JButton button_go = new JButton(go_btn);
	
	Container c;
	
	public MyClientWindow(int player, MyConnection conn){
		//initialize the board
		int i=0, j=0;
		for(i=0; i<4; i++){
			for(j=0; j<10; j++){
				board[i][j] = new Character();
			}
		}
		
		this.player = player;
	//	this.setSize(1105,700);
		this.setSize(1105,750);
		this.setResizable(false);
		this.setLocation(20,20);
		c = this.getContentPane();
		this.conn = conn;
		this.receiveBoard(conn, board);
		bg.setOpaque(false);
		
		/*PLAYER 1*/
		player1.setBounds(50, 100, 500, 400);
		player1.setOpaque(false);
		
		button1_p1.setBounds(165, 520, 120, 150);
		button2_p1.setBounds(295, 520, 120, 150);
		button3_p1.setBounds(425, 520, 120, 150);
		button4_p1.setBounds(555, 520, 120, 150);
		button5_p1.setBounds(685, 520, 120, 150);
		button6_p1.setBounds(815, 520, 120, 150);
		
	/*	button1_p1.setBounds(250, 530, 100, 122);
		button2_p1.setBounds(350, 530, 100, 122);
		button3_p1.setBounds(450, 530, 100, 122);
		button4_p1.setBounds(550, 530, 100, 122);
		button5_p1.setBounds(650, 530, 100, 122);
		button6_p1.setBounds(750, 530, 100, 122);
*/
  
		/*PLAYER 2*/
		player2.setBounds(550, 100, 500, 400);
		player2.setOpaque(false);
		button1_p2.setBounds(165, 520, 120, 150);
		button2_p2.setBounds(295, 520, 120, 150);
		button3_p2.setBounds(425, 520, 120, 150);
		button4_p2.setBounds(555, 520, 120, 150);
		button5_p2.setBounds(685, 520, 120, 150);
		button6_p2.setBounds(815, 520, 120, 150);
	/*	button1_p2.setBounds(250, 530, 100, 122);
		button2_p2.setBounds(350, 530, 100, 122);
		button3_p2.setBounds(450, 530, 100, 122);
		button4_p2.setBounds(550, 530, 100, 122);
		button5_p2.setBounds(650, 530, 100, 122);
		button6_p2.setBounds(750, 530, 100, 122);
	*/	
		c.add(player1);
		c.add(player2);
		
		button_go.setBounds(465, 15, 180, 70);
		c.add(button_go);
		
		if(this.player == PLAYER1){
			c.add(button1_p1);
			c.add(button2_p1);
			c.add(button3_p1);
			c.add(button4_p1);
			c.add(button5_p1);
			c.add(button6_p1);
		} else {
			c.add(button1_p2);
			c.add(button2_p2);
			c.add(button3_p2);
			c.add(button4_p2);
			c.add(button5_p2);
			c.add(button6_p2);
		}
	
		c.add(bg);
		bg.repaint();
		//Receive r = new Receive();
		//r.start();
		
	}
	
	public void receiveBoard(MyConnection conn, Character board[][]){
		int i=0, j=0;
		String temp="";
		for(i=0; i<4; i++){
			for(j=0; j<10; j++){
				temp = conn.getMessage();
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
	
	private class Receive extends Thread {
		String temp="";
		public void run(){
			receiveBoard(conn, board);
			bg.repaint();
		}
	}

}
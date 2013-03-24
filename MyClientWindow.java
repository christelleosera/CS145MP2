import java.awt.*;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.awt.event.*;
import java.io.*;

public class MyClientWindow extends JFrame implements MouseListener, ActionListener{
	
	/*players*/
	private static final int PLAYER1 = 0;
	private static final int PLAYER2 = 1;
	int points = 300;
	int player;
	public Character board[][] = new Character[4][10];
	public MyClientPanel bg = new MyClientPanel(board, points);
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
	
	private ImageIcon sprinkle_p1 = new ImageIcon("images/sprinkle_p1.png");
	private ImageIcon sprinkle_p2 = new ImageIcon("images/sprinkle_p2.png");
	
	private SprinklePanel sprinkle1_p1 = new SprinklePanel();
	
	private ImageIcon go_btn = new ImageIcon("images/go_btn.png");
	
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
	
	JLabel points_lbl = new JLabel("<html><center><font size=5>Points left:<br>" + points + "</font></center></html>");

	
	Container c;
	String charName;
	
	public MyClientWindow(int player, MyConnection conn){
		//initialize the board
		int i=0, j=0;
		for(i=0; i<4; i++){
			for(j=0; j<10; j++){
				board[i][j] = new Character();
			}
		}
		board[0][0] = new Character("cupcake", 0, 300, 0, 0, 0, 0); board[0][0].owner = PLAYER1;
		board[1][0] = new Character("cupcake", 0, 300, 0, 1, 0, 0); board[1][0].owner = PLAYER1;
		board[2][0] = new Character("cupcake", 0, 300, 0, 2, 0, 0); board[2][0].owner = PLAYER1;
		board[3][0] = new Character("cupcake", 0, 300, 0, 3, 0, 0); board[3][0].owner = PLAYER1;
				
		board[0][9] = new Character("cupcake", 0, 300, 0, 0, 11, 1); board[0][9].owner = PLAYER2;
		board[1][9] = new Character("cupcake", 0, 300, 0, 1, 11, 1); board[1][9].owner = PLAYER2;
		board[2][9] = new Character("cupcake", 0, 300, 0, 2, 11, 1); board[2][9].owner = PLAYER2;
		board[3][9] = new Character("cupcake", 0, 300, 0, 3, 11, 1); board[3][9].owner = PLAYER2;
		
		this.player = player;
		this.setSize(1105,750);
		this.setResizable(false);
		this.setLocation(20,20);
		c = this.getContentPane();
		this.conn = conn;
	//	this.receiveBoard(conn, board);
		bg.setOpaque(false);
		c.add(points_lbl);
		
		/*PLAYER 1*/
		player1.setBounds(50, 100, 500, 400);
		player1.setOpaque(false);
		button1_p1.setBounds(165, 520, 120, 150);
		button2_p1.setBounds(295, 520, 120, 150);
		button3_p1.setBounds(425, 520, 120, 150);
		button4_p1.setBounds(555, 520, 120, 150);
		button5_p1.setBounds(685, 520, 120, 150);
		button6_p1.setBounds(815, 520, 120, 150);
		
		/*PLAYER 2*/
		player2.setBounds(550, 100, 500, 400);
		player2.setOpaque(false);
		button1_p2.setBounds(165, 520, 120, 150);
		button2_p2.setBounds(295, 520, 120, 150);
		button3_p2.setBounds(425, 520, 120, 150);
		button4_p2.setBounds(555, 520, 120, 150);
		button5_p2.setBounds(685, 520, 120, 150);
		button6_p2.setBounds(815, 520, 120, 150);
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
			points_lbl.setBounds(350, 15, 100, 100);
		} else {
			c.add(button1_p2);
			c.add(button2_p2);
			c.add(button3_p2);
			c.add(button4_p2);
			c.add(button5_p2);
			c.add(button6_p2);
			points_lbl.setBounds(650, 15, 100, 100);
		}
	
		c.add(bg);
		bg.repaint();

		button1_p1.addActionListener(this);
		button1_p1.setActionCommand("candycane");
		button2_p1.addActionListener(this);
		button2_p1.setActionCommand("chocnut");
		button3_p1.addActionListener(this);
		button3_p1.setActionCommand("donut");
		button4_p1.addActionListener(this);
		button4_p1.setActionCommand("gingerbread");
		button5_p1.addActionListener(this);
		button5_p1.setActionCommand("gummybear");
		button6_p1.addActionListener(this);
		button6_p1.setActionCommand("jellybean");
		
		button1_p2.addActionListener(this);
		button1_p2.setActionCommand("candycane");
		button2_p2.addActionListener(this);
		button2_p2.setActionCommand("chocnut");
		button3_p2.addActionListener(this);
		button3_p2.setActionCommand("donut");
		button4_p2.addActionListener(this);
		button4_p2.setActionCommand("gingerbread");
		button5_p2.addActionListener(this);
		button5_p2.setActionCommand("gummybear");
		button6_p2.addActionListener(this);
		button6_p2.setActionCommand("jellybean");
		Go go = new Go();
		button_go.addActionListener(go);
		//button_go.setActionCommand("fight");
		
	/*	sprinkle1_p1.setPlayer(player);
		bg.add(sprinkle1_p1);
		sprinkle1_p1.setValues(250, 130, 600);
		sprinkle1_p1.setBounds(0, 0, 1105, 750);
		sprinkle1_p1.setOpaque(false);
	*/
		
		bg.setGame(true);
		bg.repaint();
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
    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int dmg = 0, life = 0, cost = 0;
		System.out.println("x: " + x + "\ty: " + y);
		
				if(charName.equals("candycane")){
					dmg = 0;
					life = 200;
					cost = 50;
				}
				
				else if(charName.equals("chocnut")){
					dmg = 30;
					life = 100;
					cost = 40;
				}
					
				else if(charName.equals("donut")){
					dmg = 10;
					life = 100;
					cost = 100;
				}	
				
				else if(charName.equals("gingerbread")){
					dmg = 20;
					life = 100;
					cost = 25;
				}
				
				else if(charName.equals("gummybear")){
					dmg = 10;
					life = 100;
					cost = 15;
				}
				
				
				else if(charName.equals("jellybean")){
					dmg = 0;
					life = 200;
					cost = 50;
				}
					
		int rowNum = (y-105)/100;
		int colNum = (x-55)/100;
		if(player == PLAYER1 && x >= 155 && x <= 545 && y >= 105 && y <= 495 && board[rowNum][colNum].isOccupied() == false){
			board[rowNum][colNum] = new Character(charName, dmg, life, cost, rowNum, colNum, PLAYER1);
			points = points - cost;
			player1.repaint();
			bg.removeMouseListener(this);
		}
		else if(player == PLAYER2 && x >= 555 && x <= 945 && y >= 105 && y <= 495 && board[rowNum][colNum].isOccupied() == false){
			board[rowNum][colNum] = new Character(charName, dmg, life, cost, rowNum, colNum, PLAYER2);
			player2.repaint();
			points = points - cost;
			bg.removeMouseListener(this);
		}
		
		if(player == PLAYER1){
			//candycane
			if(points < 35) button1_p1.setEnabled(false);
			//chocnut
			if(points < 40) button2_p1.setEnabled(false);
			//donut
			if(points < 100) button3_p1.setEnabled(false);
			//gingerbread
			if(points < 25) button4_p1.setEnabled(false);
			//gummybear
			if(points < 15) button5_p1.setEnabled(false);
			//jellybean
			if(points < 50) button6_p1.setEnabled(false);
		}
		else if(player == PLAYER2){
			//candycane
			if(points < 35) button1_p2.setEnabled(false);
			//chocnut
			if(points < 40) button2_p2.setEnabled(false);
			//donut
			if(points < 100) button3_p2.setEnabled(false);
			//gingerbread
			if(points < 25) button4_p2.setEnabled(false);
			//gummybear
			if(points < 15) button5_p2.setEnabled(false);
			//jellybean
			if(points < 50) button6_p2.setEnabled(false);
		}
		
		points_lbl.setText("<html><center><font size=5>Points left:<br>" + points + "</font></center></html>");

		
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		charName = e.getActionCommand();
		if(charName.equals("fight") == false)
			bg.addMouseListener(this);
	}
	
	private class Go implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			sendDone();	
		}
	}
	
	private void sendDone(){
		conn.sendMessage("DONE");
		button_go.setVisible(false);
		if(this.player == PLAYER1){
			button1_p1.setVisible(false);
			button2_p1.setVisible(false);
			button3_p1.setVisible(false);
			button4_p1.setVisible(false);
			button5_p1.setVisible(false);
			button6_p1.setVisible(false);
		} else if(this.player == PLAYER2){
			button1_p2.setVisible(false);
			button2_p2.setVisible(false);
			button3_p2.setVisible(false);
			button4_p2.setVisible(false);
			button5_p2.setVisible(false);
			button6_p2.setVisible(false);
		}
		//send Own Board
		sendBoard(this.conn,this.board, player);
	
		Receive r = new Receive();
		r.start();
		
	}
	
	
	private class Receive extends Thread {
		String temp="";
		int winner=-1;
		public void run(){
			System.out.println("Err. Irreceive ko na yung board ha? ");
			
			while(true){
				temp = conn.getMessage();
				if(temp.contains("UPDATE")){
					//get a copy of the board.
					receiveBoard(conn, board);
					System.out.println("updateBoard.");
					bg.repaint();
				} else if(temp.contains("ENDGAME")){
					winner = Integer.parseInt(temp.substring(7));
					winner++;
					JOptionPane.showMessageDialog(null, winner + " wins! :D");
					dispose(); //temp muna to, pero gagawa pa ng new window
				}
				
			}
		}
	}

	public void sendBoard(MyConnection conn, Character board[][], int player){
		int i=0, j=0;
		if(player == PLAYER1){
			for(i=0; i<4; i++){
				for(j=0; j<5; j++){
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
		else if(player == PLAYER2){
			for(i=0; i<4; i++){
				for(j=5; j<10; j++){
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

}

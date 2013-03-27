import java.awt.*;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class MyClientPanel extends JPanel implements ActionListener{
	
	/*players*/
	private static final int PLAYER1 = 0;
	private static final int PLAYER2 = 1;
	
	private Image candycane_p1, chocnut_p1, donut_p1, gingerbread_p1, gummybear_p1, jellybean_p1, cupcake_p1;
	private Image candycane_p2, chocnut_p2, donut_p2, gingerbread_p2, gummybear_p2, jellybean_p2, cupcake_p2;
	private Image mm1, mm2, mm3, mm4, mm5, mm6, mm7, mm8, mm9;
	private Image choc1, choc2, choc3, choc4, choc5, choc6, choc7, choc8, choc9;
	private Image spr1, spr2, spr3, spr4, spr5, spr6, spr7, spr8, spr9;
	
	private Image mm1_p2, mm2_p2, mm3_p2, mm4_p2, mm5_p2, mm6_p2, mm7_p2, mm8_p2, mm9_p2;
	private Image choc1_p2, choc2_p2, choc3_p2, choc4_p2, choc5_p2, choc6_p2, choc7_p2, choc8_p2, choc9_p2;
	private Image spr1_p2, spr2_p2, spr3_p2, spr4_p2, spr5_p2, spr6_p2, spr7_p2, spr8_p2, spr9_p2;
	
	Character board[][];
	int points;
	Coordinates coord[] = new Coordinates[32];
	
	int x=150, y=150, endX=500, player;
	private Image sprinkle_p1, sprinkle_p2;
	private Boolean gameStarted = false;
	Timer t = new Timer(7, this);
	int i=0;
	 
	private Image background, board_p1, board_p2;
	public MyClientPanel(Character board[][], int points){
		this.getImages();
		this.setSize(1105,750);
		this.board = board;
		this.points = points;
		
		for(i=0; i<32; i++)
			coord[i] = new Coordinates();
	}
	
	private final void getImages() { 
		 URL url;
	        try {
	            url = getClass().getResource("images/bg.jpg");
	            if(url == null) throw new IOException("Couldn't load bg.jpg");
	            background = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/board_p1.png");
	            if(url == null) throw new IOException("Couldn't load board_p1.png");
	            board_p1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/board_p2.png");
	            if(url == null) throw new IOException("Couldn't load board_p2.png");
	            board_p2 = new ImageIcon(url).getImage();
	            
	            /*PLAYER 1*/
	            url = getClass().getResource("images/candycane_p1.png");
	            if(url == null) throw new IOException("Couldn't load candycane_p1.png");
	            candycane_p1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/chocnut_p1.png");
	            if(url == null) throw new IOException("Couldn't load chocnut_p1.png");
	            chocnut_p1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/donut_p1.png");
	            if(url == null) throw new IOException("Couldn't load donut_p1.png");
	            donut_p1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/gingerbreadman_p1.png");
	            if(url == null) throw new IOException("Couldn't load gingerbreadman_p1.png");
	            gingerbread_p1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/gummybear_p1.png");
	            if(url == null) throw new IOException("Couldn't load gummybear_p1.png");
	            gummybear_p1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/jellybean_p1.png");
	            if(url == null) throw new IOException("Couldn't load jellybean_p1.png");
	            jellybean_p1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/cupcake_p1.png");
	            if(url == null) throw new IOException("Couldn't load cupcake_p1.png");
	            cupcake_p1 = new ImageIcon(url).getImage();
	            
	            /*PLAYER 2*/
	            url = getClass().getResource("images/candycane_p2.png");
	            if(url == null) throw new IOException("Couldn't load candycane_p2.png");
	            candycane_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/chocnut_p2.png");
	            if(url == null) throw new IOException("Couldn't load chocnut_p2.png");
	            chocnut_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/donut_p2.png");
	            if(url == null) throw new IOException("Couldn't load donut_p2.png");
	            donut_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/gingerbreadman_p2.png");
	            if(url == null) throw new IOException("Couldn't load gingerbreadman_p2.png");
	            gingerbread_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/gummybear_p2.png");
	            if(url == null) throw new IOException("Couldn't load gummybear_p2.png");
	            gummybear_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/jellybean_p2.png");
	            if(url == null) throw new IOException("Couldn't load jellybean_p2.png");
	            jellybean_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/cupcake_p2.png");
	            if(url == null) throw new IOException("Couldn't load cupcake_p2.png");
	            cupcake_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/sprinkle_p1.png");
	            if(url == null) throw new IOException("Couldn't load sprinkle_p1.png");
	            sprinkle_p1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/sprinkle_p2.png");
	            if(url == null) throw new IOException("Couldn't load sprinkle_p2.png");
	            sprinkle_p2 = new ImageIcon(url).getImage();
	            
	            /*m&ms*/
	            url = getClass().getResource("images/100_m&m.gif");
	            if(url == null) throw new IOException("Couldn't load 100_m&m.gif");
	            mm1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/200_m&m.gif");
	            if(url == null) throw new IOException("Couldn't load 200_m&m.gif");
	            mm2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/300_m&m.gif");
	            if(url == null) throw new IOException("Couldn't load 300_m&m.gif");
	            mm3 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/400_m&m.gif");
	            if(url == null) throw new IOException("Couldn't load 400_m&m.gif");
	            mm4 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/500_m&m.gif");
	            if(url == null) throw new IOException("Couldn't load 500_m&m.gif");
	            mm5 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/600_m&m.gif");
	            if(url == null) throw new IOException("Couldn't load 600_m&m.gif");
	            mm6 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/700_m&m.gif");
	            if(url == null) throw new IOException("Couldn't load 700_m&m.gif");
	            mm7 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/800_m&m.gif");
	            if(url == null) throw new IOException("Couldn't load 800_m&m.gif");
	            mm8 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/900_m&m.gif");
	            if(url == null) throw new IOException("Couldn't load 900_m&m.gif");
	            mm9 = new ImageIcon(url).getImage();
	            
	            
	            /*chocnut*/
	            url = getClass().getResource("images/100_chocnut.gif");
	            if(url == null) throw new IOException("Couldn't load 100_chocnut.gif");
	            choc1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/200_chocnut.gif");
	            if(url == null) throw new IOException("Couldn't load 200_chocnut.gif");
	            choc2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/300_chocnut.gif");
	            if(url == null) throw new IOException("Couldn't load 300_chocnut.gif");
	            choc3 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/400_chocnut.gif");
	            if(url == null) throw new IOException("Couldn't load 400_chocnut.gif");
	            choc4 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/500_chocnut.gif");
	            if(url == null) throw new IOException("Couldn't load 500_chocnut.gif");
	            choc5 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/600_chocnut.gif");
	            if(url == null) throw new IOException("Couldn't load 600_chocnut.gif");
	            choc6 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/700_chocnut.gif");
	            if(url == null) throw new IOException("Couldn't load 700_chocnut.gif");
	            choc7 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/800_chocnut.gif");
	            if(url == null) throw new IOException("Couldn't load 800_chocnut.gif");
	            choc8 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/900_chocnut.gif");
	            if(url == null) throw new IOException("Couldn't load 900_chocnut.gif");
	            choc9 = new ImageIcon(url).getImage();
	            
	            /*sprinkle*/
	            url = getClass().getResource("images/100_sprinkle.gif");
	            if(url == null) throw new IOException("Couldn't load 100_sprinkle.gif");
	            spr1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/200_sprinkle.gif");
	            if(url == null) throw new IOException("Couldn't load 200_sprinkle.gif");
	            spr2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/300_sprinkle.gif");
	            if(url == null) throw new IOException("Couldn't load 300_sprinkle.gif");
	            spr3 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/400_sprinkle.gif");
	            if(url == null) throw new IOException("Couldn't load 400_sprinkle.gif");
	            spr4 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/500_sprinkle.gif");
	            if(url == null) throw new IOException("Couldn't load 500_sprinkle.gif");
	            spr5 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/600_sprinkle.gif");
	            if(url == null) throw new IOException("Couldn't load 600_sprinkle.gif");
	            spr6 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/700_sprinkle.gif");
	            if(url == null) throw new IOException("Couldn't load 700_sprinkle.gif");
	            spr7 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/800_sprinkle.gif");
	            if(url == null) throw new IOException("Couldn't load 800_sprinkle.gif");
	            spr8 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/900_sprinkle.gif");
	            if(url == null) throw new IOException("Couldn't load 900_sprinkle.gif");
	            spr9 = new ImageIcon(url).getImage();
	            
	            /*m&ms - player2*/
	            url = getClass().getResource("images/100_m&m_2.gif");
	            if(url == null) throw new IOException("Couldn't load 100_m&m_2.gif");
	            mm1_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/200_m&m_2.gif");
	            if(url == null) throw new IOException("Couldn't load 200_m&m_2.gif");
	            mm2_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/300_m&m_2.gif");
	            if(url == null) throw new IOException("Couldn't load 300_m&m_2.gif");
	            mm3_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/400_m&m_2.gif");
	            if(url == null) throw new IOException("Couldn't load 400_m&m_2.gif");
	            mm4_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/500_m&m_2.gif");
	            if(url == null) throw new IOException("Couldn't load 500_m&m_2.gif");
	            mm5_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/600_m&m_2.gif");
	            if(url == null) throw new IOException("Couldn't load 600_m&m_2.gif");
	            mm6_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/700_m&m_2.gif");
	            if(url == null) throw new IOException("Couldn't load 700_m&m_2.gif");
	            mm7_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/800_m&m_2.gif");
	            if(url == null) throw new IOException("Couldn't load 800_m&m_2.gif");
	            mm8_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/900_m&m_2.gif");
	            if(url == null) throw new IOException("Couldn't load 900_m&m_2.gif");
	            mm9_p2 = new ImageIcon(url).getImage();
	            
	            
	            /*chocnut - player2*/
	            url = getClass().getResource("images/100_chocnut_2.gif");
	            if(url == null) throw new IOException("Couldn't load 100_chocnut_2.gif");
	            choc1_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/200_chocnut_2.gif");
	            if(url == null) throw new IOException("Couldn't load 200_chocnut_2.gif");
	            choc2_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/300_chocnut_2.gif");
	            if(url == null) throw new IOException("Couldn't load 300_chocnut_2.gif");
	            choc3_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/400_chocnut_2.gif");
	            if(url == null) throw new IOException("Couldn't load 400_chocnut_2.gif");
	            choc4_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/500_chocnut_2.gif");
	            if(url == null) throw new IOException("Couldn't load 500_chocnut_2.gif");
	            choc5_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/600_chocnut_2.gif");
	            if(url == null) throw new IOException("Couldn't load 600_chocnut_2.gif");
	            choc6_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/700_chocnut_2.gif");
	            if(url == null) throw new IOException("Couldn't load 700_chocnut_2.gif");
	            choc7_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/800_chocnut.gif");
	            if(url == null) throw new IOException("Couldn't load 800_chocnut_2.gif");
	            choc8_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/900_chocnut_2.gif");
	            if(url == null) throw new IOException("Couldn't load 900_chocnut_2.gif");
	            choc9_p2 = new ImageIcon(url).getImage();
	            
	            /*sprinkle - player2*/
	            url = getClass().getResource("images/100_sprinkle_2.gif");
	            if(url == null) throw new IOException("Couldn't load 100_sprinkle_2.gif");
	            spr1_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/200_sprinkle_2.gif");
	            if(url == null) throw new IOException("Couldn't load 200_sprinkle_2.gif");
	            spr2_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/300_sprinkle_2.gif");
	            if(url == null) throw new IOException("Couldn't load 300_sprinkle_2.gif");
	            spr3_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/400_sprinkle_2.gif");
	            if(url == null) throw new IOException("Couldn't load 400_sprinkle_2.gif");
	            spr4_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/500_sprinkle_2.gif");
	            if(url == null) throw new IOException("Couldn't load 500_sprinkle_2.gif");
	            spr5_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/600_sprinkle_2.gif");
	            if(url == null) throw new IOException("Couldn't load 600_sprinkle_2.gif");
	            spr6_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/700_sprinkle_2.gif");
	            if(url == null) throw new IOException("Couldn't load 700_sprinkle_2.gif");
	            spr7_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/800_sprinkle_2.gif");
	            if(url == null) throw new IOException("Couldn't load 800_sprinkle_2.gif");
	            spr8_p2 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/900_sprinkle_2.gif");
	            if(url == null) throw new IOException("Couldn't load 900_sprinkle_2.gif");
	            spr9_p2 = new ImageIcon(url).getImage();
	            
	        } catch(IOException e) {
	            System.err.println(e);
	        }
   }
	
	public void paintComponent(Graphics g){
		int i=0, j=0, owner=-1, temp=0, count=0, distance=0, k=0;
		String name="";
		super.paintComponent(g);	
		Graphics2D g2d = (Graphics2D) g.create();
		
		
		g.drawImage(background, 0, 0, null);
		
		g.drawImage(board_p1, 50, 100, null);
		g.drawImage(board_p2, 550, 100, null);
		//g2d.drawImage(mm9, 50+(j*100), 100+(i*100), this);
		for(i=0; i<4; i++){
			for(j=0; j<10; j++){
				owner = board[i][j].owner;
				name = board[i][j].name;
				temp = findNearestOpponent(i,j);
				
				//System.out.println("owner: " + owner + " name: " + name);
				
				if(owner == PLAYER1){
					distance = temp - j;
					
					if(name.equals("cupcake"))
						g.drawImage(cupcake_p1, 50+(j*100), 100+(i*100), null);
					else if(name.equals("candycane"))
						g.drawImage(candycane_p1, 50+(j*100), 100+(i*100), null);
					else if(name.equals("chocnut"))
						g.drawImage(chocnut_p1, 50+(j*100), 100+(i*100), null);
					else if(name.equals("donut"))
						g.drawImage(donut_p1, 50+(j*100), 100+(i*100), null);
					else if(name.equals("gingerbread"))
						g.drawImage(gingerbread_p1, 50+(j*100), 100+(i*100), null);
					else if(name.equals("gummybear"))
						g.drawImage(gummybear_p1, 50+(j*100), 100+(i*100), null);
					else if(name.equals("jellybean"))
						g.drawImage(jellybean_p1, 50+(j*100), 100+(i*100), null);
					
				}
				else if(owner == PLAYER2){
					distance = j - temp; 
					
					if(name.equals("cupcake"))
						g.drawImage(cupcake_p2, 50+(j*100), 100+(i*100), null);
					else if(name.equals("candycane"))
						g.drawImage(candycane_p2, 50+(j*100), 100+(i*100), null);
					else if(name.equals("chocnut"))
						g.drawImage(chocnut_p2, 50+(j*100), 100+(i*100), null);
					else if(name.equals("donut"))
						g.drawImage(donut_p2, 50+(j*100), 100+(i*100), null);
					else if(name.equals("gingerbread"))
						g.drawImage(gingerbread_p2, 50+(j*100), 100+(i*100), null);
					else if(name.equals("gummybear"))
						g.drawImage(gummybear_p2, 50+(j*100), 100+(i*100), null);
					else if(name.equals("jellybean"))
						g.drawImage(jellybean_p2, 50+(j*100), 100+(i*100), null);
				}
				
				if(gameStarted && !name.equals("cupcake")){
				
					 if(owner == PLAYER1){
						 System.out.println("I am player " + board[i][j].name + "with distance " + distance);
						 
						 if(name.equals("gingerbread")){
							 if(distance == 1)
								 g2d.drawImage(mm1, 50+(j*100), 100+(i*100), this);
							 else if(distance == 2)
								 g2d.drawImage(mm2, 50+(j*100), 100+(i*100), this);
							 else if(distance == 3)
								 g2d.drawImage(mm3, 50+(j*100), 100+(i*100), this);
							 else if(distance == 4)
								 g2d.drawImage(mm4, 50+(j*100), 100+(i*100), this);
							 else if(distance == 5)
								 g2d.drawImage(mm5, 50+(j*100), 100+(i*100), this);
							 else if(distance == 6)
								 g2d.drawImage(mm6, 50+(j*100), 100+(i*100), this);
							 else if(distance == 7)
								 g2d.drawImage(mm7, 50+(j*100), 100+(i*100), this);
							 else if(distance == 8)
								 g2d.drawImage(mm8, 50+(j*100), 100+(i*100), this);
							 else if(distance == 9)
								 g2d.drawImage(mm9, 50+(j*100), 100+(i*100), this);
							 
						 } else if(name.equals("chocnut")){
							 
							 if(distance == 1)
								 g2d.drawImage(choc1, 50+(j*100), 100+(i*100), this);
							 else if(distance == 2)
								 g2d.drawImage(choc2, 50+(j*100), 100+(i*100), this);
							 else if(distance == 3)
								 g2d.drawImage(choc3, 50+(j*100), 100+(i*100), this);
							 else if(distance == 4)
								 g2d.drawImage(choc4, 50+(j*100), 100+(i*100), this);
							 else if(distance == 5)
								 g2d.drawImage(choc5, 50+(j*100), 100+(i*100), this);
							 else if(distance == 6)
								 g2d.drawImage(choc6, 50+(j*100), 100+(i*100), this);
							 else if(distance == 7)
								 g2d.drawImage(choc7, 50+(j*100), 100+(i*100), this);
							 else if(distance == 8)
								 g2d.drawImage(choc8, 50+(j*100), 100+(i*100), this);
							 else if(distance == 9)
								 g2d.drawImage(choc9, 50+(j*100), 100+(i*100), this);
							 
						 } else if(name.equals("donut")){
							 for(k=0; k<4; k++){
								 temp = findNearestOpponent(k,j);
								 if(owner == PLAYER1)
									 distance = j - temp;
								// else if(owner == PLAYER2)
									// distance = temp - j;
								 
								 if(distance == 1)
									 g2d.drawImage(spr1, 100+(j*100), 100+(k*100), this);
								 else if(distance == 2)
									 g2d.drawImage(spr2, 100+(j*100), 100+(k*100), this);
								 else if(distance == 3)
									 g2d.drawImage(spr3, 100+(j*100), 100+(k*100), this);
								 else if(distance == 4)
									 g2d.drawImage(spr4, 50+(j*100), 100+(k*100), this);
								 else if(distance == 5)
									 g2d.drawImage(spr5, 50+(j*100), 100+(k*100), this);
								 else if(distance == 6)
									 g2d.drawImage(spr6, 50+(j*100), 100+(k*100), this);
								 else if(distance == 7)
									 g2d.drawImage(spr7, 50+(j*100), 100+(k*100), this);
								 else if(distance == 8)
									 g2d.drawImage(spr8, 50+(j*100), 100+(k*100), this);
								 else if(distance == 9)
									 g2d.drawImage(spr9, 50+(j*100), 100+(k*100), this);
							 }
							 
						 }  
						 
					 } else if(owner == PLAYER2){
						 System.out.println("I am player " + board[i][j].name + "with distance " + distance);
						 
						 if(name.equals("gingerbread")){
							 if(distance == 1)
								 g2d.drawImage(mm1_p2, 50+((j-1)*100), 100+(i*100), this);
							 else if(distance == 2)
								 g2d.drawImage(mm2_p2, 50+((j-2)*100), 100+(i*100), this);
							 else if(distance == 3)
								 g2d.drawImage(mm3_p2, 50+((j-3)*100), 100+(i*100), this);
							 else if(distance == 4)
								 g2d.drawImage(mm4_p2, 50+((j-4)*100), 100+(i*100), this);
							 else if(distance == 5)
								 g2d.drawImage(mm5_p2, 50+((j-5)*100), 100+(i*100), this);
							 else if(distance == 6)
								 g2d.drawImage(mm6_p2, 50+((j-6)*100), 100+(i*100), this);
							 else if(distance == 7)
								 g2d.drawImage(mm7_p2, 50+((j-7)*100), 100+(i*100), this);
							 else if(distance == 8)
								 g2d.drawImage(mm8_p2, 50+((j-8)*100), 100+(i*100), this);
							 else if(distance == 9)
								 g2d.drawImage(mm9_p2, 50+((j-9)*100), 100+(i*100), this);
							 
						 } else if(name.equals("chocnut")){
							 
							 if(distance == 1)
								 g2d.drawImage(choc1_p2, 50+((j-1)*100), 100+(i*100), this);
							 else if(distance == 2)
								 g2d.drawImage(choc2_p2, 50+((j-2)*100), 100+(i*100), this);
							 else if(distance == 3)
								 g2d.drawImage(choc3_p2, 50+((j-3)*100), 100+(i*100), this);
							 else if(distance == 4)
								 g2d.drawImage(choc4_p2, 50+((j-4)*100), 100+(i*100), this);
							 else if(distance == 5)
								 g2d.drawImage(choc5_p2, 50+((j-5)*100), 100+(i*100), this);
							 else if(distance == 6)
								 g2d.drawImage(choc6_p2, 50+((j-6)*100), 100+(i*100), this);
							 else if(distance == 7)
								 g2d.drawImage(choc7_p2, 50+((j-7)*100), 100+(i*100), this);
							 else if(distance == 8)
								 g2d.drawImage(choc8_p2, 50+((j-8)*100), 100+(i*100), this);
							 else if(distance == 9)
								 g2d.drawImage(choc9_p2, 50+((j-9)*100), 100+(i*100), this);
							 
						 } else if(name.equals("donut")){
							 for(k=0; k<4; k++){
								 temp = findNearestOpponent(k,j);
								 if(owner == PLAYER1)
									 distance = j - temp;
								// else if(owner == PLAYER2)
									// distance = temp - j;
								 
								 if(distance == 1)
									 g2d.drawImage(spr1_p2, 100+((j-1)*100), 100+(k*100), this);
								 else if(distance == 2)
									 g2d.drawImage(spr2_p2, 100+((j-2)*100), 100+(k*100), this);
								 else if(distance == 3)
									 g2d.drawImage(spr3_p2, 100+((j-3)*100), 100+(k*100), this);
								 else if(distance == 4)
									 g2d.drawImage(spr4_p2, 50+((j-4)*100), 100+(k*100), this);
								 else if(distance == 5)
									 g2d.drawImage(spr5_p2, 50+((j-5)*100), 100+(k*100), this);
								 else if(distance == 6)
									 g2d.drawImage(spr6_p2, 50+((j-6)*100), 100+(k*100), this);
								 else if(distance == 7)
									 g2d.drawImage(spr7_p2, 50+((j-7)*100), 100+(k*100), this);
								 else if(distance == 8)
									 g2d.drawImage(spr8_p2, 50+((j-8)*100), 100+(k*100), this);
								 else if(distance == 9)
									 g2d.drawImage(spr9_p2, 50+((j-9)*100), 100+(k*100), this);
							 }
							 
						 } 
						 
						 
						 
					 }
					 repaint();
					 //t.start();
				}
			}	
			
		}
		
/*		if(gameStarted){
			for(i=0; i<count; i++){
				if(coord[i].owner == PLAYER1){
					//if(coord[i].x < coord[i].endX){
					//	System.out.println("Coord.x " + (coord[i].x)*100);
						g.drawImage(sprinkle_p1, 50+(coord[i].x*100), 100+(coord[i].y*100), null);
					//	g.drawImage(sprinkle_p1, x, y, null);
						
					//}
				}
				else if(coord[i].owner == PLAYER2){
				//	if(coord[i].x > coord[i].endX){
						g.drawImage(sprinkle_p2, 50+(coord[i].x*100), 100+(coord[i].y*100), null);
					//}
				}	
				//JOptionPane.showMessageDialog(null, "New x: " + 50+(coord[i].x*100));
			//	t = new Timer(5, this);
			//	t.start();
			//}
			}
			 
			count = 0;
		}
	*/	
		
		
	
		
	}
	
	/*public void actionPerformed(ActionEvent e){
		int i=0;
		for(i=0; i<32; i++){
			if(coord[i].owner == PLAYER1)
				coord[i].x += 2;
			else if(coord[i].owner == PLAYER2)
				coord[i].x -= 2;	
			
		}
		//if(x < endX)
		x+=2;
		repaint();
		
	}
*/
	public void actionPerformed(ActionEvent e){
		repaint();
	}
	
	public void setGame(Boolean response){
		this.gameStarted = response;
	}
	
	public boolean imageUpdate( Image img, int flags, int x, int y,int w, int h ){
	    repaint();
	    return true;
	}
	
	private int findNearestOpponent(int rowNum, int colNum){
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
	
}

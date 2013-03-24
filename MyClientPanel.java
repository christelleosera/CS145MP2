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
	
	Character board[][];
	int points;
	
	int x=150, y=150, endX=500, player;
	private Image sprinkle_p1, sprinkle_p2;
	private Boolean gameStarted = false;
	Timer t = new Timer(7, this);
	 
	private Image background, board_p1, board_p2;
	public MyClientPanel(Character board[][], int points){
		this.getImages();
		this.setSize(1105,750);
		this.board = board;
		this.points = points;
	}
	
	private final void getImages() { 
		 URL url;
	        try {
	            url = getClass().getResource("images/bg.png");
	            if(url == null) throw new IOException("Couldn't load bg.png");
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
	            
	        } catch(IOException e) {
	            System.err.println(e);
	        }
   }
	
	public void paintComponent(Graphics g){
		int i=0, j=0, owner=-1;
		String name="";
		super.paintComponent(g);	
		
		g.drawImage(background, 0, 0, null);
		g.drawImage(board_p1, 50, 100, null);
		g.drawImage(board_p2, 550, 100, null);
		for(i=0; i<4; i++){
			for(j=0; j<10; j++){
				owner = board[i][j].owner;
				name = board[i][j].name;
				//System.out.println("owner: " + owner + " name: " + name);
				
				if(owner == PLAYER1){
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
			}
		}
		
		if(gameStarted &&  x<endX){
			if(player == PLAYER1)
				g.drawImage(sprinkle_p1, x, y, null);
			else if(player == PLAYER2)
				g.drawImage(sprinkle_p2, x, y, null);
			
			t.start(); 
		}
	
		
	}
	
	public void actionPerformed(ActionEvent e){
		x += 2;
		//if(x < endX)
			repaint();
		
	}

	public void setGame(Boolean response){
		this.gameStarted = response;
	}
	
	
}

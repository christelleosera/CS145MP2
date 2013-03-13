import java.awt.*;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

public class MyClientPanel extends JPanel{
	
	private Image candycane_p1, chocnut_p1, donut_p1, gingerbread_p1, gummybear_p1, jellybean_p1;
	Character board[][];
	 
	private Image background, board_p1, board_p2;
	public MyClientPanel(Character board[][]){
		this.getImages();
		this.setSize(1105,700);
		this.board = board;
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
	            
	            url = getClass().getResource("images/candycane_p1.png");
	            if(url == null) throw new IOException("Couldn't load candycane_p1.png");
	            candycane_p1 = new ImageIcon(url).getImage();
	            
	        } catch(IOException e) {
	            System.err.println(e);
	        }
   }
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		
		g.drawImage(background, 0, 0, null);
		g.drawImage(board_p1, 50, 100, null);
		g.drawImage(board_p2, 550, 100, null);
		
	}

	
}

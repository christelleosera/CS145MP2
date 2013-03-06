import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;


public class MyClientWindow extends JFrame{
	private JPanel bg = new Background();
	private Image background, boardP1, boardP2;
	
	private ImageIcon candy1_p1 = new ImageIcon("images/candycane_p1.png");
	private ImageIcon candy2_p1 = new ImageIcon("images/chocnut_p1.png");
	private ImageIcon candy3_p1 = new ImageIcon("images/donut_p1.png");
	private ImageIcon candy4_p1 = new ImageIcon("images/gingerbreadman_p1.gif");
	private ImageIcon candy5_p1 = new ImageIcon("images/gummybear_p1.png");
	private ImageIcon candy6_p1 = new ImageIcon("images/jellybean_p1.png");
	
	private ImageIcon candy1_p2 = new ImageIcon("images/candycane_p2.png");
	private ImageIcon candy2_p2 = new ImageIcon("images/chocnut_p2.png");
	private ImageIcon candy3_p2 = new ImageIcon("images/donut_p2.png");
	private ImageIcon candy4_p2 = new ImageIcon("images/gingerbreadman_p2.gif");
	private ImageIcon candy5_p2 = new ImageIcon("images/gummybear_p2.png");
	private ImageIcon candy6_p2 = new ImageIcon("images/jellybean_p2.png");
	
	/*player 1 items*/
	JPanel player1 = new Player1();
	JButton candycaneP1 = new JButton(candy1_p1);
	JButton chocnutP1 = new JButton(candy2_p1);
	JButton donutP1 = new JButton(candy3_p1);
	JButton gingerbreadmanP1 = new JButton(candy4_p1);
	JButton gummybearP1 = new JButton(candy5_p1);
	JButton jellybeanP1 = new JButton(candy6_p1);
	
	/*player 2 items*/
	JPanel player2 = new Player2();
	JButton candycaneP2 = new JButton("candycaneP2");
	JButton chocnutP2 = new JButton("chocnutP2");
	JButton donutP2 = new JButton("donutP2");
	JButton gingerbreadmanP2 = new JButton("chocnutP2");
	JButton gummybearP2 = new JButton("cupcakeP2");
	JButton jellybeanP2 = new JButton("cupcakeP2");
	
	
	Container c;
	
	public MyClientWindow(){
		getImages();
		this.setSize(1105,700);
		this.setResizable(false);
		this.setLocation(20,20);
		c = this.getContentPane();
		
		/*PLAYER 1*/
		player1.setBounds(50, 100, 500, 400);
		candycaneP1.setBounds(250, 550, 100, 100);
		chocnutP1.setBounds(350, 550, 100, 100);
		donutP1.setBounds(450, 550, 100, 100);
		gingerbreadmanP1.setBounds(550, 550, 100, 100);
		gummybearP1.setBounds(650, 550, 100, 100);
		jellybeanP1.setBounds(750, 550, 100, 100);

  
		/*PLAYER 2*/
		player2.setBounds(550, 100, 500, 400);
		
		c.add(player1);
		c.add(candycaneP1);
		c.add(chocnutP1);
		c.add(donutP1);
		c.add(gingerbreadmanP1);
		c.add(gummybearP1);
		c.add(jellybeanP1);
		
		c.add(player2);
		c.add(bg);
	}

	private final void getImages() {        
		 URL url;
	        try {
	            url = getClass().getResource("images/bg.jpg");
	            if(url == null) throw new IOException("Couldn't load bg.jpg");
	            background = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/board_p1.jpg");
	            if(url == null) throw new IOException("Couldn't load board_p1.jpg");
	            boardP1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/board_p2.jpg");
	            if(url == null) throw new IOException("Couldn't load board_p2.jpg");
	            boardP2 = new ImageIcon(url).getImage();
	            
	           // url = getClass().getResource("images/candycane_p1.png");
	           // if(url == null) throw new IOException("Couldn't load candycane_p1.png");
	            //candy1_p1 = new ImageIcon(url).getImage();
	            
	        } catch(IOException e) {
	            System.err.println(e);
	        }
    }
	
	private class Background extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);	
			g.drawImage(background, 0, 0, null);
		}	
	}	
	
	private class Player1 extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);	
			g.drawImage(boardP1, 0, 0, null);
		}	
	}
	
	private class Player2 extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);	
			g.drawImage(boardP2, 0, 0, null);
		}	
	}	

}
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.awt.event.*;
import javax.swing.*;

public class SprinklePanel extends JPanel implements ActionListener{
	/*players*/
	private static final int PLAYER1 = 0;
	private static final int PLAYER2 = 1;
	
	private Image sprinkle_p1, sprinkle_p2;
	private Image bg, background;
	int x, y, endX, player;
	Timer t = new Timer(7, this);
	
	public SprinklePanel(int startX, int startY, int endX, int player){
		this.x = startX;
		this.y = startY;
		this.endX = endX;
		this.player = player;
		this.setOpaque(false);
		//this.setSize(90, 90);
		getImages();
	}
	
	public SprinklePanel(){
		getImages();
	}
	
	private final void getImages() { 
		 URL url;
	        try {
	            url = getClass().getResource("images/sprinkle_p1.png");
	            if(url == null) throw new IOException("Couldn't load sprinkle_p1.png");
	            sprinkle_p1 = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/sprinkle_p2.png");
	            if(url == null) throw new IOException("Couldn't load sprinkle_p2.png");
	            sprinkle_p2 = new ImageIcon(url).getImage();
	            
	          //  url = getClass().getResource("images/transparent_bg.png");
	          //  if(url == null) throw new IOException("Couldn't load transparent_bg.png");
	          //  bg = new ImageIcon(url).getImage();
	            
	            url = getClass().getResource("images/bg.png");
	            if(url == null) throw new IOException("Couldn't load bg.png");
	            background = new ImageIcon(url).getImage();
	            
	        } catch(IOException e) {
	            System.err.println(e);
	        }
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
	//	g.drawImage(bg, 0, 0, null);
		g.drawImage(background, 0, 0, null);
	//	g.setColor(getBackground());
		
		if(player == PLAYER1)
			g.drawImage(sprinkle_p1, x, y, null);
		else if(player == PLAYER2)
			g.drawImage(sprinkle_p2, x, y, null);
		
		t.start(); 

	}
	
	public void actionPerformed(ActionEvent e){
		x += 2;
		if(x < endX)
			repaint();
		else
			this.setVisible(false);
		
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setEndX(int endX){
		this.endX = endX;
	}
	
	public void setPlayer(int player){
		this.player = player;
	}
	
	public void setValues(int x, int y, int endX){
		setX(x);
		setY(y);
		setEndX(endX);
	}
	public void refresh(){
		this.setVisible(true);
	}
}


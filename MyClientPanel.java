import java.awt.*;
import javax.swing.*;

import java.net.URL;

import java.io.*;

public class MyClientPanel extends JPanel{
	Image bgImage;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(bgImage, 0, 0, null);
	}
	
	public void getImages(){
		 URL url;
	        
	        try {
	            url = getClass().getResource("images/bg.jpg");
	            if(url == null) throw new IOException("Couldn't load bg.jpg");
	            bgImage = new ImageIcon(url).getImage();
	        } catch(IOException e) {
	            System.err.println(e);
	        }
	}
}

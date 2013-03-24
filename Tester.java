import java.awt.Color;
import javax.swing.*;


public class Tester extends Thread{
	public static void main(String args[]){
		//MyClientWindow t = new MyClientWindow(1);
		//t.setVisible(true);
		int x, y, endX;
		JFrame test = new JFrame();
		test.setSize(1000, 700);
		test.setTitle("Errr");
		x = 200;
		y = 150;
		endX = 800;
		SprinklePanel s = new SprinklePanel(x, y, endX, 1);
	//	s.repaint();
	//	test.setBackground(Color.YELLOW);
	//	test.setForeground(Color.cyan);
		test.add(s);
		test.setVisible(true);
		try{
			sleep(2000);
		} catch(Exception e){
			
		}
		s.setX(x);
		s.setY(y+100);
		s.setEndX(endX);
		s.player = 0;
		s.repaint();
		
		
	}
	
}

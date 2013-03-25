import javax.swing.*;
import java.awt.*;

public class WinnerWindow extends JFrame{
  Container c;
	JPanel p;
	public WinnerWindow(){
		c = this.getContentPane();
		this.setSize(1100,750);
		this.setLocation(20,20);
		this.setTitle("END OF GAME");
		this.setResizable(false);
		p = new JPanel(){
            public void paintComponent(Graphics g){
				Image winner = new ImageIcon("images/winner.png").getImage();
				g.drawImage(winner, 0 , 0, null);
            }
		};
		c.add(p);
	}
}

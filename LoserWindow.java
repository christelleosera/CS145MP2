import javax.swing.*;
import java.awt.*;

public class LoserWindow extends JFrame{
  Container c;
	JPanel p;
	public LoserWindow(){
		c = this.getContentPane();
		this.setSize(1100,750);
		this.setLocation(20,20);
		this.setTitle("END OF GAME");
		this.setResizable(false);
		p = new JPanel(){
            public void paintComponent(Graphics g){
				Image loser = new ImageIcon("images/loser.png").getImage();
				g.drawImage(loser, 0 , 0, null);
            }
		};
		c.add(p);
	}
}

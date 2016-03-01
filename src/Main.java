import java.awt.*;
import javax.swing.*;

public class Main
{
	public static void main(String[] args)
	{
		int width = 500;
		int height = 500;
		
		JFrame frame = new JFrame("Kill the Dragon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        

        GamePanel panel = new GamePanel();
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(width, height);
        frame.setVisible(true);
	}
}

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Fireball implements ActionListener
{
	BufferedImage fireball;
	
	int fireballX = 250; // fireball initial position
	int fireballY = 35;
	
	public Fireball()
	{
		Timer timer = new Timer(100, this);
		timer.start();
		
		try
		{
			fireball = ImageIO.read(new File("fireball.png"));
		}
		catch (IOException io)
		{
			System.out.println("File not found.");
		}
	}
	
	public int getHeight()
	{
		return fireball.getHeight();
	}
	
	public int getWidth()
	{
		return fireball.getWidth();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		fireballY = fireballY + 5; // constantly move fireball down 5 positions
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(fireball, fireballX, fireballY, null);
	}
}








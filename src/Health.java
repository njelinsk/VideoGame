import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Health
{
	BufferedImage health1;
	BufferedImage health2;
	BufferedImage health3;
	BufferedImage health4;
	BufferedImage health5;
	BufferedImage health6;
	
	int health = 1250;
	
	public Health()
	{
		try
		{
			health1 = ImageIO.read(new File("health1.png"));
			health2 = ImageIO.read(new File("health2.png"));
			health3 = ImageIO.read(new File("health3.png"));
			health4 = ImageIO.read(new File("health4.png"));
			health5 = ImageIO.read(new File("health5.png"));
			health6 = ImageIO.read(new File("health6.png"));
		}
		
		catch (IOException io)
		{
			System.out.println("File not found.");
		}
	}
	
	public void paint(Graphics g) // 
	{
		if (health == 1250)
		{
			g.drawImage(health1, 410, 0, null);
		}
		else if (health < 1250 && health >= 1000)
		{
			g.drawImage(health2, 410, 0, null);
		}
		else if (health < 1000 && health >= 750)
		{
			g.drawImage(health3, 410, 0, null);
		}
		else if (health < 750 && health >= 500)
		{
			g.drawImage(health4, 410, 0, null);
		}
		else if (health < 500 && health >= 250)
		{
			g.drawImage(health5, 410, 0, null);
		}
		else 
		{
			g.drawImage(health6, 410, 0, null);
		}
	}
}








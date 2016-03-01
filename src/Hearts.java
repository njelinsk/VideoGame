import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hearts
{
	private BufferedImage heart1;
	private BufferedImage heart2;
	private BufferedImage heart3;
	private BufferedImage blank;
	
	int hearts = 300;
	
	public Hearts()
	{
		try
		{
			heart1 = ImageIO.read(new File("heart1.png"));
			heart2 = ImageIO.read(new File("heart2.png"));
			heart3 = ImageIO.read(new File("heart3.png"));
			blank = ImageIO.read(new File("blank.png"));
		}
		catch (IOException io)
		{
			System.out.println("File not found.");
		}
	}
	
	public void paint(Graphics g) // paint healthbar depending on player status
	{
		if (hearts == 300)
		{
			g.drawImage(heart3, 10, 0, null);
		}
		else if (hearts < 300 && hearts >= 200)
		{
			g.drawImage(heart2, 10, 0, null);
		}
		else if (hearts < 200 && hearts >= 100) 
		{
			g.drawImage(heart1, 10, 0, null);
		}
		else
		{
			g.drawImage(blank, 10, 0, null);
		}
	}
}

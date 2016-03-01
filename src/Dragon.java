import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Dragon implements ActionListener
{
	int dragonX = 250;
	int dragonY = 35;
	int temp = dragonX;

	private BufferedImage dragon;
	Random moveDragon;
	
	Fireball projectile;
	
	public Dragon()
	{
		moveDragon = new Random();
		projectile = new Fireball();
		
		Timer timer = new Timer(1000, this);
		timer.start();
		
		try
		{
			dragon = ImageIO.read(new File("dragon.png"));
		}
		catch (IOException io)
		{
			System.out.println("File not found.");
		}
	}
	
	public void shootFireball()
	{
		if (projectile.fireballY > 500) // shoot new fireball when the previous fireball goes offscreen
		{
			projectile.fireballY = 35;
			temp = dragonX + 30;
		}
	}
	
	public void returnFireball()
	{
		temp = dragonX + 30;
		projectile.fireballY = 35;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		shootFireball();
		dragonX = dragonX + (moveDragon.nextInt(40) - 20); // move dragon around randomly
	}
	
	public int getHeight()
	{
		return dragon.getHeight();
	}
	
	public int getWidth()
	{
		return dragon.getWidth();
	}

	public void paint(Graphics g)
	{
		g.drawImage(projectile.fireball, temp, projectile.fireballY, null); // paint dragon's fireball
		g.drawImage(dragon, dragonX, dragonY, null);
	}
}

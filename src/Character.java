import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character
{
	int charTop = 300;
	int charBottom;
	int charLeft = 250;
	int charRight;
	
	boolean attacking = false;
	boolean fireballXHit = false;
	boolean fireballYHit = false;
	
	Dragon dragon;
	Health health;
	Hearts hearts;
	Fireball fireball;
	
	BufferedImage knight;
	BufferedImage attack;
	
	public Character()
	{
		try
		{
			hearts = new Hearts();
			health = new Health();
			dragon = new Dragon();
			fireball = new Fireball();
			knight = ImageIO.read(new File("char.png"));
			attack = ImageIO.read(new File("sword.png"));
		}
		catch (IOException io)
		{
			System.out.println("File not found.");
		}
	}
	
	public void hit()
	{
		if ((dragon.projectile.fireballX >= charLeft && dragon.projectile.fireballX <= charLeft + knight.getWidth())
				&& (dragon.projectile.fireballY >= charTop - knight.getHeight() && dragon.projectile.fireballY <= charTop))
		{
			hearts.hearts = hearts.hearts - 1;
		}
		if (charLeft + knight.getWidth() >= dragon.dragonX && charLeft <= dragon.dragonX + dragon.getWidth()
				&& (charTop >= dragon.dragonY && charTop <= dragon.dragonY + (dragon.getHeight() + 10)))
		{
			if (attacking == true)
			{
				health.health = health.health - 18;
			}
		}

	}

	public void pressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE) 
        {
            attacking = true;
        }
		else if (e.getKeyCode() == KeyEvent.VK_UP) 
        {
            charTop = charTop - 10;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) 
        {
            charTop = charTop + 10;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) 
        {
            charLeft = charLeft - 10;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
        {
            charLeft = charLeft + 10;
        }
	}
	
	public void released(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			attacking = false;
		}
	}
	
	public void paint(Graphics g)
	{
		if (attacking == false)
		{
			g.drawImage(knight, charLeft, charTop, null);
		}
		else
		{
			g.drawImage(attack, charLeft, charTop, null);
		}
	}
}

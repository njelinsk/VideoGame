import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{		
	Fireball fireballs = new Fireball();
	Hearts 	hearts = new Hearts();
	Dragon dragon = new Dragon();
	Character character = new Character();
	
	public GamePanel()
	{
		setBackground(Color.cyan);
		
		addKeyListener(this);
		setFocusable(true);
		
		Timer timer = new Timer(5, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		character.hit();
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		character.hearts.paint(g);
		character.health.paint(g);
		dragon.paint(g);
		character.paint(g);
		if (character.health.health < 250)
		{
			g.drawString("YOU WIN!", 200, 200);
		}
		else if (character.hearts.hearts < 100)
		{
			g.drawString("YOU LOSE!", 200, 200);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		character.pressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		character.released(e);
	}
}

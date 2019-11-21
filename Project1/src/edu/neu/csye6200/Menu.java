package edu.neu.csye6200;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import edu.neu.csye6200.Game.STATE;

public class Menu extends MouseAdapter{
	private Game game;
	private Handler handler;
	private Random r  = new Random();
	private HUD hud;
	
	public Menu(Game game, Handler handler,HUD hud)
	{
	 	this.game = game;
	 	this.hud = hud;
	 	this.handler = handler;
	 	
	}
	
	public void mousePressed(MouseEvent e)
	{
		int mx =e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my,200, 150, 250, 70) )
		{
			PlayerFactory pf = PlayerFactory.getInstance();
			BasicEnemyFactory bef = BasicEnemyFactory.getInstance();
			game.gameState = STATE.Game;
			handler.object.clear();
			handler.addObject(pf.getObject(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
			handler.addObject(bef.getObject(r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32),ID.BasicEnemy,handler));
			hud.setScore(0);
			hud.setEnemies(1);
		}
		

		if(mouseOver(mx, my,200, 250, 250, 70) && game.gameState == STATE.Menu)
		{
			game.gameState = STATE.Connect;
			for (int i=0; i<25;i++)
				handler.addObject(new MenuBackground (r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32),ID.MenuParticle,handler));
		}
		
		
		if(game.gameState == STATE.End && mouseOver(mx, my,200, 250, 250, 70))
		{
			PlayerFactory pf1 = PlayerFactory.getInstance();
			BasicEnemyFactory bef1 = BasicEnemyFactory.getInstance();
			game.gameState = STATE.Game;
			handler.object.clear();
			handler.addObject(pf1.getObject(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
			handler.addObject(bef1.getObject(r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32),ID.BasicEnemy,handler));
			hud.setScore(0);
			hud.setEnemies(1);
			
			
		}
		
		//MENU EXIT
		if(mouseOver(mx, my,200, 350, 250, 70) && game.gameState == STATE.Menu)
		{
			System.exit(1);
		}
		
		//CONNEcT BACK
		if(mouseOver(mx, my,200, 350, 250, 70) && (game.gameState == STATE.Connect|| game.gameState == STATE.End))
		{
			game.gameState = STATE.Menu;
		}

		
	}
	
	
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	private boolean mouseOver(int mx,int my,int x, int y, int width, int height)
	{
		if(mx>x && mx<x+width)
		{
			if(my>y && my<y+height)
			{
				return true;
			}
			else return false;
		}
		else
			return false;
		
	}
	
	
	public void tick() {}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu)
		{
		g.setColor(Color.white);
		g.setFont(new Font("default", Font.BOLD, 42));
		g.drawString("Game Overload",160,50);
		g.drawString("Menu",280,110);
		
		g.setFont(new Font("default", Font.BOLD, 35));
		g.setColor(Color.cyan);
		g.drawRect(200, 150, 250, 70);
		g.drawString("Play",290,200);
		
		g.setColor(Color.cyan);
		g.drawRect(200, 250, 250, 70);
		g.drawString("Connect Mod",210,300);
		
		g.setColor(Color.cyan);
		g.drawRect(200, 350, 250, 70);
		g.drawString("Exit",290,400);
		}
		else if(game.gameState == STATE.Connect)
		{
			g.setFont(new Font("default", Font.BOLD, 35));
			g.setColor(Color.cyan);
			g.drawRect(200, 350, 250, 70);
			g.drawString("Back",290,400);
			
		}
		else if(game.gameState == STATE.End)
		{
			g.setColor(Color.white);
			g.setFont(new Font("default", Font.BOLD, 42));
			g.drawString("Game Over",160,50);
			g.drawString("Your Score: "+hud.getScore(),110,110);
			
			g.setFont(new Font("default", Font.BOLD, 35));
			g.setColor(Color.cyan);
			g.drawRect(200, 250, 250, 70);
			g.drawString("Play Again",222,300);
			
			
			g.setFont(new Font("default", Font.BOLD, 35));
			g.setColor(Color.cyan);
			g.drawRect(200, 350, 250, 70);
			g.drawString("Menu",290,400);
			
		}
	}

}
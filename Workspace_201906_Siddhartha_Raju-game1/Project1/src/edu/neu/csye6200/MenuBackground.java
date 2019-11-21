package edu.neu.csye6200;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuBackground extends GameObject{
	
	private Handler handler;
	Random r= new Random();
	private Color col;
	int dir = 0;
	
	
	public MenuBackground(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		velx = 2;
		velY = 9;
		dir = r.nextInt(2);
		if(dir==0)
		{
			velx = 2;
			velY = 9;
		}
		else 
		{
			velx = 8;
			velY = 4;
		}
		
		col = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
		
				
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velx;
		y += velY;
		
		if(y<=0 || y>=Game.HEIGHT - 32)
			{
			velY *=-1 ; 
			
			}
		if(x<=0 || x>=Game.WIDTH - 32)
			{
			velx *=-1 ; 
			
			}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		

		g.setColor(col);
		g.fillRect((int)x,(int)y, 16, 16);
	}

}

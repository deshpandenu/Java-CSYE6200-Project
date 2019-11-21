package edu.neu.csye6200;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{

	public FastEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		velx = 2;
		velY = 9;
				
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
		

		g.setColor(Color.green);
		g.fillRect((int)x,(int)y, 16, 16);
	}

}

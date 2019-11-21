package edu.neu.csye6200;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{

	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler =handler;
		
		for (GameObject gameobj : handler.object) {
			if(gameobj.id == ID.Player)
				player = gameobj; 
			
		}
				
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velx;
		y += velY;
		float diffx = x - player.getX() -8;
		float diffy = y - player.getY() -8;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX())+ (y-player.getY())*(y-player.getY()));
		velx = (int)((-1.0/distance)*diffx*2);
		velY = (int)((-1.0/distance)*diffy*2);
				
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
		

		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}

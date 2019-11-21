package edu.neu.csye6200;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private int score = 0;
	private Random r= new Random();
	
	public Spawn(Handler handler, HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick()
	{
		score++;
		FastEnemyObjectFactory feo = FastEnemyObjectFactory.getInstance();
		BasicEnemyFactory bef2 = BasicEnemyFactory.getInstance();
		SmartEnemyFactory sef = SmartEnemyFactory.getInstance();
		if(score>200 && score%200==0)
		{
			if(score%300==0)handler.addObject(feo.getObject(r.nextInt(Game.WIDTH-20),r.nextInt(Game.HEIGHT-20),ID.BasicEnemy,handler));
			else handler.addObject(bef2.getObject(r.nextInt(Game.WIDTH-20),r.nextInt(Game.HEIGHT-20),ID.BasicEnemy,handler));
			
		}
		
		if(score==1500)
			handler.addObject(sef.getObject(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.SmartEnemy,handler));

	}

}

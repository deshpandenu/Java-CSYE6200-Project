package edu.neu.csye6200;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
	private Thread thread;
	private boolean running  = false;
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	public static STATE gameState = STATE.Menu;
	public enum STATE
	{
		Menu,
		Connect,
		End,
		Game;
	}
	
	public Game()
	{
		PlayerFactory pf2 = PlayerFactory.getInstance();
		BasicEnemyFactory bef2 = BasicEnemyFactory.getInstance();
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler,hud);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		new Window(WIDTH, HEIGHT, "GAME DODGE", this);	
		
		
		spawner = new Spawn(handler, hud);
	
		r = new Random();
		if(gameState==STATE.Game)
		{
		handler.addObject(pf2.getObject(WIDTH/2-32,HEIGHT/2-32,ID.Player,handler));
		handler.addObject(bef2.getObject(r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32),ID.BasicEnemy,handler));
		}
		else
		{
			for (int i=0; i<25;i++)
			handler.addObject(new MenuBackground (r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32),ID.MenuParticle,handler));
			
		}
	}
	public synchronized void start()
	{
		
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try {
			thread.join();
			running =  false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.requestFocus();	
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta +=(now-lastTime)/ns;
			lastTime = now;
			while(delta >=1)
			{
				tick();
				delta--;
			}
			if(running)
			{
				render();
			}
			frames++;
			//System.out.println("Near the loop");
			if(System.currentTimeMillis() - timer>1000)
			{
				timer +=1000;
				//System.out.println("FPS: "+ frames);
				frames = 0;
			}
			
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		if(gameState==STATE.Game)
		{
		hud.tick();
		spawner.tick();
		if(HUD.HEALTH<=0)
		{
			HUD.HEALTH =100;
			handler.object.clear();
			gameState = STATE.End;
		}
		}
		else if(gameState==STATE.Menu || gameState==STATE.Connect||gameState == STATE.End)
		{
			menu.tick();
			
		}

	}
	
	private void render() 
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g =bs.getDrawGraphics();	
		g.setColor(Color.black);
		g.fillRect(0, 0,  WIDTH, HEIGHT);

		handler.render(g);
		if(gameState==STATE.Game)
		{
			hud.render(g);
		}
		else if(gameState==STATE.Menu || gameState==STATE.Connect ||gameState == STATE.End)
		{
			menu.render(g);
			
		}
		
		g.dispose();
		bs.show();
		
	}
	
	public static float clamp(float var, float min, float max)
	{
		if(var>=max)
			return var = max;
		else if(var <=min)
			return var = min;
		else
			return var;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
	}



}

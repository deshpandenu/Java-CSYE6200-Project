package edu.neu.csye6200;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.xml.transform.Templates;

import edu.neu.csye6200.Game.STATE;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
		
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		//System.out.println(key);
		for (GameObject gameobj : handler.object) {
			if(gameobj.getId() == ID.Player)
			{
				
				if(key==KeyEvent.VK_W ||key==KeyEvent.VK_UP ) 
					{
					gameobj.setVelY(-5);
					
					}
				if(key==KeyEvent.VK_S ||key==KeyEvent.VK_DOWN )
					{
					gameobj.setVelY(5);
					
					}
				if(key==KeyEvent.VK_D ||key==KeyEvent.VK_RIGHT)
					{
					gameobj.setVelx(5);
					
					}
				if(key==KeyEvent.VK_A ||key==KeyEvent.VK_LEFT )
					{
					gameobj.setVelx(-5);
					
					}
				
			}
			
		}
		
		if(key == KeyEvent.VK_ESCAPE)
		{
			System.exit(1);
			//Game.gameState = STATE.Game;
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		//System.out.println(key);
		
		for (GameObject gameobj : handler.object) {
			if(gameobj.getId() == ID.Player)
			{
				
				if(key==KeyEvent.VK_W ||key==KeyEvent.VK_UP ) gameobj.setVelY(0); //keyDown[0]=false;
				if(key==KeyEvent.VK_S ||key==KeyEvent.VK_DOWN) gameobj.setVelY(0); //keyDown[1]=false;  
				if(key==KeyEvent.VK_D ||key==KeyEvent.VK_RIGHT) gameobj.setVelx(0); //keyDown[2]=false;
				if(key==KeyEvent.VK_A ||key==KeyEvent.VK_LEFT) gameobj.setVelx(0); //keyDown[3]=false;
				
				//if(keyDown[0] && !keyDown[1]) gameobj.setVelY(0);
				//else if(!keyDown[1] && keyDown[0]) gameobj.setVelY(5);
				//if(keyDown[2] && !keyDown[3]) gameobj.setVelx(0);
				//else if(keyDown[3] && !keyDown[2]) gameobj.setVelx(-5);
				
			}
			
		}
	}

}

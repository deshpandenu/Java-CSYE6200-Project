package edu.neu.csye6200;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	public static float HEALTH =100;
	private float greenValue = 255;
	private float redValue = 0;
	private int score =0;
	private int enemies=1;
	
	
	public static float getHEALTH() {
		return HEALTH;
	}

	public static void setHEALTH(int hEALTH) {
		HEALTH = hEALTH;
	}

	public float getGreenValue() {
		return greenValue;
	}

	public void setGreenValue(int greenValue) {
		this.greenValue = greenValue;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
	
	
	public int getEnemies() {
		return enemies;
	}

	public void setEnemies(int enemies) {
		this.enemies = enemies;
	}

	public void tick() {

		HEALTH = Game.clamp(HEALTH, 0 , 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		redValue = Game.clamp(redValue, 255, 0);
		greenValue = ((int)HEALTH*2)+25;
		redValue = 255-greenValue;
		score++;
		if((score>200 && score%200==0) || score==1500)
		{
			enemies++;
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color((int)redValue,(int)greenValue,0));
		g.fillRect(15, 15, (int)HEALTH * 2, 32);
		g.setColor(Color.white);
		g.setFont(new Font("default", Font.BOLD, 16));
		g.drawString("Health -: "+(int)HEALTH,75,34);
		g.drawRect(15, 15, 200, 32);
		g.drawString("Your score  "+ score,20,64);
		g.drawString("Number of enemies  "+ enemies,20,84);
		

		
	}

	

	
	
}

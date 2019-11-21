package edu.neu.csye6200;

public class PlayerFactory extends AbstractGameObjectFactory{

	private static PlayerFactory instance;
	private PlayerFactory() {
	
		instance = null;
	}
	
	public static synchronized PlayerFactory getInstance() {
		if(instance == null) {
			instance = new PlayerFactory();
		}
		return instance;
	}
	
	
	
	
	@Override
	public GameObject getObject(int x, int y, ID id, Handler handler) {
		// TODO Auto-generated method stub
		return new Player(x,y,id,handler);
	}

}
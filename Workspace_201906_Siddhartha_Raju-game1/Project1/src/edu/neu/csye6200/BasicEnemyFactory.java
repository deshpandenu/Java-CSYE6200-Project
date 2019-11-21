package edu.neu.csye6200;

public class BasicEnemyFactory extends AbstractGameObjectFactory {

	private static BasicEnemyFactory instance;
	private BasicEnemyFactory() {
	
		instance = null;
	}
	
	public static synchronized BasicEnemyFactory getInstance() {
		if(instance == null) {
			instance = new BasicEnemyFactory();
		}
		return instance;
	}
	
	@Override
	public GameObject getObject(int x, int y, ID id, Handler handler) {
		// TODO Auto-generated method stub
		return new BasicEnemy(x,y,id,handler);
	}

	
}

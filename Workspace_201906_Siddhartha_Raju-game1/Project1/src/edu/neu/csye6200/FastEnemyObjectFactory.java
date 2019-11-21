package edu.neu.csye6200;

public class FastEnemyObjectFactory extends AbstractGameObjectFactory{

	private static FastEnemyObjectFactory instance;
	private FastEnemyObjectFactory() {
	
		instance = null;
	}
	
	public static synchronized FastEnemyObjectFactory getInstance() {
		if(instance == null) {
			instance = new FastEnemyObjectFactory();
		}
		return instance;
	}
	
	
	
	
	@Override
	public GameObject getObject(int x, int y, ID id, Handler handler) {
		// TODO Auto-generated method stub
		return new FastEnemy(x,y,id,handler);
	}

	
}

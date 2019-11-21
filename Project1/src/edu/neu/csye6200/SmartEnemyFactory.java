package edu.neu.csye6200;

public class SmartEnemyFactory extends AbstractGameObjectFactory{

	private static SmartEnemyFactory instance;
	private SmartEnemyFactory() {
	
		instance = null;
	}
	
	public static synchronized SmartEnemyFactory getInstance() {
		if(instance == null) {
			instance = new SmartEnemyFactory();
		}
		return instance;
	}
	
	
	
	@Override
	public GameObject getObject(int x, int y, ID id, Handler handler) {
		// TODO Auto-generated method stub
		return new SmartEnemy(x,y,id,handler);
	}

}

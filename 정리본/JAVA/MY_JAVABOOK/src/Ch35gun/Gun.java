package Ch35gun;

import Ch35unit.Unit;

public abstract class Gun {
	int maxbuillitCnt;
	int power;
	int curBullitCnt;
	
	public abstract void fire(Unit unit);
	public abstract void reload(int buillit); 
}

package Ch35gun;

import Ch35unit.Unit;

public class Pistol extends Gun {
	
	public Pistol(){
		this.power = 20;
		this.maxbuillitCnt=10;
		this.curBullitCnt=0;
	}
	@Override
	public void fire(Unit unit) {
		// TODO Auto-generated method stub
		if (curBullitCnt ==0) {
			System.out.println("총알 0 재장전 필요..");
			return ;
		}
		unit.UnderAttack(this.power);
		curBullitCnt--;
		
	}

	@Override
	public void reload(int buillit) {
		// TODO Auto-generated method stub
		if (this.maxbuillitCnt > this.curBullitCnt+buillit) {
			this.curBullitCnt+=buillit;
		}else {
			this.curBullitCnt = maxbuillitCnt;
		}
		
	}
	
}

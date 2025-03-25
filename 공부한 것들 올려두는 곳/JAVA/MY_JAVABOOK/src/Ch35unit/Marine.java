package Ch35unit;

import Ch35gun.*;

public class Marine extends Unit {
	// hp,amor,type
	int base_damage;
	public Gun myGun;
	boolean isDead;
	
	public Marine() {
		isDead = true;
		hp=100;
		amor=100;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setGun(Gun gun) {
		this.myGun = gun;
	}
	
	public void attack(Unit unit) {
		// base_damage , gun's power
		// unit.underAttact에 전달
		if (isDead) {
			myGun.fire(unit);
			System.out.println("[ATTACK]"+ this.type+ " 이" + unit.type+" 에게 공격합니다.");
		}
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UnderAttack(int damage) {
		// TODO Auto-generated method stub
		if (amor - damage >0) {
			this.amor -= damage;
		}else if(hp-(damage-amor) > 0) {
			hp = hp-(damage - amor);
			amor=0;
		}else {
			hp=0;
			amor=0;
			isDead = false;
			System.out.println(this.type+"전사했습니다...");
		}
	}
	
}

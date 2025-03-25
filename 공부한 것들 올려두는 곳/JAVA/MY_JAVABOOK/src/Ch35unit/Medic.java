package Ch35unit;

public class Medic extends Unit{
	private int HealingPoint;
	
	public Medic() {
		hp=100;
		amor = 100;
		HealingPont = 30;
	}
	public void Healing(Unit unit) {
		unit.hp+=HealingPoint;
		System.out.println(unit.type+" 을 회복시킵니다." + unit.type+" 체력 : "+unit.hp);
	}
	void setType(String type) {
		this.type = type;
		
	}
	@Override
	public
	void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public
	void UnderAttack(int damage) {
		// TODO Auto-generated method stub
		
	}

}

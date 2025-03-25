package Ch35Building;

import Ch35unit.Marine;
import Ch35unit.Unit;

public class MedicGenerator implements UnitGenerator {

	@Override
	public Unit gen() {
		// TODO Auto-generated method stub
		return new Marine();
	}

}

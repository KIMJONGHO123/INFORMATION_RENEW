package Ch35Building;

import Ch35unit.Marine;
import Ch35unit.Unit;

public class MarineGenerator implements UnitGenerator {


	@Override
	public Unit gen() {
		return new Marine();
	}
	
}

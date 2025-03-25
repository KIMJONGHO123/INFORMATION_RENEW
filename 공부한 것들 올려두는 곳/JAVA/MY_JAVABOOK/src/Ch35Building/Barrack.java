package Ch35Building;

import java.util.HashMap;
import java.util.Map;

import Ch35unit.Marine;
import Ch35unit.Medic;


public class Barrack extends Building{
	
// 속이 찬 다이아몬드	
//	UnitGenerator marine;
//	UnitGenerator medic;
//	public Barrack() {
//		marine = new MarineGenerator();
//		medic = new MedicGenerator();
//	}
	
	// 속이 빈 다이아몬드
	Map<String,UnitGenerator> generator = new HashMap();
	void setGenerator(UnitGenerator gen, String type) {
		generator.put(type,gen);
	}
	
	public Marine getMarine() {
		if (!isDestroyed) {
			UnitGenerator marinGen = generator.get("marine");
			
			return marinGen!=null?(Marine)marinGen.gen():null;
		}else {
			System.out.println("건물이 파괴되었거나 지어지는 중입니다.");
			return null;
		}
		
	}
	 
	public Medic getMedic() {
		if (!isDestroyed) {
			UnitGenerator medicGen = generator.get("medic");	
			return medicGen!= null ? (Medic)medicGen.gen(): null;
		}else {
			System.out.println("건물이 파괴되었거나 지어지는 중입니다.");
			return null;
		}
		
		
	}
	
	@Override
	public void buildStructure() {
		System.out.println("건물짓기 시작");
		while (amor < 100 || sheld < 100|| hp<100) {
			try {
				Thread.sleep(300);
				amor++;
				hp++;
				sheld++;
				System.out.printf("건물짓기중..hp=%d sheld=%d,aror = %d\n");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		setGenerator(new MarineGenerator(), "marine");
		setGenerator(new MarineGenerator(), "medic");
		
		// 건물 생성 처리
		System.out.println("건물 완성");
		
	}
	
}

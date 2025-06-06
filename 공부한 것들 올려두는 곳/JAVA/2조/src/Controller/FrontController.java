package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController{
	private Map<String,ReservedController> map = new HashMap<>();
	
	//싱글톤
	private static FrontController instance;
	public  FrontController() {
		System.out.println("[FC] FrontController init...");
		init();
	}
	public static FrontController getInstance() {
		if (instance == null) {
			instance = new FrontController();
		}
		return instance;
	}
	// 초기화
	private void init() {
		map.put("/reservation", new ReservationController());
	}
	
	// View로 부터 전달하는 요청 전달
	public Map<String,Object> execute(Map<String,Object>params){
		System.out.println("[FC] execute invoke...");
		String endPoint = (String)params.get("endpoint");
		ReservedController controller = map.get(endPoint);
		return controller.execute(params);
		
	}
	
}

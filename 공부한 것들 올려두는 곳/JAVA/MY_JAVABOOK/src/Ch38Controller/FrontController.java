package Ch38Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
	// 서브컨트롤러 저장 자료구조("/endPoint":서브컨트롤러객체)
	private Map<String,SubController> map = new HashMap<>(); 
	// 싱글톤
	private static FrontController instance;
	private FrontController() {
		System.out.println("[FC] FrontColtroller init...");
		init();
	};
	public static FrontController getInstance() {
		if (instance ==null) {
			instance = new FrontController();
		}
		return instance;
	}
	// 초기화
	private void init() {
		// 인증 요청 API(ENPOINT : 서브컨트롤러객체 저장)
		map.put("/user", new UserController());
		
		// 도서요청 API
		map.put("/book", new BookController());  // map = {
												//		"/user" : UserController 객체
												//		"/book" : BookController 객체
	}											//			}
	
	// View로 부터 전달하는 요청 전달
	public Map<String,Object> execute (Map<String,Object>params){
		System.out.println("[FC] execute invoke...");
		String endPoint = (String)params.get("endPoint");  // 예) String endPoint = "/book"
		SubController controller = map.get(endPoint); // 예) SubController controller = BookController 객체 반환 
		return controller.execute(params); // 예) return BookController.execute(params)
	};

}

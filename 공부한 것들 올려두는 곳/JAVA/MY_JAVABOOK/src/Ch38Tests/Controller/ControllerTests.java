package Ch38Tests.Controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;

import Ch38Controller.FrontController;

class ControllerTests {

	FrontController fc = FrontController.getInstance();
	@Test
	void test() {
		//View에서 요청정보 담기
		Map<String,Object> params = new HashMap();
		params.put("endPoint", "/user"); // endPoint
		params.put("serviceNo", 1); // ServiceNo
		// 회원가입 - 인자전달
		params.put("userid", "sss");
		params.put("username", "홍길동");
		params.put("password", "1234");
		
		// 도서등록-인자전달
//		params.put("bookCode", "11111111");
//		params.put("bookName", "JAVA의 기술");
//		params.put("publisher", "한빛미디어");
//		params.put("isbn", "1111-1111");
		
		// 요청하기
		Map<String,Object> response =fc.execute(params);
		
		// 응답확인
		for (String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
		
	}

}

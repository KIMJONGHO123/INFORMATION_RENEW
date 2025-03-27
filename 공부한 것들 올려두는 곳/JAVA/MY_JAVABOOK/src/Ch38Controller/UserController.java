package Ch38Controller;

import java.util.HashMap;
import java.util.Map;

import com.mysql.cj.jdbc.ha.BestResponseTimeBalanceStrategy;

import Ch38Domain.Dto.UserDto;
import Ch38Domain.Service.UserServiceImpl;

public class UserController implements SubController {
	
	// UserService
	private UserServiceImpl userService;
	
	Map<String,Object> response = new HashMap<>();
	
	public UserController(){
		try {
			userService = UserServiceImpl.getInstance();
		} catch (Exception e) {
			exceptionalHandler(e);
		}
		
	}
	// C(1)R(2)U(3)D(4) + 로그인(5) , 로그아웃(6)
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		// TODO Auto-generated method stub
		System.out.println("[SC] UserController execute invoke..!");
		// 00
		response = new HashMap();
		Integer serviceNo = (Integer)params.get("serviceNo");
		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 요청입니다.");
			return response;
			
		}
		
		try {
			switch (serviceNo) {
			case 1: { 		// C - 회원가입
				System.out.println("[SC] 회원가입 요청 확인");
				// 01 파라미터받기
				String userid = (params.get("userid")!=null)?(String)params.get("userid"):null;
				String username = (params.get("username")!=null)?(String)params.get("username"):null;
				String password = (params.get("username")!=null)?(String)params.get("username"):null;
				String role = "ROLE_USER";  // 기본값
				UserDto userdto = new UserDto(userid,username,password,role);
				
				
				// 02 유효성검증(Data Validation)
				boolean isOK = isValid(userdto);
				System.out.println("[No-1 회원가입] : 유효성 검사 확인 : "+ isOK);
				
				if (!isOK) {
					response.put("status", false);
					response.put("message", "유효성 체크 오류발생!");
					return response;
				}
				
				// 03 관련 서비스 실행
				boolean isSuccess=userService.userJoin(userdto);
				
				// 04 뷰로 이동(or 내용전달)
				if (isSuccess) {
					response.put("status", isSuccess);
					response.put("message", "회원가입 성공");
				}
				
				
				
				break;
			}
			case 2: {		// R - 개인 회원 정보 조회
				System.out.println("[SC] 회원정보 조회 요청 확인");
				// 01 파라미터받기
				// 02 유효성검증(Data Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용전달)
				break;
			}
			case 3:{		// U - 개인 회원 정보 수정
				System.out.println("[SC] 회원정보 수정 요청 확인");
				// 01 파라미터받기
				// 02 유효성검증(Data Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용전달)
				break;
			}
			case 4:{		// D - 개인 회원 탈퇴
				System.out.println("[SC] 회원탈퇴 요청 확인");
				// 01 파라미터받기
				// 02 유효성검증(Data Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용전달)
				break;
			}
			case 5:{		// P - 로그인
				System.out.println("[SC] 로그인 요청 확인");
				// 01 파라미터받기
				// 02 유효성검증(Data Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용전달)
				break;
			}
			case 6:{		// P - 로그아웃
				System.out.println("[SC] 잘못된 서비스번호 요청 확인");
				// 01 파라미터받기
				// 02 유효성검증(Data Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용전달)
				break;
			}
			default:
				System.out.println("[SC] 잘못된 서비스번호 요쳥 확인");
				response.put("status", false);
				response.put("message", "잘못된 서비스번호 요청입니다.");
			}
		
		} catch (Exception e) {
			exceptionalHandler(e);
		}
		return response;
	}
		
	private boolean isValid(UserDto userdto) {
		// NULL 채크 / 데이터(자료) 수준에서의 의미있는데이터가 포함되어져있는지 여부
		// username은 첫분자가 숫자인지 여부 - / or 길이가 1글자인지 등등...
		// password 복잡도체크는 Business Layer 체크 (Policy에 의한 처리)
		if (userdto.getUserid() == null || userdto.getUserid().length()<=4) {
			response.put("error", "userid의 길이는 최소 5자 이상이어야 합니다.");
			System.out.println("[INVALID] userid의 길이는 최소 5자 이상이어야 합니다.");
			return false;
		}
		if (userdto.getUserid().matches("^[0-9].*")) {
			System.out.println("[INVALID] userid의 첫문자로 숫자가 들어올 수 없습니다.");
			response.put("error", "userid의 userid의 첫문자로 숫자가 들어올 수 없습니다.");
			return false;
			
		}
		
		return true;
	}
	
	// 예외처리 함수
	public Map<String,Object> exceptionalHandler(Exception e){
		
		if (response == null) {
			response = new HashMap<>();
		}
		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("message", e);
		return response;
	}

}

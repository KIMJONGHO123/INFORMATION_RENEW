package com.example.demo.C05Naver;

import com.example.demo.C04Kakao.C02KakaoLoginController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequestMapping("/naver/search")
public class C02NaverSearchController {

    private String X_Naver_Client_Id="";
    private String X_Naver_Client_Secret="";


    @GetMapping("/book/{keyword}")
    @ResponseBody
    public void book(@PathVariable("keyword") String keyword){
        log.info("GET /naver/search/book...");


        // 요청 정보 확인
        String url = "https://openapi.naver.com/v1/search/book.json?query="+keyword;
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("X-Naver-Client-Id", X_Naver_Client_Id);
        header.add("X-Naver-Client-Secret", X_Naver_Client_Secret);

        //요청 바디 설정
//        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type","authorization_code");
//        params.add("client_id",CLIENT_ID);
//        params.add("redirect_uri",REDIRECT_URI);
//        params.add("code",code);

        HttpEntity entity = new HttpEntity(header);

        // 요청 후 응답확인

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response =
                rt.exchange(url, HttpMethod.GET,entity, String.class);

        System.out.println(response);
    }

}

package com.example.demo.C05Naver;

import com.example.demo.C04Kakao.C02KakaoLoginController;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.print.DocFlavor;

@Controller
@Slf4j
@RequestMapping("/naver")
public class C01NaverLoginController {

    private String NAVER_CLIENT_ID="";
    private String NAVER_CLIENT_SECRET="";
    private String REDIRECT_URI = "http://localhost:8090/naver/callback"; // 2. 로그인에 성공하면 네이버가 REDIRECT_URI로 다시 사용자를 돌려보냄:
    private NaverTokenResponse NaverTokenResponse;

    @GetMapping("/login")
    public String login(){
        log.info("GET /naver/login...");

        return  "redirect:https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id="+NAVER_CLIENT_ID+"&state=STATE_STRING&redirect_uri="+REDIRECT_URI;
        // 1. 네이버 로그인 페이지로 넘어감
    }

    @GetMapping("/callback") // 3. 네이버가 REDIRECT_URI로 이동시키면 이 컨트롤러가 실행된다.
    public String callback(@RequestParam("code") String code, @RequestParam("state")String state){
        log.info("GET /naver/callback..."+code+state);
        // 요청 정보 확인
        String url = "https://nid.naver.com/oauth2.0/token";
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();

        //요청 바디 설정
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id", NAVER_CLIENT_ID);
        params.add("client_secret",NAVER_CLIENT_SECRET);
        params.add("code",code);
        params.add("state",state);

        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(params,header);

        // 요청 후 응답확인

        RestTemplate rt = new RestTemplate();
        ResponseEntity<NaverTokenResponse> response =
                rt.exchange(url, HttpMethod.POST,entity, NaverTokenResponse.class);

        System.out.println(response.getBody());
        this.NaverTokenResponse = response.getBody();

        return "redirect:/naver/main";
    }

    @GetMapping("/main")
    public void main(Model model){
        log.info("GET /naver/main...");
        // 정보확인
        String url="https://openapi.naver.com/v1/nid/me";
        // 요청헤더
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer "+this.NaverTokenResponse.getAccess_token());

        // 요청바디

        // ENTITY
        HttpEntity entity = new HttpEntity<>(header);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<NaverProfileResponse> response = rt.exchange(url,HttpMethod.POST,entity, NaverProfileResponse.class);
        System.out.println(response.getBody());

        model.addAttribute("profile",response.getBody());

    }

    @GetMapping("/unlink")
    public void logout(){
        log.info("GET /naver/unlink...");

        // 요청 정보 확인
        String url = "https://nid.naver.com/oauth2.0/token";
        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();

        //요청 바디 설정
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","delete");
        params.add("client_id", NAVER_CLIENT_ID);
        params.add("client_secret",NAVER_CLIENT_SECRET);
        params.add("access_token",this.NaverTokenResponse.getAccess_token());


        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(params,header);

        // 요청 후 응답확인

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response =
                rt.exchange(url, HttpMethod.POST,entity, String.class);

        System.out.println(response.getBody());

    }

    @GetMapping("/logout")
    public String disConnect(){
        return "redirect:https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com/";
    }
    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
    // import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
    /* ObjectMapper om = new ObjectMapper();
    Root root = om.readValue(myJsonString, Root.class); */

    @Data
    private static class NaverTokenResponse{
        public String access_token;
        public String refresh_token;
        public String token_type;
        public String expires_in;
    }


    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
    // import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
    /* ObjectMapper om = new ObjectMapper();
    Root root = om.readValue(myJsonString, Root.class); */
    @Data
    private static class Response{
        public String id;
        public String profile_image;
        public String email;
        public String name;
    }

    @Data
    private static class NaverProfileResponse{
        public String resultcode;
        public String message;
        public Response response;
    }


}

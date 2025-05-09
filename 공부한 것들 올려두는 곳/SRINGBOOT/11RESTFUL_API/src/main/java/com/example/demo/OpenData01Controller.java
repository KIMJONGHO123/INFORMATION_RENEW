//package com.example.demo;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//@Slf4j
//@RequestMapping("/openData")
//public class OpenData01Controller {
//    // 공공데이터 포탈에 올라와있는 요청변수를 변수로 설정
//    String url = "https://apis.data.go.kr/6270000/service/rest/dgincident";
//    String servicekey= "AZo8RQcRwMW8PLpkUePdJZsezErn9NEWTBRKXkxPyu7tBKk2JqZH20tSvTdxa2Rjs7JLrAjXtp+foMJMLoLd0Q==";
//    String pageNo = "1";
//    String numOfRows="10";
//
//
//    @GetMapping("/unexpected")
//    public void food(){
//        //01 서버요청정보 확인(URL/ KEY/ etc Parameter)
//        url+="?servicekey="+servicekey;
//        url+="&pageNo="+pageNo;
//        url+="&numOfRows="+numOfRows;
//        //02 요청 헤더 설정
//
//        // 03 요청 바디 설정
//
//        //04 요청 작업 이후 결과 확인
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response=
//        restTemplate.exchange(url, HttpMethod.GET,null,String.class);
//        System.out.println(response);
//        // 05 기타 가공처리
//
//    }
//}

package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/openData")
public class OpenData01Controller {
    //대구광역시_돌발 교통정보 조회 서비스(신)
    String url = "https://apis.data.go.kr/6270000/service/rest/dgincident";
    String serviceKey = "xYZ80mMcU8S57mCCY/q8sRsk7o7G8NtnfnK7mVEuVxdtozrl0skuhvNf34epviHrru/jiRQ41FokE9H4lK0Hhg==";
    String pageNo = "1";
    String numOfRows = "10";

    @GetMapping("/unexpected")
    public void food(Model model){
        //01 서버요청정보 확인(URL /KEY / etc Parameter)
        url+="?serviceKey=" + serviceKey;
        url+="&pageNo=" + pageNo;
        url+="&numOfRows="+numOfRows;

        //02 요청 헤더 설정(x)

        //03 요청 바디 설정(x)

        //04 요청 작업 이후 결과 확인
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Root> response =
                restTemplate.exchange(url, HttpMethod.GET,null,Root.class);
        System.out.println(response);

        //05 기타 가공처리
//        if (response.getBody())

        // 뷰 전달
        Root root = response.getBody();
        Body body = root.getBody();
        Items items = body.getItems();
        List<Item> list = items.getItem();
        list.stream().forEach(System.out::println);

        model.addAttribute("list",list);

//      void 이면 spring MVC에서는 요청경로 /openData/unexpected와 같은 이름의 템플릿을 자동으로 찾는다.
//      내부적으로 return "openData/unexpected" 이렇게 처리된다. => resources/templates/openData/unexpected.html
    }


    // JSON to JAVA(변환기로 바꾼거다.)
    //{"body":{"items":{"item":[{"LOCATION":null,"INCIDENTTITLE":"<사고> 경부고속도로 달성군칠곡군 달성군칠곡군 기점방향  고장","LOGDATE":"20250509122404","TROUBLEGRADE":"2","STARTDATE":"20250509134310","INCIDENTSUBCODE":"8","LINKID":"1570892200","REPORTDATE":"20250509134310","ENDDATE":"20250509141310","COORDX":128.4636,"INCIDENTCODE":"1","INCIDENTID":"L91153190055","COORDY":35.9379,"TRAFFICGRADE":"02"},{"LOCATION":"대구 남구 중앙대로31길 13","INCIDENTTITLE":"<공사> 삼각지길 대명가든맨션아파트 영대병원앞교차로 1차로 주의운전 하수도/배수로 작업","LOGDATE":"20250509084203","TROUBLEGRADE":"2","STARTDATE":"20250509100300","INCIDENTSUBCODE":"4","LINKID":"1530019400","REPORTDATE":"20250509100338","ENDDATE":"20250509235900","COORDX":128.589552742768,"INCIDENTCODE":"2","INCIDENTID":"L93153181766","COORDY":35.8470437053214,"TRAFFICGRADE":"02"},{"LOCATION":"대구광역시 남구 명덕로 120","INCIDENTTITLE":"<사고> 명덕로 계명네거리 남산동2321 3차로 주의운전 고장 차량","LOGDATE":"20250509122604","TROUBLEGRADE":"2","STARTDATE":"20250509134700","INCIDENTSUBCODE":"8","LINKID":"1500003300","REPORTDATE":"20250509134745","ENDDATE":"20250509160000","COORDX":128.5833268,"INCIDENTCODE":"1","INCIDENTID":"L93153190119","COORDY":35.8561771,"TRAFFICGRADE":"02"},{"LOCATION":"대구 수성구 달구벌대로 지하 2584","INCIDENTTITLE":"<공사> 달구벌대로 만촌네거리 남부빌딩 1차로 주의운전 도로공사","LOGDATE":"20250509122904","TROUBLEGRADE":"2","STARTDATE":"20250509135000","INCIDENTSUBCODE":"255","LINKID":"1550008200","REPORTDATE":"20250509135011","ENDDATE":"20250509142000","COORDX":128.6452549,"INCIDENTCODE":"2","INCIDENTID":"L93153190238","COORDY":35.8589349,"TRAFFICGRADE":"02"}]},"numOfRows":"10","pageNo":"1","totalCount":"4"},"header":{"resultCode":"00","resultMsg":"NORMAL_SERVICE"}}

    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
    // import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
    /* ObjectMapper om = new ObjectMapper();
    Root root = om.readValue(myJsonString, Root.class); */

    @Data
    private static class Body{
        public Items items;
        public String numOfRows;
        public String pageNo;
        public String totalCount;

    }

    @Data
    private static class Header{
        public String resultCode;
        public String resultMsg;
    }


    @Data
    private static class Item{
        @JsonProperty("LOCATION")
        public String lOCATION;
        @JsonProperty("INCIDENTTITLE")
        public String iNCIDENTTITLE;
        @JsonProperty("LOGDATE")
        public String lOGDATE;
        @JsonProperty("TROUBLEGRADE")
        public String tROUBLEGRADE;
        @JsonProperty("STARTDATE")
        public String sTARTDATE;
        @JsonProperty("INCIDENTSUBCODE")
        public String iNCIDENTSUBCODE;
        @JsonProperty("LINKID")
        public String lINKID;
        @JsonProperty("REPORTDATE")
        public String rEPORTDATE;
        @JsonProperty("ENDDATE")
        public String eNDDATE;
        @JsonProperty("COORDX")
        public double cOORDX;
        @JsonProperty("INCIDENTCODE")
        public String iNCIDENTCODE;
        @JsonProperty("INCIDENTID")
        public String iNCIDENTID;
        @JsonProperty("COORDY")
        public double cOORDY;
        @JsonProperty("TRAFFICGRADE")
        public String tRAFFICGRADE;
    }

    @Data
    private static class Items{
        public ArrayList<Item> item;
    }

    @Data
    private static class Root{
        public Body body;
        public Header header;
    }


}



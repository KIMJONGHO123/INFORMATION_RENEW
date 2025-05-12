package com.example.demo.C01OpenData;

import com.example.demo.bus.BusResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

@Slf4j
@RestController
public class OpenData03Controller {

    @GetMapping("/bus/realtime")
    public void bus_realtime() throws UnsupportedEncodingException{
        String url = "https://apis.data.go.kr/6270000/dbmsapi01/getRealtime";
        String serviceKey = "AZo8RQcRwMW8PLpkUePdJZsezErn9NEWTBRKXkxPyu7tBKk2JqZH20tSvTdxa2Rjs7JLrAjXtp+foMJMLoLd0Q==";
        String bsId = "7021057700";
        String routeNo = "730";

//        url+="?serviceKey="+serviceKey;
//        url+= "&bsId="+bsId;
//        url+="&routNo="+routeNo;


        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam("serviceKey",URLEncoder.encode(serviceKey,"UTF-8"))
                .queryParam("bsId",bsId)
                .queryParam("routeNo",routeNo)
                .build(true)
                .toUri();


        // 요청 헤더(x)


        // 요청 바디(x)

        // 요청 후 응답값 받기
        RestTemplate rt = new RestTemplate();
        ResponseEntity<BusResult> response = rt.exchange(uri, HttpMethod.GET,null,BusResult.class);
        System.out.println(response.getBody());

        // 가공처리


    }


}

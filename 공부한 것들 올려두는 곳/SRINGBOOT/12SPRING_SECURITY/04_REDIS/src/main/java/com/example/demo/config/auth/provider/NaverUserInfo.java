package com.example.demo.config.auth.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NaverUserInfo implements  OAuth2UserInfo{

    private String id;
    private Map<String, Object> attributes;


    @Override
    public String getName() {
        return (String)attributes.get("name");
    }

    @Override
    public String gotEmail() {
        return (String)attributes.get("response");
    }

    @Override
    public String getProvider() {
        return "Naver";
    }

    @Override
    public String getProviderId() {
        return this.id;
    }
}

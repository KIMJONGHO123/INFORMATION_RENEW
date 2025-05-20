package com.example.demo.config.auth.scheduled;

import com.example.demo.config.auth.jwt.JwtTokenProvider;
import com.example.demo.config.auth.jwt.KeyGenerator;
import com.example.demo.domain.entity.Signature;
import com.example.demo.domain.repository.SignatureRepository;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@EnableScheduling
public class SignatureScheduling {
    @Autowired
    private SignatureRepository signatureRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Scheduled(cron = "0 * * * * *")
    public void signatureScheduled(){
        List<Signature> list = signatureRepository.findAll(); // 1개값만 저장되어있음
        byte[] keyBytes = KeyGenerator.getKeygen();
        if (list.isEmpty()){
            // 처음 SIGNATURE 발급

            jwtTokenProvider.setKey(Keys.hmacShaKeyFor(keyBytes));
            // DB에 저장
            Signature signature = new Signature();
            signature.setKeyBytes(keyBytes);
            signature.setCreateAt(LocalDate.now());
            signatureRepository.save(signature);
            System.out.println("signatureScheduling init Key init : ");
        }else{
            // 서명값 교체
            signatureRepository.deleteAll();
            Signature signature =new Signature();
            signature.setKeyBytes(keyBytes);
            signature.setCreateAt(LocalDate.now());
            signatureRepository.save(signature);
            jwtTokenProvider.setKey(Keys.hmacShaKeyFor(keyBytes));
            System.out.println("JWTTOKENPROVIDER init() 새 KEY 발급 : ");
        }
    }
}

package com.example.demo.entity;

import com.example.demo.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserTest {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private User user; // 절대 이렇게 하면 안 됨
//    엔티티는 필요할 때 직접 new 또는 builder로 생성하는 것이 원칙이다.

    @Test
    public void t1(){
        // INSERT
        User user = User.builder()
                .username("김김김")
                .password("1234567")
                .role("ROLE_USER")
                .build();

        userRepository.save(user);

        // UPDATE
        user.setPassword("7777");
        user.setRole("USER_ADMIN");

        userRepository.save(user);

        //DELETE
        userRepository.deleteById("김김김");

    }
}
package com.example.demo.domain.repository;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void t2(){
//        List<User> list = userRepository.selectByRole("ROLE_USER");
//        list.stream().forEach(System.out::println);

//        List<User> list = userRepository.selectByPassword("1234");
//        list.stream().forEach(System.out::println);

        List<User> list = userRepository.selectAllLikeUsername("감");
        list.stream().forEach(System.out::println);

    }

}
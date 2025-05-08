package com.example.demo.domain.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Lend;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class LendRepositoryTest {

    @Autowired
    private LendRepository lendRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void test1(){
//        저장되어있는 도서코드를 가지는 Book
        Book book = bookRepository.findById(1111L).get();
//        저장되어있는 유저정보를 가지는 user
        User user = userRepository.findById("감감감").get();
        Lend lend = new Lend();
        lend.setBook(book);
        lend.setUser(user);
        lendRepository.save(lend);

    }

    @Test
    public void test2(){
        Lend lend = lendRepository.findById(1L).get();
        Book book = bookRepository.findById(4444L).get();
        lend.setBook(book);

        lendRepository.save(lend);


    }

    @Test
    public void test3(){
        lendRepository.deleteById(1L);
    }

    @Test
    public void test4(){
        List<Lend> list = lendRepository.findLendsByUser("바바바");
        list.stream().forEach(System.out::println);
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void test5(){
        System.out.println("----------------------- FETCH 방식 테스트 시작");

        Optional<Lend> lendOptional = lendRepository.findById(2L);
        System.out.println("------------------------- finById(2L)");
        Lend lend = lendOptional.get();
        User user = lend.getUser(); // LAZY Option 사용시 해당 시점에서 쿼리 실행
        System.out.println(user);

        System.out.println("----------------------- FETCH 방식 테스트 종료");
    }
}
package com.example.demo.domain.repository;

import com.example.demo.entity.Book;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void t1(){

        // INSERT
        Book book = Book.builder()
                .bookCode(111111L)
                .bookName("이것이 자바다")
                .publisher("한빛미디어")
                .isbn("123453")
                .build();
        //Book book = new Book(111111L, "이것이 자바다", "한빛미디어", "123453");
        // builder 안쓰면 이렇게 써야한다. 순서 기억해야 하고 가독성 낮음
        bookRepository.save(book);


        // UPDATE
        book.setBookName("REBUX의 정석");
        book.setPublisher("아아아아");
        book.setIsbn("475213");
        bookRepository.save(book);

        // DELETE
        bookRepository.deleteById(111111L);

    }

    @Test
    @Transactional
    @Rollback(false)
    public void t2(){
//        Optional<Book> bookOptional = bookRepository.findById(1111L);
//        if (bookOptional.isPresent()){
//            System.out.println(bookOptional.get());
//        }

//        List<Book> list = bookRepository.findByBookName("아아아아");
//        list.stream().forEach(System.out::println);
//        List<Book> list = bookRepository.findByPublisher("김자히");
//        list.stream().forEach(System.out::println);

//        Book book = bookRepository.findByBookNameAndIsbn("트트트트","1478");
//        System.out.println(book);

//        List<Book> list = bookRepository.findByBookNameContains("아");
//        list.stream().forEach(System.out::println);

//        int number = bookRepository.countByBookName("아아아아");
//        System.out.println(number);
//        int number = bookRepository.countByBookNameContains("기");
//        System.out.println(number);

        bookRepository.deleteByBookName("기기기기");


    }

}
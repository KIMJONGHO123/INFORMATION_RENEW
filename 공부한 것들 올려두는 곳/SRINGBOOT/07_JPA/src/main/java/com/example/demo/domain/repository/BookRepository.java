package com.example.demo.domain.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByBookName(String bookName);
//    findbybookName 이라고 쓰면 런타일 오류 난다.
//    필드 이름 bookName을 카멜케이스 기준으로 변환한 것 -> BookName
    List<Book> findByPublisher(String publisher);
    List<Book> findByIsbn(String isbn);

    Book findByBookNameAndIsbn(String bookName, String isbn);

    List<Book> findByBookNameContains(String keyword);

    // 레코드 수 조회
    int countByBookName(String bookName);
    int countByBookNameContains(String bookName);

    // 삭제
    void deleteByBookName(String bookName);
}

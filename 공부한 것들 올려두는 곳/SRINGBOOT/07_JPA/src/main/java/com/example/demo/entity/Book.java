package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // table 생성하는 곳에 붙이면 된다.
@Table(name="book") // 실제 DB 테이블명
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @Column(name="bookcode") // book_code로 안되고 bookcode로 column이 저장된다.
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long bookCode;

    @Column(name="bookname")
    private String bookName;

    private String publisher;

    private String isbn;


}

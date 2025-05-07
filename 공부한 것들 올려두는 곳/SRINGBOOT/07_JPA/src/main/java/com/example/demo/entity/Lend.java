package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="lend") // 실제 DB 테이블명
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;


    @ManyToOne
    @JoinColumn(name="bookcode", foreignKey = @ForeignKey(name="FK_LEND_BOOK",
            foreignKeyDefinition = "foreign KEY(bookcode) references book(bookcode) on delete cascade on update cascade"))
    private Book book;

    @ManyToOne
    @JoinColumn(name="username", foreignKey = @ForeignKey(name="FK_LEND_USER",
            foreignKeyDefinition = "foreign KEY(username) references user(username) on delete cascade on update cascade"))
    private User user;




}

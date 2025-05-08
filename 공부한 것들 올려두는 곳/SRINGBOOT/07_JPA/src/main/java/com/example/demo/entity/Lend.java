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


    //@ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bookcode", foreignKey = @ForeignKey(name="FK_LEND_BOOK",
            foreignKeyDefinition = "foreign KEY(bookcode) references book(bookcode) on delete cascade on update cascade"))
    private Book book;

    //@ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="username", foreignKey = @ForeignKey(name="FK_LEND_USER",
            foreignKeyDefinition = "foreign KEY(username) references user(username) on delete cascade on update cascade"))
    private User user;

    // private User user;은 private String name; 이런거랑 같은거다.

//    public User getUser() {
//        return this.user;
//    }

}

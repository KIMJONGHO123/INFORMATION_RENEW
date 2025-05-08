package com.example.demo.domain.repository;

import com.example.demo.entity.Lend;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendRepository extends JpaRepository<Lend,Long> {
    //JPQL
//  lend 엔터티 중에서 username을 기준으로 User.username="바바바"인 User와 연결된 Lend만 가져오고 연결된 User정보도 한번에 join fetch 로 가져와서 List로 반환
    @Query("select l from Lend as l join fetch l.user where l.user.username = :username")
    List<Lend> findLendsByUser(@Param("username") String username);



}

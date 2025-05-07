package com.example.demo.domain.repository;

import com.example.demo.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("select u from User as u where u.role=?1")
    List<User> selectByRole(String role);

    @Query("select u from User as u where u.password=:password")
    List<User> selectByPassword(@Param("password") String pw);

    @Query("select u from User as u where u.username like concat('%',:username,'%')")
    List<User> selectAllLikeUsername(@Param("username") String username);

}

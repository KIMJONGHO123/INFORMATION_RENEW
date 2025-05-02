package com.example.demo.domain.mapper;

import com.example.demo.domain.dto.MemoDto;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@MapperScan("com.example.demo.domain.mapper")
class MemoMapperTest {
    @Autowired
    private MemoMapper memoMapper;

    @Test
    public void t1(){
        MemoDto memoDto = new MemoDto(555,"aa","aa", LocalDateTime.now());
        memoMapper.insert(memoDto);
        System.out.println(memoDto);

    }

    @Test
    public void t2(){
        MemoDto memoDto = new MemoDto(666,"aa","aa", LocalDateTime.now());
        memoMapper.insertXml(memoDto);
        System.out.println(memoDto);

    }
}
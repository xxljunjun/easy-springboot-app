package com.example.xxlspringboot.mapper;

import com.example.xxlspringboot.pojo.Captcha;
import com.example.xxlspringboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {
    void addCaptcha(Captcha captcha);
}

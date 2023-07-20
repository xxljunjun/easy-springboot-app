package com.example.xxlspringboot.mapper;

import com.example.xxlspringboot.pojo.Captcha;
import com.example.xxlspringboot.pojo.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface LoginMapper {
    void addCaptcha(Captcha captcha);
    SysUserEntity queryByUserName(String username);
    Captcha queryByUuid(String uuid);
    void removeById(String uuid);
}

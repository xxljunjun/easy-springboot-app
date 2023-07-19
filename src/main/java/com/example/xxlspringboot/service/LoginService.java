package com.example.xxlspringboot.service;


import com.example.xxlspringboot.common.utils.DateUtils;
import com.example.xxlspringboot.mapper.LoginMapper;
import com.example.xxlspringboot.pojo.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.code.kaptcha.Producer;
import java.awt.image.BufferedImage;
import java.util.Date;

@Service
public class LoginService {
    @Autowired
    private Producer producer;

    @Autowired
    private LoginMapper loginMapper;

    public void addCaptcha(Captcha captcha){
        loginMapper.addCaptcha(captcha);
    }
    public BufferedImage getCaptcha(String uuid) {
        // 生成文字验证码
        String code = producer.createText();
        //把code码,uuid和过期时间存进数据库
        Captcha captchaEntity = new Captcha();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpire_time(DateUtils.addDateMinutes(new Date(), 5));
        System.out.println("captchaEntity>>"+captchaEntity);
        this.addCaptcha(captchaEntity);
        //返回图片
        return producer.createImage(code);
    }

}

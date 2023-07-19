package com.example.xxlspringboot.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 系统验证码
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class Captcha {
    @Id
    private String uuid;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private Date expire_time;

}
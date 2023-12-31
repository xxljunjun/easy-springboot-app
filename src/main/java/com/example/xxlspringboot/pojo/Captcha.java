package com.example.xxlspringboot.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统验证码
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class Captcha  implements Serializable {
    private static final long serialVersionUID = 1L;
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
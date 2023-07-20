package com.example.xxlspringboot.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户Token
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class SysUserTokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //用户ID
    @Id
    private Long user_id;
    //token
    private String token;
    //过期时间
    private Date expire_time;
    //更新时间
    private Date update_time;

}

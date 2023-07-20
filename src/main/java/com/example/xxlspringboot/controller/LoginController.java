package com.example.xxlspringboot.controller;

import com.example.xxlspringboot.form.SysLoginForm;
import com.example.xxlspringboot.pojo.SysUserEntity;
import com.example.xxlspringboot.service.impl.LoginService;
import com.example.xxlspringboot.service.SysUserService;
import com.example.xxlspringboot.service.SysUserTokenService;
import com.example.xxlspringboot.utils.result.BusinessException;
import com.example.xxlspringboot.utils.result.ResultResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class LoginController {
    @Autowired
    LoginService loinService;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysUserTokenService sysUserTokenService;
    /**
     * 验证码
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid)throws IOException {
        if(StringUtils.isBlank(uuid)){
            throw new BusinessException(500,"uuid不能为空");
        }
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = loinService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }
    /**
     * 登录
     */
    @PostMapping("/sys/login")
    public ResultResponse login(@RequestBody SysLoginForm form)throws IOException {
        System.out.println("form"+form);
        //验证码
        boolean captcha = loinService.validate(form.getUuid(), form.getCaptcha());
        if(!captcha){
            return ResultResponse.customException(new BusinessException(500,"验证码不正确"));
        }

        //用户信息
        SysUserEntity user = sysUserService.queryByUserName(form.getUsername());
        System.out.println("user"+user);

        //账号不存在、密码错误
        if(user == null ) {
            return ResultResponse.customException(new BusinessException(500,"账号或密码不正确"));
        }
        if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return ResultResponse.customException(new BusinessException(500,"账号或密码不正确"));
        }

        //账号锁定
        if(user.getStatus() == 0){
            return ResultResponse.customException(new BusinessException(500,"账号已被锁定,请联系管理员"));
        }

        //生成token，并保存到数据库
        ResultResponse r = sysUserTokenService.createToken(user.getUser_id());
        return r;
    }
}

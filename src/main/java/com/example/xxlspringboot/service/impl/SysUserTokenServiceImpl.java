package com.example.xxlspringboot.service.impl;

import com.example.xxlspringboot.mapper.TokenMapper;
import com.example.xxlspringboot.oauth2.TokenGenerator;
import com.example.xxlspringboot.pojo.SysUserTokenEntity;
import com.example.xxlspringboot.service.SysUserTokenService;
import com.example.xxlspringboot.utils.result.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysUserTokenServiceImpl implements SysUserTokenService {
    @Autowired
    private TokenMapper tokenMapper;
    //12小时后过期
    private final static int EXPIRE = 3600 * 12;
    @Override
    public ResultResponse createToken(long user_id) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        System.out.println("生成一个token"+token);

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        SysUserTokenEntity tokenEntity = tokenMapper.queryTokenById(user_id);
        if(tokenEntity == null){
            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUser_id(user_id);
            tokenEntity.setToken(token);
            tokenEntity.setUpdate_time(now);
            tokenEntity.setExpire_time(expireTime);

            //保存token
            tokenMapper.insertToken(tokenEntity);
        }else{
            tokenEntity.setToken(token);
            tokenEntity.setUpdate_time(now);
            tokenEntity.setExpire_time(expireTime);

            //更新token
            tokenMapper.updateTokenById(tokenEntity);
        }

        System.out.println("生产的token"+token);

        return new ResultResponse(true,200,"",token);
    }

    @Override
    public void logout(long userId) {

    }
}

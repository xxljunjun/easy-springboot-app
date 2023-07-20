package com.example.xxlspringboot.service.impl;

import com.example.xxlspringboot.mapper.LoginMapper;
import com.example.xxlspringboot.pojo.SysUserEntity;
import com.example.xxlspringboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return null;
    }


    @Override
    public SysUserEntity queryByUserName(String username){
        System.out.println("username>>>"+username);
        return loginMapper.queryByUserName(username);
    }

    @Override
    public void saveUser(SysUserEntity user) {

    }

    @Override
    public void update(SysUserEntity user) {

    }

    @Override
    public void deleteBatch(Long[] userIds) {

    }

    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        return false;
    }
}

package com.example.xxlspringboot.service.impl;


import com.example.xxlspringboot.mapper.UserMapper;
import com.example.xxlspringboot.pojo.User;
import com.example.xxlspringboot.utils.result.ResultEnum;
import com.example.xxlspringboot.utils.result.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired()
    UserMapper userMapper;
    public Object queryUserList(){
        return new ResultResponse(true,ResultEnum.SUCCESS.getCode(),"",userMapper.queryUserList());
    }
    public Object queryUserById(int id){
        return new ResultResponse(true,ResultEnum.SUCCESS.getCode(),"",userMapper.queryUserById(id));
    }
    public String addUser(User user){
        userMapper.addUser(user);
        return "新增成功";

    }
    public String editUser(User user){
        userMapper.editUser(user);
        return "编辑成功";
    }
    public String deleteUserById(int id){
        userMapper.deleteUserById(id);
        return "删除成功";
    }
}

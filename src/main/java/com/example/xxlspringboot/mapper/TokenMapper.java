package com.example.xxlspringboot.mapper;


import com.example.xxlspringboot.pojo.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TokenMapper {
    SysUserTokenEntity queryTokenById(long user_id);
    void insertToken(SysUserTokenEntity sysUserTokenEntity);
    void updateTokenById(SysUserTokenEntity sysUserTokenEntity);
}

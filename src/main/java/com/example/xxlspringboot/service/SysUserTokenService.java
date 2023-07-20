package com.example.xxlspringboot.service;

import com.example.xxlspringboot.utils.result.ResultResponse;

public interface SysUserTokenService {
    /**
     * 生成token
     * @param userId  用户ID
     */
    ResultResponse createToken(long user_id);

    /**
     * 退出，修改token值
     * @param userId  用户ID
     */
    void logout(long userId);
}

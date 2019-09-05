package com.digitalx.service;

import com.digitalx.domain.UserAuthInfo;
import com.digitalx.domain.UserEntity;

/**
 * @author pengjunlee
 * @create 2019-09-03 17:18
 */
public interface UserService {

    // 根据主键查询用户
    UserEntity getUserById(Long id);

    // 根据用户名查询用户
    UserEntity getUserByName(String name);

    UserAuthInfo getUserAuthByName(String name);
}

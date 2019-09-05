package com.digitalx.service.impl;

import com.digitalx.domain.MenuEntity;
import com.digitalx.domain.UserAuthInfo;
import com.digitalx.domain.UserEntity;
import com.digitalx.service.UserService;
import com.digitalx.service.mapper.MenuMapper;
import com.digitalx.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author pengjunlee
 * @create 2019-09-03 17:19
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserEntity getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public UserEntity getUserByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public UserAuthInfo getUserAuthByName(String name) {
        UserAuthInfo userAuth =userMapper.getUserAuthByName(name);
        List<MenuEntity> menus = menuMapper.listMenus();
        userAuth.setMenus(menus);
        return userAuth;
    }

}

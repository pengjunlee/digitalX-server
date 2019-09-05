package com.digitalx.service.impl;

import com.digitalx.domain.MenuEntity;
import com.digitalx.domain.UserAuthInfo;
import com.digitalx.domain.UserEntity;
import com.digitalx.service.MenuService;
import com.digitalx.service.UserService;
import com.digitalx.service.mapper.MenuMapper;
import com.digitalx.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pengjunlee
 * @create 2019-09-03 17:19
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<MenuEntity> listMenus() {
        return menuMapper.listMenus();
    }
}

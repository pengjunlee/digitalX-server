package com.digitalx.service;

import com.digitalx.domain.MenuEntity;
import com.digitalx.domain.UserAuthInfo;
import com.digitalx.domain.UserEntity;

import java.util.List;

/**
 * @author pengjunlee
 * @create 2019-09-03 17:18
 */
public interface MenuService {

    List<MenuEntity> listMenus();
}

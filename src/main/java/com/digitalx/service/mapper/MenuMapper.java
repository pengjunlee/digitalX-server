package com.digitalx.service.mapper;

import com.digitalx.domain.MenuEntity;
import com.digitalx.domain.UserAuthInfo;
import com.digitalx.domain.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pengjunlee
 * @create 2019-09-03 17:13
 */
@Mapper
public interface MenuMapper {

    List<MenuEntity> listMenus();
}

package com.digitalx.service.mapper;

import com.digitalx.domain.UserAuthInfo;
import com.digitalx.domain.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author pengjunlee
 * @create 2019-09-03 17:13
 */
@Mapper
public interface UserMapper {

    UserEntity selectById(@Param("id") Long id);

    UserEntity findByName(@Param("name") String name);

    UserAuthInfo getUserAuthByName(@Param("name") String name);
}

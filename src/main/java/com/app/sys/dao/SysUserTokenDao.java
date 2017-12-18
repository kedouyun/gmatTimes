package com.app.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.app.sys.entity.SysUserToken;

@Mapper
public interface SysUserTokenDao extends BaseDao<SysUserToken> {
    
    SysUserToken queryByUserId(Long userId);

    SysUserToken queryByToken(String token);
	
}

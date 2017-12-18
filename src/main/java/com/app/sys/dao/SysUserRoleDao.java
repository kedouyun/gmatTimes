package com.app.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.sys.entity.SysUserRole;

@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRole> {
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
}

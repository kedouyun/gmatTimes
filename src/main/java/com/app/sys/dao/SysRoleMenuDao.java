package com.app.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.sys.entity.SysRoleMenu;

@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenu> {
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);
}

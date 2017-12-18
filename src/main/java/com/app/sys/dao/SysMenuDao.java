package com.app.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.sys.entity.SysMenu;

@Mapper
public interface SysMenuDao extends BaseDao<SysMenu> {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenu> queryListByParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenu> queryNotButtonList();
	
	/**
	 * 查询用户的权限列表
	 */
	List<SysMenu> queryUserList(Long userId);
}

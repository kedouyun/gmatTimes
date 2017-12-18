package com.app.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.sys.entity.SysDept;

@Mapper
public interface SysDeptDao extends BaseDao<SysDept> {

    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);

}

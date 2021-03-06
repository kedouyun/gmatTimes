package com.app.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.app.sys.entity.SysTaxonomy;

/**
 * @author heguoliang
 * @Description: TODO()
 * @date 2017-8-22 10:21
 */
@Mapper
public interface SysTaxonomyDao extends BaseDao<SysTaxonomy>{

    List<SysTaxonomy> queryListByParentId(Long parentId);

    List<SysTaxonomy> queryListByType(@Param("type") Integer type);

    SysTaxonomy queryObjectBySlug(@Param("slug") String slug);

}

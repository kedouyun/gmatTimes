package com.app.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.Constant;
import com.app.common.exception.SelfException;
import com.app.common.utils.Result;
import com.app.sys.entity.SysTaxonomy;
import com.app.sys.service.SysTaxonomyService;

/**
 * @author heguoliang
 * @Description: TODO(分类 专题 标签)
 * @date 2017-8-22 13:45
 */
@RestController
@RequestMapping("/sys/taxonomy")
public class SysTaxonomyController extends AbstractController{

    @Autowired
    private SysTaxonomyService sysTaxonomyService;

    @RequestMapping("/list")
    public List<SysTaxonomy> list(Integer type){
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        List<SysTaxonomy> list = sysTaxonomyService.queryList(map);
        return list;
    }

    @RequestMapping("/select")
    public Result select(Integer type){
        //查询列表数据
        List<SysTaxonomy> taxonomyList = sysTaxonomyService.queryListByType(type);

        String name="";
        if(type!=null){
            if(type==Constant.TaxonomyType.CATEGORY.getValue()){
                name="一级分类";
            }else if(type==Constant.TaxonomyType.FEATURE.getValue()){
                name="一级专题";
            }
        }else{
            name="一级分类/专题";
        }

        //添加顶级菜单
        SysTaxonomy root = new SysTaxonomy();
        root.setId(0L);
        root.setName(name);
        root.setParentId(-1L);
        root.setOpen(true);
        taxonomyList.add(root);

        return Result.ok().put("taxonomyList", taxonomyList);
    }

    @RequestMapping("/info/{taxonomyId}")
    public Result info(@PathVariable("taxonomyId") Long taxonomyId){
        SysTaxonomy taxonomy = sysTaxonomyService.queryObject(taxonomyId);
        return Result.ok().put("taxonomy", taxonomy);
    }

    @RequestMapping("/save")
    public Result save(@RequestBody SysTaxonomy taxonomy){
        verifyForm(taxonomy);
        sysTaxonomyService.save(taxonomy);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SysTaxonomy taxonomy){
        verifyForm(taxonomy);
        sysTaxonomyService.update(taxonomy);
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(long taxonomyId){
        //判断是否有子分类/专题/标签
        List<SysTaxonomy> list = sysTaxonomyService.queryListByParentId(taxonomyId);
        if(list.size() > 0){
            return Result.error("请先删除下级数据");
        }

        sysTaxonomyService.delete(taxonomyId);
        return Result.ok();
    }

    private void verifyForm(SysTaxonomy taxonomy){
        if(StringUtils.isBlank(taxonomy.getName())){
            throw new SelfException("名称不能为空");
        }
        if(StringUtils.isBlank(taxonomy.getSlug())){
            throw new SelfException("别名不能为空");
        }

        SysTaxonomy temp=sysTaxonomyService.queryObjectBySlug(taxonomy.getSlug());
        if(taxonomy.getId()!=null){
            if(temp!=null && temp.getId().compareTo(taxonomy.getId()) != 0){
                throw new SelfException("别名已经存在");
            }
        }else{
            if(temp!=null){
                throw new SelfException("别名已经存在");
            }
        }
    }

    @RequestMapping("/selectByType")
    public List<SysTaxonomy> selectByType(Integer type){
        //查询列表数据
        List<SysTaxonomy> list = sysTaxonomyService.queryListByType(type);
        return list;
    }

}

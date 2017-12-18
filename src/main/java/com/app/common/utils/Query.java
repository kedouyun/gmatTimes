package com.app.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.app.common.xss.SQLFilter;

/**
 * @author heguoliang
 * @Description: TODO(查询参数)
 * @date 2017-6-23 15:07
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	//当前页码
    private int page;
    //每页条数
    private int limit;

    public Query(Map<String, Object> params){
        this.putAll(params);
        //分页参数
        this.limit = params.get("pageSize") == null|| "".equals(params.get("pageSize")) ? 10 : Integer.parseInt(params.get("pageSize").toString());
		if(this.limit > 1000) {
			this.limit = 1000;
		}
		
		this.page = params.get("pageNum") == null|| "".equals(params.get("pageNum")) ? 1 : Integer.parseInt(params.get("pageNum").toString());
		
        this.put("offset", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);

        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        if(params.get("sidx")!=null&&(params.get("order")!=null)){
        	 String sidx = (String)params.get("sidx");
             
             String order = (String)params.get("order");
             if(StringUtils.isNotBlank(sidx)){
                 this.put("sidx", SQLFilter.sqlInject(sidx));
             }
             if(StringUtils.isNotBlank(order)){
                 this.put("order", SQLFilter.sqlInject(order));
             }
        }

    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}

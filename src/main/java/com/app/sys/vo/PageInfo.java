package com.app.sys.vo;

import java.util.List;
@SuppressWarnings("unchecked")
public class PageInfo {

	private int pageNum;//当前页
	private int pageSize;//每页大小
	private int pageCount;//总页数
	private int recordCount;//总记录数
	private int pageBegin;//开始页
	private int pageEnd;//结束页
	
	private List list;
	
	public PageInfo(String pn,String pageSize) {
		this.pageSize = pageSize == null|| "".equals(pageSize) ? 10 : Integer.parseInt(pageSize);
		if(this.pageSize > 1000) {
			this.pageSize = 1000;
		}
		
		this.pageNum = pn == null|| "".equals(pn) ? 1 : Integer.parseInt(pn);
	}
	public void getPage(int recordCount,int pageSize) {
		this.recordCount = recordCount;
		double d = (double)recordCount/pageSize;
		this.pageCount = (int)Math.ceil(d);
		this.pageBegin = pageNum < 10 ? 1 : pageNum - 8;
		this.pageEnd = pageCount <= 10 ? pageCount : pageNum < 9 ? 10 : (pageNum + 1) < pageCount ? pageNum + 1 : pageCount;
		//this.pageBegin = pageNum - 10 <= 0 ? 1 : pageNum - 10;
		//this.pageEnd = pageCount - pageNum <= 9 ? pageCount : pageNum + 9;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}

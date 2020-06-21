package com.sjy.pojo;

import java.util.List;

public class ResultModel {

	//新闻列表
	private List<NewsModel> newsList;
	//新闻总数
	private Long recordCount;
	// 总页数
	private Long pageCount;
	// 当前页
	private Long curPage;
	public List<NewsModel> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<NewsModel> newsList) {
		this.newsList = newsList;
	}
	public Long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}
	public Long getPageCount() {
		return pageCount;
	}
	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}
	public Long getCurPage() {
		return curPage;
	}
	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}
	
	
}

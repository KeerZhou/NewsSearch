package com.sjy.pojo;

import java.util.List;

public class ResultModel {

	//�����б�
	private List<NewsModel> newsList;
	//��������
	private Long recordCount;
	// ��ҳ��
	private Long pageCount;
	// ��ǰҳ
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

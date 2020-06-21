package com.sjy.service;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjy.dao.NewsDao;
import com.sjy.pojo.ResultModel;

@Service
public class NewsServiceImpl implements NewsService {
	private static final Integer PAGE_SIZE = 30;

	@Autowired
	private NewsDao newsDao;

	@Override
	public ResultModel query(String queryString, Integer page)
			throws Exception {
		//创建查询条件对象
		SolrQuery solrQuery = new SolrQuery();
		//设置默认搜索域
		solrQuery.set("df", "news_keywords");
		//设置查询关键字
		if(queryString != null && !"".equals(queryString)){
			solrQuery.setQuery(queryString);
		}else{
			solrQuery.setQuery("*:*");
		}
		
		//设置分页
		if(page == null){
			page = 1;
		}
		Integer start = (page - 1) * PAGE_SIZE;
		//从第几条记录开始查
		solrQuery.setStart(start);
		//一共查多少条记录
		solrQuery.setRows(PAGE_SIZE);
		//设置排序
		solrQuery.setSort("time",SolrQuery.ORDER.desc);
		
		//设置高亮显示
		solrQuery.setHighlight(true);
		//设置高亮显示的域
		solrQuery.addHighlightField("news_title,summary");
		//设置高亮前缀
		solrQuery.setHighlightSimplePre("<span style=\"color: red\">");
		//设置高亮后缀
		solrQuery.setHighlightSimplePost("</span>");
		//查询返回结果
		ResultModel resultModel = newsDao.queryNews(solrQuery);
		
		resultModel.setCurPage(Long.valueOf(page.toString()));
		
		//计算总页数
		Long pageCount = resultModel.getRecordCount() / PAGE_SIZE;
		if(resultModel.getRecordCount() % PAGE_SIZE > 0){
			pageCount ++;
		}
		resultModel.setPageCount(pageCount);
		return resultModel;
	}
	
}

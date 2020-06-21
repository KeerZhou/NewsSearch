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
		//������ѯ��������
		SolrQuery solrQuery = new SolrQuery();
		//����Ĭ��������
		solrQuery.set("df", "news_keywords");
		//���ò�ѯ�ؼ���
		if(queryString != null && !"".equals(queryString)){
			solrQuery.setQuery(queryString);
		}else{
			solrQuery.setQuery("*:*");
		}
		
		//���÷�ҳ
		if(page == null){
			page = 1;
		}
		Integer start = (page - 1) * PAGE_SIZE;
		//�ӵڼ�����¼��ʼ��
		solrQuery.setStart(start);
		//һ�����������¼
		solrQuery.setRows(PAGE_SIZE);
		//��������
		solrQuery.setSort("time",SolrQuery.ORDER.desc);
		
		//���ø�����ʾ
		solrQuery.setHighlight(true);
		//���ø�����ʾ����
		solrQuery.addHighlightField("news_title,summary");
		//���ø���ǰ׺
		solrQuery.setHighlightSimplePre("<span style=\"color: red\">");
		//���ø�����׺
		solrQuery.setHighlightSimplePost("</span>");
		//��ѯ���ؽ��
		ResultModel resultModel = newsDao.queryNews(solrQuery);
		
		resultModel.setCurPage(Long.valueOf(page.toString()));
		
		//������ҳ��
		Long pageCount = resultModel.getRecordCount() / PAGE_SIZE;
		if(resultModel.getRecordCount() % PAGE_SIZE > 0){
			pageCount ++;
		}
		resultModel.setPageCount(pageCount);
		return resultModel;
	}
	
}

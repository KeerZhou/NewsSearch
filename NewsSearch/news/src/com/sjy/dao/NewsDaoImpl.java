package com.sjy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjy.pojo.NewsModel;
import com.sjy.pojo.ResultModel;

@Repository
public class NewsDaoImpl implements NewsDao {

	@Autowired
	private SolrServer solrServer;
	
	@Override
	public ResultModel queryNews(SolrQuery solrquery) throws Exception {
		//��ѯ����ȡ��ѯ��Ӧ
		QueryResponse queryResponse = solrServer.query(solrquery);
		//����Ӧ�л�ȡ��ѯ�����
		SolrDocumentList docList = queryResponse.getResults();
		//�������ؽ������
		ResultModel resultModel = new ResultModel();
		//���������
		List<NewsModel> newsList = new ArrayList<NewsModel>();
		if(docList != null){
			//��ȡ�ܼ�¼��
			resultModel.setRecordCount(docList.getNumFound());
			for(SolrDocument doc : docList){
				NewsModel news = new NewsModel();
				news.setId(String.valueOf(doc.get("id")));
				
				//��ȡ����
				Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
				if(highlighting != null){
					List<String> list = highlighting.get(doc.get("id")).get("news_title");
					if(list != null && list.size() > 0){
						news.setTitle(list.get(0));
					}else{
						news.setTitle(String.valueOf(doc.get("news_title")));
					}
				}else{
					news.setTitle(String.valueOf(doc.get("news_title")));
				}
				if(highlighting != null){
					List<String> list1 = highlighting.get(doc.get("id")).get("summary");
					if(list1 != null && list1.size() > 0){
						news.setSummary(list1.get(0));
					}else{
						news.setSummary(String.valueOf(doc.get("summary")));
					}
				}else{
					news.setSummary(String.valueOf(doc.get("summary")));
				}
				news.setNewsurl(String.valueOf(doc.get("newsurl")));
				news.setWebsite(String.valueOf(doc.get("website")));
				news.setWebsiteurl(String.valueOf(doc.get("websiteurl")));
				news.setTime(String.valueOf(doc.get("time")));
				//news.setSummary(String.valueOf(doc.get("summary")));
				newsList.add(news);
			}
			resultModel.setNewsList(newsList);
		}
		
		return resultModel;
	}

}

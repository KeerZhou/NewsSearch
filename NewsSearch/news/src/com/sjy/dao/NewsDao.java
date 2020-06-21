package com.sjy.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.sjy.pojo.ResultModel;

public interface NewsDao {

	public ResultModel queryNews(SolrQuery solrquery) throws Exception;
}

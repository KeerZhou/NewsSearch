package com.sjy.service;

import com.sjy.pojo.ResultModel;

public interface NewsService {

	public ResultModel query(String queryString, Integer page) throws Exception;
}

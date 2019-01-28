package com.homework;

import java.util.List;

public interface INewsDAO {


	public List<News> getNewsList(String url) throws Exception;
	public News search(int index);
}

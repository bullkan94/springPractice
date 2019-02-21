
package spring.web;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import spring.mapper.HttpResponse;
import spring.mapper.News;
import spring.persistence.NewsMapper;

@Service("NewsService")
public class NewsServiceImpl implements NewsService{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private NewsMapper newsMapper;
	
	@Override
	public News getNewsFromIdx(int idx) {
		return newsMapper.getNewsFromIdx(idx);
	}
	
	@Override
	public ArrayList<News> getNewsFromDate(String pubDate) {
		return newsMapper.getNewsFromDate(pubDate);
	}
	
	@Override
	public int getNewsTotal() {
		return newsMapper.getNewsTotal();
	}
	
	@Override
	public int getNewsTodays(String pubDate) {
		return newsMapper.getNewsTodays(pubDate);
	}
	
	@Override
	public ArrayList<News> getNewsRecent() {
		return newsMapper.getNewsRecent();
	}
	
	@Override
	public HttpResponse insertNews(News news) {
		int resultCode = newsMapper.insertNews(news.title, news.link, news.pubDate);
		return new HttpResponse();
	}
	
	@Override
	public HttpResponse updateNews(News news) {
		try {
		int resultCode = newsMapper.updateNews(news.idx, news.title, news.link);
		} catch(Exception e) {
			e.printStackTrace();
			return new HttpResponse();
		}
		return new HttpResponse();
	}
	
	@Override
	public HttpResponse deleteNewsFromIdx(int idx) {
		try {
			newsMapper.deleteNewsFromIdx(idx);
		} catch(Exception e) {
			e.printStackTrace();
		//	return new HttpResponse(false, "����");
			return new HttpResponse();
		}
		//return new HttpResponse(true, "OK");
		return new HttpResponse();
		
	}
}

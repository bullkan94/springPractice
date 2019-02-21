
package spring.web;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import spring.mapper.HttpResponse;
import spring.mapper.News;

@Transactional
public interface NewsService {
	@Transactional(readOnly = true)
	public ArrayList<News> getNewsFromDate(String pubDate);
	
	@Transactional(readOnly = true)
	public News getNewsFromIdx(int idx);
	
	@Transactional(readOnly = true)
	public int getNewsTotal();
	
	@Transactional(readOnly = true)
	public int getNewsTodays(String pubDate);
	
	@Transactional(readOnly = true)
	public ArrayList<News> getNewsRecent();
	
	public HttpResponse insertNews(News news);
	public HttpResponse deleteNewsFromIdx(int idx);
	public HttpResponse updateNews(News news);

}

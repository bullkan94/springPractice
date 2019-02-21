
package spring.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import spring.mapper.News;

@Repository
public interface NewsMapper {
	public static final String tableName = "news";
	
	//C
	@Insert("insert into " + tableName + " (title, link, pubDate) " + 
	"values(#{title}, #{link}, #{pubDate})")
	int insertNews(@Param("title") String title, @Param("link") String link, 
			@Param("pubDate") String pubDate);
	
	//R
	@Select("select * from " + tableName + " where idx=#{idx}")
	News getNewsFromIdx(@Param("idx") int idx);
	
	@Select("select * from " + tableName + " where pubDate>=#{pubDate}")
	ArrayList<News> getNewsFromDate(@Param("pubDate") String pubDate);
	
	@Select("select count(*) from " + tableName)
	int getNewsTotal();
	
	@Select("select count(*) from " + tableName + " where pubDate>=#{pubDate}")
	int getNewsTodays(@Param("pubDate") String pubDate);
	
	@Select("select * from " + tableName + " order by pubDate desc limit 10")
	ArrayList<News> getNewsRecent();
	
	//U
	@Update("update " + tableName + " set title=#{title}, link=#{link} where idx=#{idx}")
	int updateNews(@Param("idx") int idx, @Param("title") String title, @Param("link") String link) throws Exception;
	
	//D
	@Delete("delete from " + tableName + " where idx=#{idx}")
	void deleteNewsFromIdx(@Param("idx") int idx) throws Exception;
	
}


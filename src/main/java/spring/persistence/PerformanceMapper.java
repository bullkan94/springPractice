
package spring.persistence;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import spring.mapper.Performance;

@Repository
public interface PerformanceMapper {
	public static final String tableName = "performance";
	
	//C
	@Insert("insert into" + tableName + "(seq, title, startDate, endDate, place, realmName, area)" + 
	"values(#{seq}, #{title}, #{startDate}, #{endDate}, #{place}, #{realmName}, #{area})")
	@SelectKey(statement = "select seq from" + tableName, keyProperty = "seq", resultType = int.class, before = true)
	int insertPerformance(@Param("seq") int seq, @Param("title") String title, @Param("startDate") int startDate, 
			@Param("endDate") int endDate, @Param("place") String place, @Param("realmName") String realmName, 
			@Param("area") String area);
	
	//R
	@Select("select * from " + tableName + " where seq=#{seq}")
	Performance getPerformanceFromSeq(@Param("seq") int seq);
	
	@Select("select * from " + tableName + " where startDate>=#{startDate}")
	ArrayList<Performance> getPerformanceFromDate(@Param("startDate") int startDate);
	
	//U
	
	
	//D
	@Delete("delete from " + tableName + " where seq=#{seq}")
	void deletePerformanceFromSeq(@Param("seq") int seq) throws Exception;
	
}


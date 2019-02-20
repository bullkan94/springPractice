
package spring.web;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import spring.mapper.HttpResponse;
import spring.mapper.Performance;
import spring.persistence.PerformanceMapper;

@Service("PerformanceService")
public class PerformanceServiceImpl implements PerformanceService{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private PerformanceMapper performanceMapper;
	
	@Override
	public Performance getPerformanceFromSeq(int seq) {
		return performanceMapper.getPerformanceFromSeq(seq);
	}
	
	@Override
	public ArrayList<Performance> getPerformanceFromDate(int startDate) {
		return performanceMapper.getPerformanceFromDate(startDate);
	}
	
	@Override
	public HttpResponse insertPerformance(Performance performance) {
		/*
		int resultCode = performanceMapper.insertPerformance(performance.getSeq(), performance.getTitle(), 
				performance.getStartDate(), performance.getEndDate(), performance.getPlace(), 
				performance.getRealmName(), performance.getArea());
				*/
		return new HttpResponse();
	}
	
	@Override
	public HttpResponse deletePerformanceFromSeq(int seq) {
		try {
			performanceMapper.deletePerformanceFromSeq(seq);
		} catch(Exception e) {
			e.printStackTrace();
		//	return new HttpResponse(false, "¿À·ù");
			return new HttpResponse();
		}
		//return new HttpResponse(true, "OK");
		return new HttpResponse();
		
	}
}

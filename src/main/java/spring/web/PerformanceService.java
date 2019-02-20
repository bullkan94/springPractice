
package spring.web;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import spring.mapper.HttpResponse;
import spring.mapper.Performance;

@Transactional
public interface PerformanceService {
	@Transactional(readOnly = true)
	public ArrayList<Performance> getPerformanceFromDate(int startDate);
	
	@Transactional(readOnly = true)
	public Performance getPerformanceFromSeq(int seq);
	
	public HttpResponse insertPerformance(Performance performance);
	public HttpResponse deletePerformanceFromSeq(int seq);

}

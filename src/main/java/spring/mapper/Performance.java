
package spring.mapper;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Performance implements Serializable {

	@Getter
	private int seq;
	private String title;
	private int startDate;
	private int endDate;
	private String place;
	private String realmName;
	private String area;
	
}

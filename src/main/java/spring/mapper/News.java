
package spring.mapper;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News implements Serializable {

	public int idx;
	public String title;
	public String link;
	public String pubDate;
	
	public int getIdx() {
		return this.idx;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getlink() {
		return this.link;
	}
	
	public String getPubDate() {
		return this.pubDate;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
}

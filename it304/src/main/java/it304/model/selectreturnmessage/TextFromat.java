package it304.model.selectreturnmessage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "textFormat")
public class TextFromat {
	@Id // 此注解标明他是一个主键列
	@GeneratedValue(strategy = GenerationType.AUTO) // 标示他是数据库自动增长
	private Long id;
	private String keyWord; // 关键字
	private String news; // 回复的消息
	private Integer available; // 是否可用
	private String explanation; // 关键字说明
	private Integer operatingType;// 操作类型(1,直接返回,二数据库操作(增删改))

	public TextFromat() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public Integer getOperatingType() {
		return operatingType;
	}

	public void setOperatingType(Integer operatingType) {
		this.operatingType = operatingType;
	}
}

package it304.model.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 此类为mysql中测试表的测试类，仅做测试和说明用。无实际意义
 * @author DK
 *
 */
@Entity
@Table(name ="test")
public class Test {
	@Id  //此注解标明他是一个主键列
	@GeneratedValue(strategy=GenerationType.AUTO)  // 标示他是数据库自动增长
	private Long id;
	//注意 如果属性与数据库名一直，可不做说明，如果不一致 请使用@Column(name ="xxx")
	//@JoinColumn与@Column相区别的是：@JoinColumn注释的是保存表与表之间关系的字段，它要标注在实体属性上。
	//而@Column标注的是表中不包含表关系的字段。
	private String name;
	private String passWord;
	//请为每一个实体类生成空的构造函数
	public Test() {
		super();
	}

	public Test(Long id, String name, String passWord) {
		super();
		this.id = id;
		this.name = name;
		this.passWord = passWord;
	}
	
	
	
}

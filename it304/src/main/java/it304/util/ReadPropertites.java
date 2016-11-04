package it304.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 * @author DK
 * 读取properties文件公共类
 *
 */
public class ReadPropertites {
	/**
	 * 加载properties文件
	 * @param fileName
	 * @return Properties
	 * @throws IOException
	 */
	public static  Properties load (String fileName) throws IOException{
		Properties props = new Properties();
		 //ReadPropertites 是类名(这个方法所在类的类名)
		InputStream in = ReadPropertites.class.getClassLoader().getResourceAsStream(fileName); 
		props.load(in);
		in.close();
		//String jmsUrl = props.getProperty("JMS.Url"); //读取,根据key
		return props;
	}
}

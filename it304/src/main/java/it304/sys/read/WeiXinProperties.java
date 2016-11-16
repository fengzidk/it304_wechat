package it304.sys.read;

import java.io.IOException;
import java.util.Properties;

import it304.util.ReadPropertites;

/**
 * 读取微信配置的服务类
 * 
 * @author DK
 *
 */
public class WeiXinProperties {
	public static String token; // 微信token
	public static String myUserName; // 自己的openID
	public static String AppID; // 公众号的appID
	public static String AppSecret; // 公众号的AppSecret
	public static String ACCESS_Token;// ACCESS_Token

	public static void read() {
		try {
			Properties load = ReadPropertites.load("weixin.properties");
			token = load.getProperty("token");
			myUserName = load.getProperty("myUserName");
			AppID = load.getProperty("AppID");
			AppSecret = load.getProperty("AppSecret");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

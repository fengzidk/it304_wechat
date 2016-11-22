package it304.sys.init;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;

import it304.sys.read.WeiXinProperties;
import it304.util.ReadWeChatXml;

/**
 * 微信导航栏初始化
 * 
 * @author fengzi_dk
 *
 */
@Component // 表示这是一个组件
public class WeChatMenuInit {

	public void init() throws IOException {
		String user_define_menu = ReadWeChatXml.read();
		System.out.println(user_define_menu);
		// 此处改为自己想要的结构体，替换即可
		String access_token = WeiXinProperties.ACCESS_Token;
		String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + access_token;
		try {
			URL url = new URL(action);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();

			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();
			OutputStream os = http.getOutputStream();
			os.write(user_define_menu.getBytes("UTF-8"));// 传入参数
			os.flush();
			os.close();

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");
			System.out.println(message);
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

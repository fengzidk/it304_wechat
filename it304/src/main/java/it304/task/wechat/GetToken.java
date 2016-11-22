package it304.task.wechat;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import it304.sys.read.WeiXinProperties;

@Component
public class GetToken {

	/**
	 * 定时获取Access_token
	 */
	// 每小时一次
	@Scheduled(cron = "0 0 0/1 * * ?")
	public void getAccess_token() { // 获得ACCESS_TOKEN

		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + WeiXinProperties.AppID + "&secret=" + WeiXinProperties.AppSecret;

		String accessToken = null;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();

			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");

			JSONObject demoJson = (JSONObject) JSON.parse(message);
			accessToken = demoJson.getString("access_token");
			WeiXinProperties.ACCESS_Token = accessToken;
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

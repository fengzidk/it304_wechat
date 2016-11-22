package it304.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadWeChatXml {

	public static String read() throws IOException {
		InputStream in = ReadPropertites.class.getClassLoader().getResourceAsStream("WeChatMuen.xml");
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String str = null;
		StringBuffer sb = new StringBuffer();
		while ((str = bufferedReader.readLine()) != null) {
			sb.append(str);
		}

		return sb.toString();
	}
}

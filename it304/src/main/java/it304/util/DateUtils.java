package it304.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat simpleDateFormat;

	/**
	 * 返回当前时间的时间戳
	 * 
	 * @return
	 */
	public static String getTimeLine() {
		simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmsss");
		return simpleDateFormat.format(new Date());
	}
}

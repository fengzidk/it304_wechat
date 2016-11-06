package it304.util.wechat;

import it304.sys.read.WeiXinProperties;
import it304.util.DateUtils;

/**
 * 封装回复微信的消息
 * 
 * @author fengzi_dk
 *
 */
public class PackageMessage {
	public static final int msg_type_text = 1;
	public static final int msg_type_img = 2;

	public static String messagePackage(int type, String msg, String toUserName) {
		StringBuilder returnMsg = new StringBuilder();
		returnMsg.append("<xml>\n<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>\n<FromUserName><![CDATA[" + WeiXinProperties.myUserName + "]]></FromUserName>\n<CreateTime>"
				+ DateUtils.getTimeLine() + "</CreateTime>");
		switch (type) {
		case msg_type_text:
			returnMsg.append("<MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + msg + "]]></Content>\n</xml>");
			break;
		case msg_type_img:
			returnMsg.append("<MsgType><![CDATA[image]]></MsgType>\n<Image>\n<MediaId><![CDATA[" + msg + "]]></MediaId>\n</Image>\n</xml>");
			break;
		}
		return returnMsg.toString();
	}
}

package it304.service.passivereply;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import it304.util.wechat.PackageMessage;

/**
 * 接收并返回微信的control
 * 
 * @author fengzi_dk
 *
 */
@Service
public class PassiveReplyWeChatControl {
	@Resource
	private IWeChatMessageContrl textFormatMessage;// 默认按名称注入 消息格式处理...
	@Resource
	private IWeChatMessageContrl eventControl;// 事件

	/**
	 * 被动回复微信消息
	 * 
	 * @param whChatMessage
	 * @return
	 */
	public String passiveReplyInformation(Map<String, String> whChatMessage) {
		String returnMessage = "";
		IWeChatMessageContrl iWeChatMessageContrl = null;
		String msgType = whChatMessage.get("MsgType");
		switch (msgType) {
		case "text":
			iWeChatMessageContrl = textFormatMessage;
			break;
		case "event":
			iWeChatMessageContrl = eventControl;
			break;
		default:
			iWeChatMessageContrl = null;
		}
		if (iWeChatMessageContrl == null) {
			returnMessage = PackageMessage.messagePackage(PackageMessage.msg_type_text, "请检查您输入的消息是否正确", whChatMessage.get("FromUserName"));
		} else {
			returnMessage = iWeChatMessageContrl.retrunMassage(whChatMessage);
		}

		return returnMessage;
	}
}

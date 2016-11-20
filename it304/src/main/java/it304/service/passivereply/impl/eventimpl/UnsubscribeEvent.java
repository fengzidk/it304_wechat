package it304.service.passivereply.impl.eventimpl;

import java.util.Map;

import org.springframework.stereotype.Component;

import it304.service.passivereply.impl.IWeChatEvent;
import it304.util.wechat.PackageMessage;

/**
 * 取消订阅事件
 * 
 * @author fengzi_dk
 *
 */
@Component
public class UnsubscribeEvent implements IWeChatEvent {
	@Override
	public String returnEventMassage(Map<String, String> whChatMessage) {
		String msg = "走好,不送,期待您的下次关注";
		return packageMsg(msg, whChatMessage.get("FromUserName"));
	}

	private String packageMsg(String msg, String toUserName) {
		return PackageMessage.messagePackage(PackageMessage.msg_type_text, msg, toUserName);
	}
}

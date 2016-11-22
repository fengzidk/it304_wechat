package it304.service.passivereply.impl.eventimpl;

import java.util.Map;

import org.springframework.stereotype.Component;

import it304.service.passivereply.impl.IWeChatEvent;
import it304.util.wechat.PackageMessage;

/**
 * 自定义菜单的点击事件
 * 
 * @author fengzi_dk
 *
 */
@Component("click")
public class ClickEvent implements IWeChatEvent {
	@Override
	public String returnEventMassage(Map<String, String> whChatMessage) {
		String msg = "sorry,暂不支持,至于为啥不支持,我母鸡呀";

		return packageMsg(msg, whChatMessage.get("FromUserName"));
	}

	private String packageMsg(String msg, String toUserName) {
		return PackageMessage.messagePackage(PackageMessage.msg_type_text, msg, toUserName);
	}
}

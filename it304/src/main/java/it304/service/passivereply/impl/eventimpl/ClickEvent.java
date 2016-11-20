package it304.service.passivereply.impl.eventimpl;

import java.util.Map;

import org.springframework.stereotype.Component;

import it304.service.passivereply.impl.IWeChatEvent;

/**
 * 自定义菜单的点击事件
 * 
 * @author fengzi_dk
 *
 */
@Component
public class ClickEvent implements IWeChatEvent {
	@Override
	public String returnEventMassage(Map<String, String> whChatMessage) {
		// 需要设计跳转链接
		return "";
	}

}

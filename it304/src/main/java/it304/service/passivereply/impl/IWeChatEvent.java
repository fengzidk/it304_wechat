package it304.service.passivereply.impl;

import java.util.Map;

public interface IWeChatEvent {
	public String returnEventMassage(Map<String, String> whChatMessage);
}

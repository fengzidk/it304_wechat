package it304.service.passivereply.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import it304.dao.passivereply.textformat.ITextFormatDao;
import it304.model.selectreturnmessage.TextFromat;
import it304.service.passivereply.WeChatMessageContrlInterface;
import it304.util.wechat.PackageMessage;

@Component // 标明是一个组件
public class TextFormatMessage implements WeChatMessageContrlInterface {
	@Resource
	private ITextFormatDao textFormatDaoImpl;

	@Override
	public String retrunMassage(Map<String, String> whChatMessage) {
		StringBuilder msg = new StringBuilder();
		String weChatMsg = whChatMessage.get("Content");
		String[] keyWord = weChatMsg.split(";");
		List<TextFromat> queryKeyWord = textFormatDaoImpl.queryKeyWord(keyWord[0]);
		if (queryKeyWord.size() > 1) {
			msg.append("您让俺糊涂了 \n\t您要操作的是哪一个???\n");
			for (TextFromat textFromat : queryKeyWord) {
				msg.append(textFromat.getKeyWord() + "\n");
			}
		} else if (queryKeyWord == null || queryKeyWord.size() == 0) {
			TextFromat fromat = textFormatDaoImpl.queryDefaultKeyWord();
			msg.append(fromat.getNews());
		} else {
			msg.append(queryKeyWord.get(0).getNews());
		}

		return packageMsg(msg.toString(), whChatMessage.get("FromUserName"));
	}

	private String packageMsg(String msg, String toUserName) {
		return PackageMessage.messagePackage(PackageMessage.msg_type_text, msg, toUserName);
	}

}

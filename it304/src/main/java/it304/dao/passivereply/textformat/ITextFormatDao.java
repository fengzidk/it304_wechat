package it304.dao.passivereply.textformat;

import java.util.List;

import it304.model.selectreturnmessage.TextFromat;

public interface ITextFormatDao {
	public List<TextFromat> queryKeyWord(String keyWord);

	/**
	 * 查询默认的关键字
	 * 
	 * @return
	 */
	TextFromat queryDefaultKeyWord();
}

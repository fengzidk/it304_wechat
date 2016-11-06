package it304.dao.passivereply.textformat.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import it304.dao.passivereply.textformat.ITextFormatDao;
import it304.model.selectreturnmessage.TextFromat;

/**
 * 查询文本消息的dao
 * 
 * @author fengzi_dk
 *
 */
@Repository
public class TextFormatDaoImpl implements ITextFormatDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<TextFromat> queryKeyWord(String keyWord) {
		return sessionFactory.getCurrentSession().createQuery("from TextFromat where keyWord like :keyWord ").setParameter("keyWord", "%" + keyWord + "%").list();
	}

	@Override
	public TextFromat queryDefaultKeyWord() {
		return (TextFromat) sessionFactory.getCurrentSession().createQuery("from TextFromat where keyWord = :keyWord").setParameter("keyWord", -1).uniqueResult();
	}

}

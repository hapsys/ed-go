package org.c3s.edgo.event.impl;

import java.sql.SQLException;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBLanguagesBean;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.FileheaderBean;
import org.c3s.utils.RegexpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fileheader extends AbstractJournalEvent<FileheaderBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Fileheader.class);
	
	{
		beanClass = FileheaderBean.class;
	}
	
	protected void processBean(FileheaderBean bean) {
		String lang = bean.getLanguage();
		if (lang != null) {
			String name = RegexpUtils.preg_replace("~^([^\\\\]+)\\\\.*$~isu", lang, "$1");
			String uniq = RegexpUtils.preg_replace("~^.*\\\\([^\\\\]+)$~isu", lang, "$1").toLowerCase();
			if ("uk".equals(uniq)) {
				uniq = "en";
			}
			try {
				DBLanguagesBean language = DbAccess.languagesAccess.getByLangUniq(uniq);
				if (language == null) {
					language = new DBLanguagesBean();
					language.setLangLabel(name).setLangUniq(uniq);
					DbAccess.languagesAccess.insert(language);
				}
				DbAccess.usersAccess.updateUserLanguage(language.getLangId(), user.getUserId());
				//throw new RuntimeException();
			} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}

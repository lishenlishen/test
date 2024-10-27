package com.d3.dao;

import org.apache.log4j.Logger;

public class NewsDaoMySqlImpl implements NewsDao {
    private Logger logger = Logger.getLogger(NewsDaoImpl.class + "");
    @Override
    public void save(News news) {
        logger.debug("保存新闻信息到数据库");
        //...数据库操作代码
    }
}

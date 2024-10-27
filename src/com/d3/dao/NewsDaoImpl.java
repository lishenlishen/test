package com.d3.dao;


import org.apache.log4j.Logger;

/**
    新闻模块的 DAO 实现类
 */
public class NewsDaoImpl implements NewsDao {
    private Logger logger = Logger.getLogger(NewsDaoImpl.class + "");
    @Override
    public void save(News news) {
        logger.debug("保存新闻信息到数据库");
        //...数据库操作代码
    }
}

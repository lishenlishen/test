package com.d3.dao;

public class NewServiceImpl implements NewService {

    // 实例化所依赖的 NewsDao 对象
    private NewsDao
     dao = new NewsDaoImpl();


    public NewsDao getDao() {
        return dao;
    }

    public void setDao(NewsDao dao) {
        this.dao = dao;
    }

    //解耦
    private NewsDao dao2 = SimpleDaoFactory.getInstance("mysql");

    @Override
    public void save(News news) {
        //调用 NewDao 的方法保存新闻信息
        dao.save(news);
    }
}

package com.d3.dao;

import com.d3.dao.Shili6_9.*;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Test {
    private static Logger logger = Logger.getLogger(IntermediaryImpl.class);
    public static void main(String[] args) throws IOException {
        initLogRecord.initLog();
//        NewsDao dao = SimpleDaoFactory.getInstance("mysql");
//        NewServiceImpl service = new NewServiceImpl();
//        service.setDao(dao);
//
//        AbstractFactory factory = new MySqlDaoFactory();//改变具体工厂可创建不同产品
//        NewsDao dao2 = factory.getInstance();
//        NewServiceImpl service2 = new NewServiceImpl();
//        service2.setDao(dao2);

//        Buyer buyer = new IntermediaryImpl(new RealBuyer());
//        String result = buyer.havealook();
//        logger.debug(result);

//        Buyer buyer = IntermediaryJdkProxyFactory.create(new RealBuyer());
//        String result = buyer.havealook();
//        logger.debug(result);

        RealBuyer buyer = IntermediaryCglibProxyFactory.create(RealBuyer.class);
        String result = buyer.havealook();
        logger.debug(result);
    }
}

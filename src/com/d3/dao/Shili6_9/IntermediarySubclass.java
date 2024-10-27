package com.d3.dao.Shili6_9;

import org.apache.log4j.Logger;

public class IntermediarySubclass extends RealBuyer {
    private Logger logger = Logger.getLogger(IntermediarySubclass.class);
    /**
        重写目标对象业务方法实现代理
     */
    @Override
    public String havealook() {
        before();
        String feedback = super.havealook();    //执行目标对象的实际业务
        after();
        return "看房记录: 买家反馈 “" + feedback + "” ";
    }
    private void after() {
        logger.debug("后期跟踪");
        logger.debug("和买家沟通意见。");
    }

    private void before() {
        logger.debug("前期准备。");
        logger.debug("查找房源。");
        logger.debug("和卖家沟通时间。");
    }
}

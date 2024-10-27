package com.d3.dao.Shili6_9;


import org.apache.log4j.Logger;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class IntermediaryMethodInterceptor implements MethodInterceptor {

    private Logger logger = Logger.getLogger(IntermediaryMethodInterceptor.class + "");

    /**
        为被代理的方法定义的代理业务规则
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        // 调用父类原始的方法
        Object feedback = methodProxy.invokeSuper(proxy,args);
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

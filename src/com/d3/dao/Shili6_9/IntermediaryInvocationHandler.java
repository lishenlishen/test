package com.d3.dao.Shili6_9;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IntermediaryInvocationHandler implements InvocationHandler {

    private Logger logger = Logger.getLogger(IntermediaryInvocationHandler.class);

    /**
        被代理的目标对象
     */
    private Object target;
    public void setTarget(Object target){
        this.target = target;
    }

    /**
        为被代理的接口方法定义的代理业务规则
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object feedback = method.invoke(target,args);   //反射执行目标对象的实际业务
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

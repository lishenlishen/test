package com.d3.dao.Shili6_9;

import java.lang.reflect.Proxy;

public class IntermediaryJdkProxyFactory {
    /**
        工厂方法
     * @param target 需要被代理的目标对象
     * @param <T>
     * @return 返回生成好的代理对象
     */
    public static <T> T create (Object target){
        // IntermediaryInvocationHandler 的成员变量 target 存在线程安全问题,
        // 故将 IntermediaryInvocationHandler 作为局部变量使用
        IntermediaryInvocationHandler handler = new IntermediaryInvocationHandler();
        handler.setTarget(target);
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
    }
}

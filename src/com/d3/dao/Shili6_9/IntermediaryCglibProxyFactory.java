package com.d3.dao.Shili6_9;

import org.springframework.cglib.proxy.Enhancer;

public class IntermediaryCglibProxyFactory {

    // IntermediaryMethodInterceptor 中没有回引发线程安全问题的成员变量
    // 故可声明为公共变量

    private static IntermediaryMethodInterceptor callback = new IntermediaryMethodInterceptor();

    /**
        工厂方法
     * @param target 需要被代理的类型,即代理类需要继承的父类型
     * @param <T>
     * @return 代理类的实例
     */
    public static <T> T create (Class<T> target){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(callback); //为重写的方法制定回调的 MethodInterceptor
        enhancer.setSuperclass(target); //指定要继承的父类型,即需要被代理的类型
        return  (T) enhancer.create();  //动态生成子类,创建子类实例并返回
    }
}

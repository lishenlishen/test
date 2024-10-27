package com.d3.dao;

/**
    创建 NewsDao 实例的工厂类
 */
public class SimpleDaoFactory {
    /**
        创建 NewsDao 实例的工厂方法
     */
    public static NewsDao getInstance(String key){
//        return new NewsDaoImpl();
        switch (key){
            case "mysql" :
                return new NewsDaoMySqlImpl();
            case "oracle":
                return new NewsDaoOracleImpl();
            case "redis":
                return new NewsDaoRedisImpl();
            default:
                throw new RuntimeException("无效的数据库类型: " + key + " ,DAO获取失败");
        }
    }
}

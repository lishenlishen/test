package com.d3.dao;

public class MySqlDaoFactory implements AbstractFactory {
    @Override
    public NewsDao getInstance() {
        return new NewsDaoMySqlImpl();
    }
}

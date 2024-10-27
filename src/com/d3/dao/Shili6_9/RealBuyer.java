package com.d3.dao.Shili6_9;

import org.apache.log4j.Logger;

public class RealBuyer implements Buyer {
    private Logger logger = Logger.getLogger(RealBuyer.class);

    @Override
    public String havealook() {
        logger.debug("实地查看一下");
        return "一些意见";
    }
}

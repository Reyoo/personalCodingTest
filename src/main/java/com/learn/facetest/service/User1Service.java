package com.learn.facetest.service;

import com.learn.facetest.model.User1;

public interface User1Service {

    public void addRequired(User1 user);



    public void addRequiresNew(User1 user);


    /**
     * 如果一个活动的事务存在，则运行在一个嵌套的事务中。 如果没有活动事务, 则按TransactionDefinition.PROPAGATION_REQUIRED 属性执行。
     * @param user
     */
    public void addNested(User1 user);
}

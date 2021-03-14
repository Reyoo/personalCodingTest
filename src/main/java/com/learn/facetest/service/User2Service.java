package com.learn.facetest.service;


import com.learn.facetest.model.User2;

public interface User2Service {
    
    public void addRequired(User2 user);

    public void addRequiredException(User2 user);

    public void addRequiresNew(User2 user);

    public void addRequiresNewException(User2 user);


    /**
     * 如果一个活动的事务存在，则运行在一个嵌套的事务中。 如果没有活动事务, 则按TransactionDefinition.PROPAGATION_REQUIRED 属性执行。
     * @param user
     */
    public void addNested(User2 user);

    public void addNestedException(User2 user);
}

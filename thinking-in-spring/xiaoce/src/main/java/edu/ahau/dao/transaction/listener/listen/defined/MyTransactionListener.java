package edu.ahau.dao.transaction.listener.listen.defined;


import org.springframework.context.ApplicationEvent;

/**
 * @author zhangxuna
 * @date 2021-12-02 16:28
 */
public class MyTransactionListener extends ApplicationEvent {
    public MyTransactionListener(Object source) {
        super(source);
        System.out.println("我自定义的，吊不吊");
    }
}

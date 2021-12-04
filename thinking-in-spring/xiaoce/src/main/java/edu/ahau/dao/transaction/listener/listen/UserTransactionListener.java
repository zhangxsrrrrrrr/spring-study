package edu.ahau.dao.transaction.listener.listen;

import edu.ahau.dao.transaction.listener.listen.defined.MyTransactionListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author zhangxuna
 * @date 2021-12-02 10:08
 */
@Component
public class UserTransactionListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onSaveUser(MyTransactionListener user) {
        System.out.println("监听到保存用户事务提交 ......");
    }
}
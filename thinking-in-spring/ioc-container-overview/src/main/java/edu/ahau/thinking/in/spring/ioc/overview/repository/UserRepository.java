package edu.ahau.thinking.in.spring.ioc.overview.repository;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author zhangxuna
 * @create 2021-10-10 18:14
 * @description TODO
 */
public class UserRepository {
    private Collection<User> users;
    private BeanFactory beanFactory;
    private ObjectFactory<ApplicationContext> objFactory;
    private ObjectFactory<BeanFactory> beanFactoryObjectFactory;

    public ObjectFactory<BeanFactory> getBeanFactoryObjectFactory() {
        return beanFactoryObjectFactory;
    }

    public void setBeanFactoryObjectFactory(ObjectFactory<BeanFactory> beanFactoryObjectFactory) {
        this.beanFactoryObjectFactory = beanFactoryObjectFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjFactory() {
        return objFactory;
    }

    public void setObjFactory(ObjectFactory<ApplicationContext> objFactory) {
        this.objFactory = objFactory;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}

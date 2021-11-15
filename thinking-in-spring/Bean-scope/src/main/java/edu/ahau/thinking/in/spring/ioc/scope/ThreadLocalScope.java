package edu.ahau.thinking.in.spring.ioc.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal 级别 Scope
 *
 * @author zhangxuna
 * @date 2021-10-24 21:14
 */
public class ThreadLocalScope implements Scope {
    public static final String SCOPE_NAME = "thread-local";

    private final NamedThreadLocal<Map<String, Object>> threadLocal = new NamedThreadLocal("thread-local-scope") {
        // 防止空指针
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };
    /* 获取 */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> context = getContext();
        Object object = context.get(name);

        if (object == null) {
            object = objectFactory.getObject();
            context.put(name, object);
        }
        return object;
    }

    private Map<String, Object> getContext() {
        return threadLocal.get();
    }

    /* 删除 */
    @Override
    public Object remove(String name) {
        Map<String, Object> context = getContext();
        return context.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        Map<String, Object> context = getContext();
        return context.get(key);
    }

    @Override
    public String getConversationId() {
        Thread thread = Thread.currentThread();

        return String.valueOf(thread.getId());
    }
}

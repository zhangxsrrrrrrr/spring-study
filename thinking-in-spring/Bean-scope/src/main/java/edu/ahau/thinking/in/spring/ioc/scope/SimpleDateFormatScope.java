package edu.ahau.thinking.in.spring.ioc.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxuna
 * @date 2021-10-24 22:24
 */
public class SimpleDateFormatScope implements Scope {
    public static final String SCOPE_NAME = "simpleDateFormatScope";

    private static final NamedThreadLocal<Map<String, Object>> simpleDateFormatObject = new NamedThreadLocal<Map<String, Object>>("SimpleDateFormatScope") {
        @Override
        protected Map<String, Object> initialValue() {
            Map<String, Object> map = new HashMap<>();
            map.put("simpleDateFormat", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") );
            return map;
        }
    };


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> context = getContext();
        Object object = context.get(name);
        if (object == null) {
            context.put("simpleDateFormat", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") );
        }
        return object;
    }

    private Map<String, Object> getContext() {
        return simpleDateFormatObject.get();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

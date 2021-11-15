package edu.ahau.thinking.in.spring.bean.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxuna
 * @date 2021-10-28 9:17
 */
@Component
public class StrategyUseService implements ApplicationContextAware {
    private final Map<FileTypeResolveEnum, IFileStrategy> iFileStrategyMap  = new HashMap<>(5);

    public void resolveFile(FileTypeResolveEnum fileTypeResolveEnum, Object objectParam) {
        IFileStrategy iFileStrategy = iFileStrategyMap.get(fileTypeResolveEnum);
        if (iFileStrategy != null) {
            iFileStrategy.resolve(objectParam);
        }
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IFileStrategy> beansOfType = applicationContext.getBeansOfType(IFileStrategy.class);
        beansOfType.values().forEach(s -> iFileStrategyMap.put(s.gainFileType(), s));
    }


}

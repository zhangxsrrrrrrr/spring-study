package edu.ahau.ioc.resource;

import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 自定义文件解析器
 *
 * @author zhangxuna
 * @date 2021-11-04 13:36
 */
public class DogProtocolResolver implements ProtocolResolver {
    public static final String DOG_PATH_PREFIX = "dog:";

    @Override
    public Resource resolve(String location, ResourceLoader resourceLoader) {
        if (!location.startsWith(DOG_PATH_PREFIX)) {
            return null;
        }
        String realpath = location.substring(DOG_PATH_PREFIX.length());
        String classpathLocation = "classpath:/" + realpath;
        return resourceLoader.getResource(classpathLocation);
    }
}

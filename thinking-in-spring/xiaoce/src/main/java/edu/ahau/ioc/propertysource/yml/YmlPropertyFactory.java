package edu.ahau.ioc.propertysource.yml;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * 解析Yaml文件，yml文件转换成properties
 * @author zhangxuna
 * @date 2021-11-04 14:22
 */
public class YmlPropertyFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();

        yamlPropertiesFactoryBean.setResources(resource.getResource());

        Properties properties = yamlPropertiesFactoryBean.getObject();

        return new PropertiesPropertySource((name != null ? name : resource.getResource().getFilename()), properties);
    }
}

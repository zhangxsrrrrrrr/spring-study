package edu.ahau.ioc.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhangxuna
 * @date 2021-11-03 16:07
 */
public class BarImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {Bar.class.getName(), BarConfiguration.class.getName()};
    }
}

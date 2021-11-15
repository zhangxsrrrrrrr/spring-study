package edu.ahau.ioc.lifecycle.userdefined.config;

import edu.ahau.ioc.lifecycle.userdefined.WaiterRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zhangxuna
 * @date 2021-11-14 22:34
 */
@Configuration
@Import(WaiterRegistrar.class)
@ComponentScan("edu.ahau.ioc.lifecycle.userdefined")
public class ComponentScanConfiguration {
}

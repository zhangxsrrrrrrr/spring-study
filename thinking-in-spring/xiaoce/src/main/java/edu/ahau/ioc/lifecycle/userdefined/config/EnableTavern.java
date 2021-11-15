package edu.ahau.ioc.lifecycle.userdefined.config;

import edu.ahau.ioc.enable.BartenderConfiguration;
import edu.ahau.ioc.enable.Boss;
import edu.ahau.ioc.lifecycle.userdefined.WaiterRegistrar;
import org.springframework.context.annotation.Import;

/**
 * 导入依赖
 *
 * @author zhangxuna
 * @date 2021-11-14 22:35
 */
@Import({Boss.class, BartenderConfiguration.class, WaiterRegistrar.class})
public @interface EnableTavern  {

}

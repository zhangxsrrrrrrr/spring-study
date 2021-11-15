package edu.ahau.ioc.basepackage;

import edu.ahau.ioc.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-03 22:35
 */
@Component
@ConditionalOnBean
public class DemoDao {
}

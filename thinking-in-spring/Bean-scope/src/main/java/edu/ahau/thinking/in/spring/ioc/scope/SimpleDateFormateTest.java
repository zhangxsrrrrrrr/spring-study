package edu.ahau.thinking.in.spring.ioc.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangxuna
 * @date 2021-10-24 22:50
 */
public class SimpleDateFormateTest {
//    @Bean("simpleDateFormat")
//    @Scope(SimpleDateFormatScope.SCOPE_NAME)
    public SimpleDateFormat getSimpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext()) {
          annotationConfigApplicationContext.register(SimpleDateFormateTest.class);
          annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanFactory -> beanFactory.registerScope(SimpleDateFormatScope.SCOPE_NAME, new SimpleDateFormatScope()));
          annotationConfigApplicationContext.refresh();
            for (int i = 0; i < 500; i++) {
                new Thread(()->{
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String format = simpleDateFormat.format(new Date());
                    Date parseDate = null;
                    try {
                        parseDate = simpleDateFormat.parse(format);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String dateString2 = simpleDateFormat.format(parseDate);
                    System.out.println(format.equals(dateString2));
                }).start();
            }
        }
    }
}

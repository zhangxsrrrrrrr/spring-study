package edu.ahau.ioc.programioc;

import edu.ahau.ioc.programioc.bean.Cat;
import edu.ahau.ioc.programioc.bean.Person;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Arrays;
import java.util.Set;

/**
 * @author zhangxuna
 * @date 2021-11-05 17:19
 */
public class ProgrammaticQuickstartApplication {
    /**
     * 注解类的注册BeanDefinition
     **/
    @Test
    public  void AnnotationConfigApplicationContextTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
        beanDefinition.addPropertyValue("name", "zhangsan");
        applicationContext.registerBeanDefinition("person", beanDefinition.getBeanDefinition());
        applicationContext.refresh();
        Person person = (Person) applicationContext.getBean(Person.class);
        System.out.println(person);
    }
    /*
    包扫描器
     */
    @Test
    public void ClassPathBeanDefinitionScannerTest() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext()) {
            ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(applicationContext);

            // 自动扫描出来包下面的 所有类
            int scanNums = scanner.scan("edu.ahau.programioc");
            System.out.println("scan   = "+scanNums);
            // 扫描出来包下面的BeanDefinition
            Set<BeanDefinition> components = scanner.findCandidateComponents("edu.ahau.programioc");
            components.forEach(beanDefinition -> {
                if (beanDefinition.getBeanClassName().equals(Person.class.getName())) {
                    MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
                    propertyValues.addPropertyValue("name", "你被我改变了");
                    applicationContext.registerBeanDefinition("person",beanDefinition);
                    System.out.println("我可以随意改变Person哟");
                }
            });
            // 可以使用addExcludeFilter
            scanner.addExcludeFilter((metadataReader, metadataReaderFactory) -> {
                // getClassMetadata 可以获取到扫描类的相关元信息，此处把Animal的子类都拿出来
                return metadataReader.getClassMetadata().getSuperClassName().equals(Cat.class.getName());
            });
            applicationContext.refresh();
            System.out.println(applicationContext.getBean("person"));
            System.out.println(applicationContext.getBean(Cat.class));
        }
    }
    /*
    通过xml获取BeanDefinition
     */
    @Test
    public void XmlBeanDefinitionReaderTest(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 将bBeanDefinition注册到beanFactory中
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("application.xml");
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
    }
}

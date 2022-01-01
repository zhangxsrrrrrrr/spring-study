package edu.ahau.injection;

import edu.ahau.injection.config.BeanConfig;
import edu.ahau.injection.pojo.Dog;
import edu.ahau.lookup.pojo.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

/**
 * @author zhangxuna
 * @date 2022-01-01 12:02
 */
public class SpringDI implements BeanFactoryAware, ApplicationContextAware {

//     byType
    @Resource(name = "person1")
    private Person person1;
//    private Dog dog;

//    private Dog dog;
//    //    @Value("#{'hahah'}")
//    @Value("#{person.name}")
//    private String spELName;
////    // 基于setter
//    @Autowired
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//
////     基于构造器
//    @Autowired
//    public SpringDI(Person person) {
//        this.person = person;
//    }

    @Value("#{T(java.lang.Integer).MAX_VALUE}")
    private  Integer maxValue;

    public Person getPerson() {
//        System.out.println(maxValue);
//        System.out.println(spELName);
        return person1;
    }

//    @Autowired(required = true)
//    public SpringDI(Dog dog) {
//        this.dog = dog;
//    }


//    @Autowired(required = false)
//    public SpringDI(Person person, Dog dog) {
//        this.person1 = person;
////        this.dog = dog;
//    }



    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( BeanConfig.class);
        System.out.println(context.getBean(Dog.class));
//        Person bean = context.getBean(Person.class);
//        SpringDI bean1 = context.getBean(SpringDI.class);
////
//        System.out.println(bean1.getPerson());
////        System.out.println(bean);
//        Dog bean = context.getBean(Dog.class);
////        System.out.println(context.getBean(Person.class));
//        System.out.println(bean);
//        Object person1 = beanFactory.getBean("person1");
//        System.out.println(person1);
//        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    }

    private static BeanFactory beanFactory;
    private static ApplicationContext applicationContext;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        SpringDI.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringDI.applicationContext = applicationContext;
    }
}

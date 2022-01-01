package edu.ahau.lookup;

import edu.ahau.lookup.pojo.Person;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author zhangxuna
 * @date 2022-01-01 11:42
 */
@Repository
@Service
@Controller
public class SpringLookUp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringLookUp.class);
//        Person bean = context.getBean(Person.class);
        ObjectProvider<Person> personProvider = context.getBeanProvider(Person.class);
        Person ifAvailable = personProvider.getIfAvailable(Person::new);
        System.out.println(ifAvailable);
    }

//    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("zhangsan");
        return person;
    }
}

import edu.ahau.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangxuna
 * @date 2021-12-27 16:07
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:application-test.xml")
public class JavaJunitTest {
    @Autowired
    private User user;
    @Test
    public void test() {
        System.out.println(user);
    }
}

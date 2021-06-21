import com.aop.diy.AnnotationAop;
import com.aop.service.UserService;
import com.aop.service.UserServiceImpl;
import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}

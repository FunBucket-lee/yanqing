import com.ioc.pojo.User;
import com.ioc.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user");
        User usert = (User) context.getBean("user");
        System.out.println(user == usert);
    }
}

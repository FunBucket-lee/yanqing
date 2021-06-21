import com.qing.Ioptest.service.UserServerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServerImpl userServerImpl = (UserServerImpl) context.getBean("ServerImpl");
        userServerImpl.getUser();
    }
}

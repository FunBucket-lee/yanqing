package com.ano.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("Singleton")//单例模式
//@Scope("Prototype") 单例模式
public class User {

/*相当于
<bean id="user" class="com.ano.pojo.User">
    <property name="name" value="燕青"></property>
</bean>*/
    public String name;

    @Value("燕青")
    public void setName(String name) {
        this.name = name;
    }
}

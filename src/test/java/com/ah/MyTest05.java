package com.ah;

import com.ah.ba05.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeServiceImpl someService = (SomeServiceImpl) ctx.getBean("someService");
        someService.doSome("zs", 20);
        //目标类灭有接口，使用cglib动态代理，spring框架会自动应用cglib
        System.out.println(someService.getClass().getName());
    }
}
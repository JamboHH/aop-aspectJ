package com.ah;

import com.ah.ba03.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService proxty = (SomeService) ctx.getBean("someService");
        String str = proxty.doOther("张三", 20);
        System.out.println("str = " + str);
    }
}
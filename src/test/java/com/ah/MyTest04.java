package com.ah;

import com.ah.ba04.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest04 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService proxty = (SomeService) ctx.getBean("someService");
        proxty.doSome("张三", 20);
    }
}
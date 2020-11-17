package com.ah;

import com.ah.ba02.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService proxty = (SomeService) ctx.getBean("someService");
        String s = proxty.doOther("lisi", 20);
    }
}
package com.ah;

import com.ah.ba01.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService proxty = (SomeService) ctx.getBean("someService");
        proxty.doSome("lisi", 20);
        proxty.doOther("wangwu", 28);
    }
}
package com.ah.ba05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
    @Aspect：时aspectJ框架中的注解。
    作用：表示当前类是切面类
    切面类:是用来给业务方法增加功能的类，在这个类中有切面的功能代码
    位置：在类定义的上面
* */
@Aspect
public class MyAspect {
    @After("mypt()")
    public void myAfter() {
        System.out.println("执行最终通知，总是会被执行的代码");
    }

    @Before("mypt()")
    public void myBefore() {
        System.out.println("前置通知，在目标方法之前先执行的");
    }

    /*
        @Pointcut：定义和管理切入点，如果你的项目中有多个切入点表达式是重复的，可以复用。可以使用@pointcut
        属性：value 切入点表达式
        位置：在自定义方法上方
        特点：
            当使用@Pointcut定义在一个方法的上面，此时这个方法的名称就是切入点表达式的别名。
            其他统治中，value就可以使用这个别名代替。
    */
    @Pointcut("execution(* *..SomeServiceImpl.doSome(..))")
    private void mypt() {
    }
}

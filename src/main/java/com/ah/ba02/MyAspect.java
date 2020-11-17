package com.ah.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

/*
    @Aspect：时aspectJ框架中的注解。
    作用：表示当前类是切面类
    切面类:是用来给业务方法增加功能的类，在这个类中有切面的功能代码
    位置：在类定义的上面
* */
@Aspect
public class MyAspect {
    /*
        @AfterReturning：后置通知
            属性：1.value 切入点表达式
                 2.returning 自定义的变量，表示目标方法的返回值。
                    自定义变量名必须和通知方法的形参名一样
            使用位置：方法定义的上面
            特点：1.在目标方法之后执行
                  2.可以获取到目标方法的返回值，可以根据这个返回值做不同的处理功能
                  3.可以修改返回值
    */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))", returning = "res")
    public void afterReturning(Object res) {
        //Object res：是目标方法执行后的放回值，根据返回值做你的切面的处理
        System.out.println("后置通知，在目标方法之后执行，获取的返回值是:" + res);
        if (res.equals("abcddd")) {
            System.out.println("Bingo");
        } else {
            System.out.println("Wrong");
        }
    }
}

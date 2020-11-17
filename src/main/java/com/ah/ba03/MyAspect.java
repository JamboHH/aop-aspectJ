package com.ah.ba03;

import org.aspectj.lang.ProceedingJoinPoint;
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
        @Around:环绕通知
            属性：value 切入点表达式
            位置:在方法定义的上方
            特点：
                1.功能最强的通知
                2.可以在目标方法的前和后都能增强功能
                3.能控制目标方法是否会调用执行
                4.修改原来的目标方法的执行结果。影响最后的调用结果

             环绕通知就等同于 jdk的动态代理，InvocationHandler接口
             参数:ProceedingJoinPoint 就等同于Method
                作用:执行目标方法的
             返回值：就是目标方法的执行结果，可以被修改
    */
    @Around("execution(* *..SomeServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("环绕通知：在目标方法之前输出执行时间：" + new Date());
        Object result = null;
        String name = "";
        try {
            Object[] args = pj.getArgs();
            if (args != null && args.length > 1) {
                Object arg = args[0];
                name = (String) arg;
            }
            //目标方法的调用
            if (name.equals("张三")) {
                result = pj.proceed();//等同于method.invoke();
            }
            System.out.println("环绕通知：在目标方法之后，提交事务");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("程序出现错误是执行的方法");
        } finally {
            System.out.println("最终通知 无论如何都会执行");
        }
        if (result != null) {
            result = "Hello World";
        }
        return result;
    }

}

package com.ah.ba01;

import org.aspectj.lang.JoinPoint;
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
     *   定义方法，方法是实现切面功能的
     *   方法的要求：
     *   1.公共方法
     *   2.方法没有返回值
     *   3.方法名称自定义
     *   4.方法可以有参数，也可以没有参数
     *       如果有参数，参数不是自定义的，有几个参数可供选择
     * */
    /*
      @Before:前置通知注解,属性value：是切入点表达式，表示切面功能的执行位置
      特点：
        1。在目标方法之前执行的
        2.不会改变目标方法的执行结果
        3.不会影响目标方法的执行
    */
/*    @Before("execution(public void com.ah.ba01.SomeServiceImpl.doSome(String,Integer))")
    public void myBefore() {
        //切面要执行的功能代码
        System.out.println("前置通知，切面功能：在目标方法之前输出执行时间：" + new Date());
    }

    @AfterReturning("execution(public void com.ah.ba01.SomeServiceImpl.doSome(String,Integer))")
    public void afterReturning() {
        System.out.println("后置通知，切面功能：在目标方法之后输出时间：" + new Date());
    }

    @After("execution(public void com.ah.ba01.SomeServiceImpl.doSome(String,Integer))")
    public void after() {
        System.out.println("最终通知 无论如何都会执行");
    }

    @AfterThrowing("execution(public void com.ah.ba01.SomeServiceImpl.doSome(String,Integer))")
    public void afterThrowing() {
        System.out.println("程序出现错误是执行的方法");
    }*/
   /* @Around("execution(public void com.ah.ba01.SomeServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("前置通知，切面功能：在目标方法之前输出执行时间：" + new Date());
        Object proceed = null;
        try {
            proceed = pj.proceed();
            System.out.println("后置通知，切面功能：在目标方法之后输出时间：" + new Date());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("程序出现错误是执行的方法");
        } finally {
            System.out.println("最终通知 无论如何都会执行");
        }
        return null;
    }*/

    /*
         指定通知方法中的参数：JoinPoint
         JoinPoint：业务方法，要加入切面功能的业务方法
             作用是：可以再通知方法中获取方法执行的信息，例如方法名称，方法的实参
             如果你的切面功能中需要用到方法的信息，就加入JoinPoint
             使用JoinPoint的要求：参数的值由框架赋予，必须是第一个位置的参数
    * */
    @Before("execution(* *(..))")
    public void myBefore(JoinPoint jp) {
        //获取方法的完整定义
        System.out.println("方法的定义=" + jp.getSignature());
        System.out.println("方法的名称=" + jp.getSignature().getName());
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println("参数=" + arg);
        }
        //切面要执行的功能代码
        System.out.println("前置通知，切面功能：在目标方法之前输出执行时间：" + new Date());
    }
}

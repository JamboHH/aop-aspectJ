package com.ah.ba01;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        //给doSome方法增加一个功能，在doSome执行前 输出执行时间
        System.out.println("==========目标方法doSome==============");
    }

    @Override
    public void doOther(String name, Integer age) {
        System.out.println("==========目标方法doOther==============");

    }

}

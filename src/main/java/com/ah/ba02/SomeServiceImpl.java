package com.ah.ba02;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        System.out.println("==========目标方法doSome==============");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("==========目标方法doOther==============");
        return "abcddd";
    }

}

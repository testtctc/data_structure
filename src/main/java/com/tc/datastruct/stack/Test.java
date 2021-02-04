package com.tc.datastruct.stack;

public class Test {
    public static void  main(String[] array){
        MyStack stack = new MyStack(4);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(9);
        System.out.println(stack.dispaly());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(10);
        System.out.println(stack.dispaly());
        System.out.println(stack.isEmpty());
    }
}

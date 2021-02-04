package com.tc.datastruct.queue;


public class Test {

    public static void main(String[]args){
        Myqueue<Integer> queue = new Myqueue<>(4);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(9);
        queue.display();
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(10);
        queue.display();



    }


}

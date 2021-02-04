package com.tc.datastruct.stack;


//基本原理 先进先出
public class MyStack {

    //固定数组
    final private int [] internalarray;

    final private int maxsize;
    //当前游标位置
    private int top=-1;

    //构造函数
    public  MyStack(int maxsize){
        this.maxsize= maxsize;
        internalarray =new int[this.maxsize];
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("there are no elements to pop");
            return Integer.MIN_VALUE;
        }else{
            return internalarray[top];

        }
    }

    //推入元素
    public boolean push(int element){
        if (top < this.maxsize - 1){
            internalarray[++top]= element;
            return true;
        }
        else{
            return false;
        }
    }

    //弹出元素
    public int pop(){
        if (isEmpty()){
            System.out.println("there are no elements to pop");
            return Integer.MIN_VALUE;
        }else{
            return internalarray[top--];

        }
    }

    public boolean isEmpty(){
        return top == -1;

    }

    //是否因放满了元素
    public boolean isFull(){
        return (top == maxsize-1);
    }

    public String dispaly(){
        StringBuilder builder = new  StringBuilder();
        builder.append("{");
        for (int i = 0;i<=top;i++){
            builder.append(internalarray[i]);
            if (i<=top-1) builder.append(",");
        }
        builder.append("}");
        return builder.toString();
    }
}

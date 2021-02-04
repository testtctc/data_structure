package com.tc.datastruct.link;


//双向连标的
public class DoublenLinkedList {
    public static class Node{
        Node next;
        Object data;
        public Node(Object data){
            this.data=data;
        }
    }


    Node head;
    Node tail;
    int size;

    public void addHead(Object data ){
        Node c = new Node(data);
        if (head==null){
            head=tail=c;
        }
        else{
            c.next=head;
            head=c;
        }
        size ++;
    }

    public  Object deleteHead(){
        if (size==0){
            return null;
        }
        else if(size==1){
            Object d= head.data;
            head=null;
            tail=null;
            return d;
        }
        else{
            Object data= head.data;
            head= head.next;
            return data;
        }
    }

    public void addTail(Object data ){
        Node c = new Node(data);
        if (head==null){
            head=tail=c;
        }
        else{
            tail.next=c;
            tail=c;
        }
        size ++;
    }

    //删除末尾节点
    public Object deleteTail(){
        if (size==0){
            return null;
        }
        else if(size==1){
            Object d =tail.data;
            head=null;
            tail=null;
            size--;
            return d;
        }
        else{
            size--;
            Object data= tail.data;
            Node current= head;

            //跨越两个节点
            while(current.next.next!=null){
                current=current.next;
            };
            //消除引用
            current.next=null;
            tail=current;
            return data;
        }
    }

    public void display(){
        Node curernt =head;
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        while (curernt != null){
            builder.append(curernt.data.toString());
            if (curernt.next != null){
                builder.append(" -> ");
            }
            curernt= curernt.next;
        }
        builder.append("}");
        System.out.println(builder.toString());
    }


}

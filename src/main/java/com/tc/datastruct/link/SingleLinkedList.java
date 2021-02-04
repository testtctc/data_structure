package com.tc.datastruct.link;

public class SingleLinkedList {

    public static class Node{
        Node next;
        Object data;
        public Node(Object data){
            this.data=data;
        }
    }

    //元素数量
    int size=0;
    Node head=null;

    public void addHead(Object data) {
        Node d = new Node(data);
        if (head == null) {
            head = d;
        } else {
            d.next = head;
            head = d;
        }
        size ++;
    }

    public Object deleteHead(){
        if (head==null){
            return null;
        }
        Node current =head;
        head =head.next;
        current.next=null;
        size--;
        return current.data;
    }

    //查找元素
    public Object find(Object obj){
        Node currrent = head;
        while (currrent != null){
            if (currrent.data.equals(obj)){
                return currrent.data;
            }else {
                currrent = currrent.next;
            }

        };
        return null;


    }

    public void display(){
        Node curernt =head;
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        while (curernt != null){
            builder.append(curernt.data.toString());
            if (curernt.next != null){
                builder.append("->");
            }
            curernt= curernt.next;
        }
        builder.append("}");
        System.out.println(builder.toString());
    }


}

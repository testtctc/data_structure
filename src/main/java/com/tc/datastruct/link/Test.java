package com.tc.datastruct.link;

public class Test {
    public static void main(String[]args){
        SingleLinkedList linkedlist = new SingleLinkedList();
        linkedlist.addHead(1);
        linkedlist.addHead(2);
        linkedlist.addHead(3);
        linkedlist.display();
        System.out.println(linkedlist.deleteHead());
        linkedlist.display();
        System.out.println(linkedlist.find(5));

        System.out.println("==============================");

        DoublenLinkedList dlist =new DoublenLinkedList();
        dlist.addHead(1);
        dlist.addHead(2);
        dlist.addHead(3);
        dlist.display();
        System.out.println(dlist.deleteHead());
        dlist.display();
        dlist.addTail(4);
        dlist.display();
        System.out.println(dlist.deleteTail());
        dlist.display();
    }

}

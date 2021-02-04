package com.tc.datastruct.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.tc.al.recursive.Power;



//主要思想--递归
public class BinaryTree<T extends Comparable<T>> {
    public static final int MAX_SIZE=1000;
    int size=0;
    int maxsize;
    //根节点
    Node<T> root;

    public BinaryTree(int maxsize){
        this.maxsize= maxsize;
    }

    public BinaryTree(){
        this.maxsize= MAX_SIZE;
    }



    public static class Node<T extends Comparable<T>>{
        T data;
        Node<T> left;
        Node<T> right;
        //节点个数

        public Node(T data){
            this.data= data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data.toString() +
                    '}';
        }

    }

    public boolean add(T data){
        if (size == maxsize){
            return false;
        }
        else{
            size++;
            Node<T> node =new Node(data);
            if (root==null){
                root =node;
            }
            else{
                insert(root,node);
            }
            return true;
        }
    }

    //插入节点
    public void insert(Node<T> node1,Node<T> node2){
        if (lessthan(node2,node1)){
            if (node1.left == null){
                node1.left=node2;
            }
            else{
                insert(node1.left,node2);
            }
        }else{
            if (node1.right == null){
                node1.right=node2;
            }
            else{
                insert(node1.right,node2);
            }
        }
    }

    //计数
    public int length(){
        return size;
    }

    public boolean lessthan(Node<T> node1,Node<T> node2){

        if (node1.data.compareTo(node2.data) < 0){
            return true;
        }
        else{
            return false;
        }
    }

    public T find(T data){
        return find(root,data);
    }


    //找不到返回null
    public T find(Node<T>node,T data) {
        if (node == null) {
            return null;
        } else {
            int res = node.data.compareTo(data);
            if (res == 0) {
                return data;
            } else if (res > 0) {
                return find(node.left, data);
            } else {
                return find(node.right, data);
            }

        }
    }

    //先序遍历
    public List<Node<T>> iterator_first(){
        ArrayList<Node<T>> array = new ArrayList<>();
        iterator_first(root,array);
        return array;
    }


    //基于while循环
    public List<Node<T>> iterator_first_1(){
        ArrayList<Node<T>> array = new ArrayList<>();
        Stack<Node<T>> stack =new Stack<>();
        stack.add(root);
        while (! stack.isEmpty()){
            Node<T> node = stack.pop();
            array.add(node);
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }


        return array;
    }

    public void iterator_first(Node<T> node,List<Node<T>> list){
        if (node != null){
            list.add(node);
            iterator_first(node.left,list);
            iterator_first(node.right,list);
        }
    }

    //中序遍历
    public List<Node<T>> iterator_second(){
        ArrayList<Node<T>> array = new ArrayList<>();
        iterator_second(root,array);
        return array;
    }

    public void iterator_second(Node<T> node,List<Node<T>> list){
        if (node != null){
            iterator_first(node.left,list);
            list.add(node);
            iterator_first(node.right,list);
        }
    }


    //后序遍历
    public List<Node<T>> iterator_third(){
        ArrayList<Node<T>> array = new ArrayList<>();
        iterator_second(root,array);
        return array;
    }

    public void iterator_third(Node<T> node,List<Node<T>> list){
        if (node != null){
            iterator_first(node.left,list);
            iterator_first(node.right,list);
            list.add(node);

        }
    }

    public void display(){
        //用先序遍历
        List<Node<T>> list = iterator_first();
        for(Node<T> node:list){
            System.out.println(node);
        }
    }

    //计算计算树的深度
    public int height(){
        return  height(root);
    }


    public int height(Node<T> node){
        if (node == null) {
            return 0;
        }
        else{
            if (node.left==null && node.right==null){
                return 1;
            }
            else{
                return 1 + Math.max(height(node.left),height(node.right));
            }
        }
    }

    public boolean isFullTree(){
        return size == Power.power(2, height()) - 1;
    }

    public void clear(){

    }


    public void clear(Node<T> node){
        if (node != null){
            clear(node.left);
            clear(node.right);
            node=null;
        }

    }

    public boolean isEmpty(){
        return root == null;
    }


}

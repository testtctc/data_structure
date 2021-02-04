package com.tc.datastruct.tree;



//红黑树
public class RBTree<T extends Comparable<T>> {
    class Node{
        Node left;
        Node right;
        Node parent;
        T data;
        boolean isRed;
    }

    //左旋
    public void rotate_left(Node top) {
        boolean original_color= top.isRed;
        Node parent= top.parent;

        Node left= top.left;
        Node move_node= left.right;

        top.left=move_node;
        move_node.parent=top;

        top.isRed=left.isRed;
        left.isRed=original_color;

        left.parent=parent;
        top.parent=left;




    }

    //右旋
    public void rotate_right(Node top){


    }



}

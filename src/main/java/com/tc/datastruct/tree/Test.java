package com.tc.datastruct.tree;

public class Test {
    public static void main(String[] args){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(5);
        tree.display();
        System.out.println(tree.height());
        System.out.println("================TrieTree======================");
        TrieTree trieTree= new TrieTree();
        trieTree.insert("hello");
        trieTree.insert("hi");
        trieTree.insert("world");
        trieTree.insert("word");
        trieTree.insert("would");
        trieTree.display();
        System.out.println("================TrieTree remove ======================");
        trieTree.remove("word");
        trieTree.display();

        System.out.println("================TrieTree frequency ======================");
        trieTree.insert("world");
        System.out.print("world -> ");
        System.out.println(trieTree.frequency("world"));
        System.out.print("hello -> ");
        System.out.println(trieTree.frequency("hello"));
        System.out.println("================TrieTree contains ======================");
        System.out.println(trieTree.contains("hello"));

        System.out.println("================TrieTree size ======================");
        System.out.println(trieTree.size());
        System.out.println(trieTree.distinct_size());

        System.out.println("================TrieTree match ======================");
        System.out.println(trieTree.match("he"));
        System.out.println(trieTree.match("wo"));


    }



}

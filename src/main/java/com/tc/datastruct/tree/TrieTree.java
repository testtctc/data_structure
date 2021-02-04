package com.tc.datastruct.tree;


import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//字符串查找树
public class TrieTree {

    public static class Node{
        //当前节点包含的字符
        Character c;
        //字符串出现次数--这里指完整的字符串出现的次数，例如同时有he hello两个单词，但是出现次数只算1次
        int occurances=0;
        //子节点
        Map<Character,Node> children;

        public Node(Character c){
            this.c=c;
        }

        //插入字符到子节点
        //返回字符串的发生次数
        public int insert(String value,int position){
            if (position >= value.length() || value == null){
                return 0;
            }

            Character current_character= value.charAt(position);
            Node current_node;
            if (children == null) {
                children= new HashMap<>();
                current_node= new Node(current_character);
                children.put(current_character,current_node);
            }
            else{
                current_node= children.get(current_character);
                if (current_node==null){
                    current_node= new Node(current_character);
                    children.put(current_character,current_node);
                }
            }
            //终结
            if (position== value.length() -1){
                current_node.occurances= current_node.occurances+1;
                return current_node.occurances;
            }
            else{
                //处理下一个字符
                return current_node.insert(value,position+1);
            }
        }

        //删除字符串
        //结果返回是否成功删除
        boolean remove(String value, int position) {
            if (value==null || position >= value.length()){
                return false;
            }
            if (children==null){
                return false;
            }

            Character current_character= value.charAt(position);
            Node current_node;

            current_node=children.get(current_character);

            if (current_node==null){
                return false;
            }
            else{
                //刚好到了位置上
                if (value.length()-1==position){
                    //非字符串
                    if (current_node.occurances==0){
                        return false;
                    }
                    else{
                        //刚好是叶子节点
                        if (current_node.children==null){
                            //移除节点
                            children.remove(current_character);
                        }
                        else{
                            //直接标志非叶子节点
                            current_node.occurances=0;
                        }
                        return true;

                    }
                }
                else{
                    return current_node.remove(value,position+1);
                }
            }
        }

        //返回某个字符串的发生次数
        public int frequency(String value,int position){
            if (children==null || position >= value.length()){
                return 0;
            }
            Character current_character= value.charAt(position);
            //可能为空
            Node current_node=children.get(current_character);

            if (current_node ==null){
                return 0;
            }

            if (position==value.length()-1 ){
                return current_node.occurances;
            }else{
                return current_node.frequency(value,position+1);
            }

        }

        //当前节点及其子节点包含的字符串数量。这里不计算重复发生次数
        public int distinct_size(){
            int s=0;
            if (children!=null){
                for(Node node:children.values() ){
                    s =s + node.distinct_size();
                }
            }
            return s + (occurances>0 ? 1 : 0);
        }

        //当前节点及其子节点包含的字符串数量。这里不计算重复发生次数
        public int size(){
            int s=0;
            if (children!=null){
                for(Node node:children.values() ){
                    s+=node.size();
                }
            }
            return s+ occurances;
        }

        //展示
        public void display(String prefix){
            String new_prefix;
            if (c!=null){
                new_prefix=prefix+c.toString();
            }
            else{
                new_prefix=prefix;
                //根节点
            }
            //存在字符串
            if (occurances>0){
                System.out.println(new_prefix);
            }

            if (children != null){
                for(Node node:children.values()){
                    node.display(new_prefix);
                }
            }

        }

        public void match(String value,String prefix,List<String> array,int position){
            //新前缀
            String new_prefix;

            if (c!=null){
                new_prefix=prefix+c.toString();
            }
            else{
                //根节点
                new_prefix=prefix;
            }

            if (children==null){
                return ;
            }

            //当前缀完全包含时
            if (position>=value.length()){
                for(Node node:children.values()){
                    if (node.occurances>0){
                        //添加并递归
                        array.add(new_prefix+ node.c.toString());
                    }
                    node.match(value,new_prefix,array,position+1);

                }
            }
            else{
                Character current_character= value.charAt(position);
                //可能为空
                Node current_node=children.get(current_character);
                //不存在
                if (current_node ==null){
                    return ;
                }
                else{
                    if (position==value.length()-1 && current_node.occurances>0){
                        array.add(new_prefix+current_character.toString());
                    }
                    current_node.match(value,new_prefix,array,position+1);
                }

            }





        }

    }

    //根节点
    private Node root=new Node(null);

    // 判断字典树中是否有该字符串。
    public  boolean contains(String word){
        return root.frequency(word,0) >0;
    };

    // 返回该字符串在字典树中出现的次数。
    public int frequency(String word){
        return root.frequency(word,0);
    };

    // 插入一个字符串。
    // 返回发生次数
    public  int insert(String word){
        return root.insert(word,0);
    };

    // 删除一个字符串。
    public  boolean remove(String word){
        return root.remove(word,0);

    };

    // 整个字典树中不同字符串的个数，也就是保存的不同字符串的个数。
    public  int size(){
        return root.size();
    };

    public  int distinct_size(){
        return root.distinct_size();
    };

    //字符串匹配
    public List<String> match (String pattern){
        List<String> res= new ArrayList<String>();
        root.match(pattern,"",res,0);
        return res;

    }

    //展现树
    public void display(){
        root.display("");

    }


}

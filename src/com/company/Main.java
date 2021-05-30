package com.company;

public class Main {
    public static void main(String[] args) {
        BST<Integer,String> bst = new BST<>();
        bst.put(1,"Akbala");
        bst.put(2,"Malika");
        bst.put(3,"Adina");
        bst.delete(3);
        System.out.println(bst.get(2));
    }
}

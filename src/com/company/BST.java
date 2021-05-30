package com.company;
import java.util.ArrayList;
public class BST <K extends Comparable <K>, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        private int N;

        public Node(K key, V value, int N) {
            this.key = key;
            this.value = value;
            this.N=N;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null)
            return null;
        int comparable = key.compareTo(node.key);
        if (comparable < 0)
            return get(node.left, key);
        else if (comparable > 0)
            return get(node.right, key);
        else return node.value;
    }

    public void put(K key, V value) {//searching for key,update value if found
        root = put(root, key, value);
    }
    public int size() {
        return size(root);
    }
    private int size(Node node) {
        return node == null ? 0 : node.N;//if (node == null) return(0);
    }

    private Node put(Node node, K key, V value) {
        if (node == null)
            return new Node(key,value,1);
        int comparable = key.compareTo(node.key);
        if (comparable < 0)
            node.left = put(node.left, key, value);
        else if (comparable > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;


        node.N=size(node.left)+size(node.right)+1;
        return node;

    }
    public void delete(K key) {
        root = delete(root, key);
    }
    private Node delete(Node node, K key) {
        if (node == null) {

        } else if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else if (node.right == null) {
            node = node.left;
        } else {
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public K min() {
        if (isEmpty())
            System.out.println("empty symbol table");
        return min(root).key;
    }
    private Node min(Node node) {
        if (node.left == null)
            return node;
        else
            return min(node.left);
    }
    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

}
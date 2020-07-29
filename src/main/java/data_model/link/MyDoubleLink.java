package data_model.link;

import java.util.LinkedList;

public class MyDoubleLink {
    static class Node {
        Node prev;
        Node next;
        int data;

        public Node(Node prev, int data, Node next) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    Node last;
    Node first;

    int size=0;

    public void add(int elem) {
        addLast(elem);
    }

    private void addLast(int elem) {
        Node l = last;
        Node newNode = new Node(l, elem, null);
        last=newNode;
        if(l!=null) {
            l.next = newNode;
        }else {
            first=newNode;
        }
        size++;
    }
    private void addFirst(int elem){
        Node f=first;
        Node newNode = new Node(null,elem,f);
        first=newNode;
        if(f!=null){
            f.prev=newNode;
        }else {
            last=newNode;
        }
        size++;
    }
    private int size(){
        return size;
    }
    private void get(int index){
        Node currNode = first;
        int len =0;
        while (currNode.next!=null){
            currNode=currNode.next;
            len++;
            if(len==index){
                System.out.println(currNode.data);
            }
        }
    }
    private void print() {
        Node currNode = first;
        while (currNode.next != null) {
            System.out.print(currNode.data);
            currNode = currNode.next;
        }
        System.out.print(currNode.data);
    }


    public static void main(String[] args) {
        MyDoubleLink myDoubleLink = new MyDoubleLink();
        myDoubleLink.add(1);
        myDoubleLink.add(2);
        myDoubleLink.addFirst(3);
        myDoubleLink.addFirst(4);
        myDoubleLink.print();
        myDoubleLink.get(3);
        System.out.println(myDoubleLink.size());
        LinkedList<Object> objects = new LinkedList<>();
    }
}

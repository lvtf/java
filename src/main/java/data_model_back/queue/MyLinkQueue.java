package data_model_back.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class MyLinkQueue {
    static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;
        public Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    transient Node first;
    transient Node last;
    int capacity;
    MyLinkQueue(int capacity){
        this.capacity=capacity;
    }
     MyLinkQueue() {
        this(Integer.MAX_VALUE);
    }

    private void add(int elem){
        Node l=last;
        Node newNode = new Node(elem,null,null);
        last=newNode;
        if(l!=null){
            l.next=newNode;
        }else {
            first=newNode;
        }
    }
    private void print(){
        Node currNoe=first;
        while (currNoe.next!=null){
            System.out.print(currNoe.item);
            currNoe=currNoe.next;
        }
        System.out.print(currNoe.item);
    }

    public static void main(String[] args) throws InterruptedException {
        MyLinkQueue myLinkQueue = new MyLinkQueue();
        myLinkQueue.add(1);
        myLinkQueue.add(2);
        myLinkQueue.add(3);
        myLinkQueue.print();
        LinkedBlockingQueue<Integer> qu = new LinkedBlockingQueue<>();
        qu.put(22);
        qu.put(23);
        qu.put(24);
        System.out.println(qu.toString());
        qu.take();
        System.out.println(qu.toString());
    }

}

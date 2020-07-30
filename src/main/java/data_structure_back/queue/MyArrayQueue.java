package data_structure_back.queue;

import java.util.Arrays;

public class MyArrayQueue<T> {
    //存储数据的队列
    private T[] queue;
    //队列的最大容量
    private int capacity;
    //队列的头节点，用于出队
    private int head;
    //队列尾节点，用于入队
    private int tail;

    /**
     * 1%5 1
     * 2%5 2
     * 5%5 0
     *
     */


    public MyArrayQueue(int capacity) {
        this.queue = newrray(capacity + 1);
        this.capacity = capacity;
        this.head = head;
        this.tail = tail;
    }
    private void add(T elem){
        queue[tail]=elem;
        int newTail = (tail + 1) % capacity;
        if(newTail==head){
            throw new IndexOutOfBoundsException("queu full");
        }
        tail=newTail;
    }
    private T remove(int i){
        int size = size();
        if  (i != 0) throw new IllegalArgumentException("Can only remove head of queue");
        if (i > size) throw new IllegalArgumentException("大于queue size");
        if (head == tail) throw new IllegalArgumentException("queue empty");
        T remove = queue[head];
        queue[head]=null;
        head = (head + 1) % capacity;
        return remove;

    }
    private T get(int i){

        int index = (head + i) % capacity;
        T t = queue[index];
        return t;
    }
    private int size(){
        int size = tail - head;
        if(size<0){
            size+=capacity;
        }
        return size;
    }

    @Override
    public String toString() {
        return "MyArrayQueue2{" +
                "queue=" + Arrays.toString(queue) +
                ", capacity=" + capacity +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }


    public static void main(String[] args) {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.toString());
        System.out.println(queue.get(0));
        System.out.println(queue.remove(0));
        System.out.println(queue.toString());
        System.out.println(1%5);
        System.out.println(5%5);
    }




    private T[] newrray(int size) {
        return (T[]) new Object[size];

    }
}

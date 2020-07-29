package data_model.queue;

import dynamic_proxy2.P;

import java.util.jar.JarOutputStream;

public class CircleArrayQueue {
    int maxSize;
    int[] arr;
    //表示队列的第一个元素的位置，默认是0
    int front;
    //约定队列预留出一个位置
    //表示队列的最后一个元素位置的后一个位置，默认是0，
    int rear;

    //队列的有效个数：(rear + maxSize - front) % maxSize;  maxSize -1
    //
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void add(int elem) {
        if (isFull()) {
            System.out.println("full");
            return;
        }
        arr[rear] = elem;
        rear = (rear + 1) % maxSize;

    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("empty");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void show() {
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d],%d\n", i%maxSize, arr[i%maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int getHead() {
        if (isEmpty()) {
            System.out.printf("empty");
        }
        System.out.println(arr[front % maxSize]);
        return arr[front % maxSize];


    }

    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        circleArrayQueue.add(2);
        circleArrayQueue.add(3);
        circleArrayQueue.add(1);
        circleArrayQueue.show();
        circleArrayQueue.add(1);
        circleArrayQueue.show();
        System.out.println("==");
        circleArrayQueue.getHead();
        circleArrayQueue.show();
        System.out.println("==");
        circleArrayQueue.remove();
        circleArrayQueue.show();

    }

}

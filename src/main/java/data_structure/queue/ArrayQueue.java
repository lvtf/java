package data_structure.queue;


public class ArrayQueue {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.show();
        System.out.println(arrayQueue.head());
        int i = arrayQueue.get();
        System.out.println(i);
        System.out.println(arrayQueue.head());
    }

    private int maxSize;
    private int front = -1; //队列头 不包含任何数据
    private int real = -1;//队列尾，指队列最后一个数据
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        real = -1;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        if (real == maxSize - 1) {
            System.out.println("队列已满，不能添加数据");

        }
        return false;
    }

    public boolean isEmpty() {
        if (front == real) {
            System.out.println("队列是空的");
        }
        return false;
    }

    public void add(int x) {
        if (isFull()) {
            System.out.println("队列已满，不能添加数据");
        }
        arr[++real] = x;
    }

    public int get() {
        if (isEmpty()) {
            System.out.println("队列是空的,不能移除数据");
        }
        return arr[++front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列是空的");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d],%d\n", arr[i], i);
        }
    }

    public int head() {
        if (isEmpty()) {
            System.out.println("队列是空的");
        }
        return arr[front + 1];
    }
}

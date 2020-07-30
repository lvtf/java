package data_structure.review;

import java.util.Scanner;

public class CircleArrayQueueReview {

    int front;
    int rear;
    int maxSize;
    int[] arr;

    public CircleArrayQueueReview(int arrMaxSize) {
        arr = new int[arrMaxSize+1];
        maxSize = arrMaxSize;
    }

    public Boolean isEmpty() {
        return front == rear;
    }

    public Boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void add(int elem) {
        if (isFull()) {
            System.out.println("full");
            return;
        }
        arr[rear] = elem;
        rear = (rear + 1) % maxSize;
    }

    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("empty");
        }
        int tmp = front;
        front = front + 1;
        return arr[tmp];
    }

    public int getHead() {
        return arr[front % maxSize];
    }

    public void show() {
        for (int i = front; i <front+size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size(){
        return (rear+maxSize-front) %maxSize;
    }
    public static void main(String[] args) throws Exception {

        System.out.println("测试数组模拟环形队列的案例~~~");
// 创建一个环形队列
        CircleArrayQueueReview queue = new CircleArrayQueueReview(4); //说明设置 4, 其队列的有效数据最大是 3 char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        char key = ' '; // 接收用户输入
// 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g':
                    int res = queue.remove();
                    System.out.printf("取出的数据是%d\n", res);

                    break;
                case 'h': // 查看队列头的数据

                    int a = queue.getHead();
                    System.out.printf("队列头的数据是%d\n", a);

                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}




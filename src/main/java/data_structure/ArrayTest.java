package data_structure;

public class ArrayTest {

    //元素的长度
    private int size;

    private int[] data;

    //构造函数，传入数组的容量capacity构造Array
    public ArrayTest(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //无参数的构造函数，默认数组的容量capacity=10
    public ArrayTest() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public void addLast(int e) {
        add(size, e);
    }

    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed ,index < 0 || index > size");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed index is illega");
        }
        int result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return result;
    }


    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set failed index is illega");
        }
        data[index] = e;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get failed index is illega");
        }
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d , capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayTest arr = new ArrayTest(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
        arr.remove(0);
        System.out.println(arr);
        arr.remove(arr.size - 1);
        System.out.println("last: " + arr);
        arr.remove(arr.size);
        System.out.println("last: " + arr);
        arr.add(0, 1);
        arr.add(1, 10);
        System.out.println(arr);
        System.out.println(arr.get(1));
        arr.set(1, 100);
        System.out.println(arr);

    }

}

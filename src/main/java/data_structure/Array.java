package data_structure;

public class Array {
    private int size;
    private int[] data;

    private int capacity;

    public Array(int capacity) {
        data = new int[capacity];
    }

    public Array() {
        this(10);
    }

    public void addLast(int e) {
        add(size, e);
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public void add(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("failed");
        }
        if (size == data.length) {
            resize(new int[data.length * 2]);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("failed");
        }
        return data[index];
    }

    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("failed");
        }
        data[index] = e;
    }


    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("failed");
        }
        for (int i = index + 11; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
    }


    private void resize(int[] dataNew) {
        for (int i = 0; i < data.length; i++) {
            dataNew[i] = data[i];
        }
        data = dataNew;
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
        Array array = new Array(5);
        array.add(0, 0);
        array.add(1, 1);
        array.add(2, 2);
        array.add(3, 3);
        array.add(4, 4);
        System.out.println(array);
        array.add(5, 5);
        System.out.println(array);

        System.out.println(array.get(3));
        array.set(3, 10);
        System.out.println(array);
        array.remove(3);
        System.out.println(array);
    }


}

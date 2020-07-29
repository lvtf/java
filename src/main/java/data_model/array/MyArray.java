package data_model.array;

public class MyArray {
    int size;
    int[] data;

    public MyArray(int capacity) {
        this.data=new int[capacity];
        this.size = 0;
    }

    public void addLast(int elem){
        if (size==data.length){
            throw new IndexOutOfBoundsException("full");
        }
        data[size]=elem;
        size++;
    }
    public void  add(int elem,int index){
        for (int i = size-1; i >=index ; i--) {
            data[i+1]=data[i];
        }
        data[index]=elem;
       size++;
    }
    private int get(int index){
        return  data[index];
    }

    public void get(){

    }
    public int size(){
        return size;
    }

    public void print(){
        for (int i = 0; i <size(); i++) {
            System.out.print(data[i]);
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(10);
        myArray.addLast(1);
        myArray.addLast(2);
        myArray.add(11,1);
        System.out.println(myArray.get(1));
        myArray.print();
    }

}

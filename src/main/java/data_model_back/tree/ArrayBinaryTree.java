package data_model_back.tree;

/**
 * 数组话二叉树
 */
public class ArrayBinaryTree extends  Thread {
    int[] data;


    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }
    private void frontShow(){
        frontShwo(0);
    }

    private void frontShwo(int i){
        if(data.length<0 || data==null){
            return ;
        }
        System.out.println(data[i]);
        if((2*i+1)<data.length){
            frontShwo(2*i+1);
        }
        if((2*i+2)<data.length){
            frontShwo(2*i+2);
        }
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(ints);
        arrayBinaryTree.frontShow();
    }
}

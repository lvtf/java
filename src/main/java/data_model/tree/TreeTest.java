package data_model.tree;

public class TreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        binaryTree.setRoot(root);
        root.setLeftNode(rootLeft);
        root.setRightNode(rootRight);
        rootLeft.setLeftNode(new TreeNode(4));
        TreeNode treeNode = new TreeNode(5);
        rootLeft.setRightNode(new TreeNode(5));
        rootRight.setLeftNode(new TreeNode(6));
        rootRight.setRightNode(new TreeNode(7));
        binaryTree.frontShow();
  /*      //前序遍历
        binaryTree.frontShow();
        System.out.println();
        //中序遍历
        binaryTree.middleShow();
        System.out.println();
        //后序遍历
        binaryTree.afterShow();*/
        TreeNode node = binaryTree.search(1);
        System.out.println(node + "----" + node.data);
        TreeNode node1 = binaryTree.search(2);
        System.out.println(node1 + "----" + node1.data);
        TreeNode node11 = binaryTree.search(4);
        System.out.println(node11 + "----" + node11.data);
//        binaryTree.delete(1);
        System.out.println("========");
//        binaryTree.treeNdodes();
        binaryTree.frontShow();
        System.out.println();
        System.out.println("========");
        binaryTree.middleShow();
        binaryTree.treeNdodes();
        binaryTree.treeNodesFrontIterator(root);
        binaryTree.treeNodesFront(root);
        System.out.println("==");

    }
}

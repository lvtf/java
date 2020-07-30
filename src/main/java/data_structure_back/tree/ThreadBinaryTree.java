package data_structure_back.tree;

/**
 * 线索二叉树
 */
public class ThreadBinaryTree {
    TreeNode root;

    //当前节点的前驱节点
    TreeNode prev;
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void treeNdodes() {
        treeNodes(root);
    }



    //前序遍历
    public void treeNodesFrontIterator(TreeNode node) {
        while (node!=null){
            //打印当前结点
            System.out.println(node);

            while (node.leftType==0){
                node=node.leftNode;
                System.out.println(node);
            }

            if (node.rightType==1){
                node=node.rightNode;
            }else if (node.rightNode==null){
                //线索化前序遍历的最后一个结点的right一定为null,所以遍历完毕 退出循环
                break;
            }


        }
    }
    /**
     *前序方式线索二叉树
     */
    public void treeNodesFront(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.leftNode == null) {
            node.leftNode = prev;
            node.leftType = 1;
        }

        if (prev != null && prev.rightNode == null) {
            prev.rightNode = node;
            prev.rightType = 1;
        }

        prev = node;
        if(node.leftType==0){
            treeNodesFront(node.leftNode);
        }
            treeNodesFront(node.rightNode);


    }

    private void treeNodes(){
        treeNodes(root);
    }
    /**
     * 中序线索化二叉树
     *
     * 每一个节点的前一个节点称为前驱节点
     * 每一个节点的后一个节点称为后继节点
     */

    private void treeNodes(TreeNode node) {
        //如果当前节点为null，直接返回，最最下角的叶子节点进来了，他的leftnode为null，下次循环再进来的时候直接return
        if (node == null) {
            return;
        }
        treeNodes(node.leftNode);
        //如果当前节点的左子树为null，那么让当前节点的左指针指向它的前驱节点（即指向它的父节点）
        if (node.leftNode == null) {
            //当前节点的左指针指向前驱节点
            node.leftNode = prev;
            //改变当前节点的指针类型
            node.leftType = 1;
        }

        //处理前驱节点的右节点，如果前驱节点没有右子树（为null）
        if (prev != null && prev.rightNode == null) {
            //前驱节点的右指针指向当前节点
            prev.rightNode = node;
            //前驱姐弟那的右指针类型改变
            prev.rightType = 1;
        }
        //每处理一个节点，当前节点是下个节点的前驱节点
        prev = node;
        treeNodes(node.rightNode);
    }
    /**
     * 中序遍历线索化二叉树
     * @param node
     */
    public void treeNodesIterator(TreeNode node) {
        while (node != null) {
            while (node.leftType == 0) {
                node = node.leftNode;
            }
            System.out.println(node.data);
            while (node.rightType == 1) {
                node = node.rightNode;
                System.out.println(node.data);
            }
            node = node.rightNode;
        }
    }


    public void delete(int i) {
        if (root.data == i) {
            root = null;
        } else {
            root.delete(i);
        }
    }

    public TreeNode search(int i) {
        return root.search(i);
    }

    public void afterShow() {
        if (root != null) {

            root.afterShow();
        }
    }

    public void middleShow() {
        if (root != null) {
            root.middleShow();
        }
    }

    public void frontShow() {
        if (root != null) {
            root.frontShow();
        }
    }





}

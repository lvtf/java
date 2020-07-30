package data_structure_back.tree;


/**
 * 链表二叉树
 */
public class BinaryTree {
    TreeNode root;

    //当前节点的前驱节点
    TreeNode prev;


    public void treeNdodes() {
        treeNodes(root);
    }

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


    //前序遍历
    public void treeNodesFrontIterator(TreeNode node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.leftNode;
            while (node.leftType == 1) {
                System.out.println(node.data);
                node = node.rightNode;
            }

        }
    }
    //前序方式线索二叉树
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
        if(node.leftType==1){
            treeNodesFront(node.leftNode);
        }
        if(node.rightType==1) {
            treeNodesFront(node.rightNode);
        }


    }

    //以中序的方式处理所有的节点
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



    public void setRoot(TreeNode root) {
        this.root = root;
    }




}

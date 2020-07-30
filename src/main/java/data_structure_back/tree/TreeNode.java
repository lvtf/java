package data_structure_back.tree;

public class TreeNode {
    TreeNode leftNode;
    TreeNode rightNode;
    int data;
    //当前节点的左右节点是左右子树还是前驱节点
    int leftType;
    int rightType;

    public TreeNode(int i) {
        this.data = i;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void frontShow() {
        System.out.print(data);
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    public void middleShow() {
        if (leftNode != null) {
            leftNode.frontShow();
        }
        System.out.print(data);
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    public void afterShow() {
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }
        System.out.print(data);
    }

    public TreeNode search(int i) {
        TreeNode target = null;
        if (this.data == i) {
            return this;
        }

        if (leftNode != null) {
            target = leftNode.search(i);
        }
        if (target != null) {
            return target;
        }
        if (rightNode != null) {
            target = rightNode.search(i);
        }

        return target;
    }

    public void delete(int i) {
        TreeNode parent = this;
        if (parent.leftNode != null && parent.leftNode.data == i) {
            parent.leftNode = null;
            return;
        } else {
            parent.leftNode.delete(i);
        }
        if (parent.rightNode != null && parent.rightNode.data == i) {
            parent.rightNode = null;
            return;
        } else {
            parent.rightNode.delete(i);
        }
    }
}

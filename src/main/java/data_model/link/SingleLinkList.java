package data_model.link;

public class SingleLinkList {
    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }

        Node() {
        }
    }

    Node head = null;

    public void addHead(int elem) {
        Node node = new Node(elem);
        node.next=head;
        head=node;

    }

    public void print() {
        Node currNode = head;
        while (currNode.next != null) {
            System.out.print(currNode.data);
            currNode = currNode.next;
        }
        System.out.print(currNode.data);
    }

    public void addLast(int elem){
        Node node = new Node(elem);
        Node temp =head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }

    public void insertIndex(int index,int elem){
        Node temp=head;
        Node node = new Node(elem);
        int len=0;
        while (temp.next!=null){
            len++;
            temp=temp.next;
            if(len==index){
                node.next=temp.next;
                temp.next=node;
            }
        }
    }
    public void length(){
        Node currNode =head;
        int len=1;
        while (currNode.next!=null){
            currNode=currNode.next;
            len++;
        }
        System.out.println(len);
    }

    public void getIndex(int index){
        int len =0;
        Node temp =head;
        while (temp.next!=null){
            temp=temp.next;
            len++;
            if(len==index){
                System.out.println(temp.data);
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkList linkList = new SingleLinkList();
        linkList.addHead(1);
        linkList.addHead(2);
        linkList.addLast(3);
        linkList.insertIndex(1,4);
        linkList.print();
        System.out.println();
        linkList.length();
        linkList.getIndex(2);
    }


}

package data_structure;

public class Link {
    private Node head = null;

    static class Node {
        Node next = null;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    private void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    private void deleteNode(){

    }



    @Override
    public String toString() {
        return "Link{" +
                "head=" + head +
                '}';
    }

     private void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }


    public static void main(String[] args) {
        Link link = new Link();
        link.append(1);
        System.out.println(link);
        link.print();
    }
}

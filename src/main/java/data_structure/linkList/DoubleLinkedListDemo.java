package data_structure.linkList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addOrderNo(hero1);
        doubleLinkedList.addOrderNo(hero2);
        doubleLinkedList.addOrderNo(hero4);
        doubleLinkedList.addOrderNo(hero3);
        doubleLinkedList.addOrderNo(hero3);
        doubleLinkedList.list();
        System.out.println("===================");
        doubleLinkedList.update(new HeroNode2(4, "林冲2", "豹子头"));
        doubleLinkedList.list();
        System.out.println("===================");
        doubleLinkedList.delete(new HeroNode2(4, "林冲2", "豹子头"));
        System.out.println("===================");
        doubleLinkedList.list();
        System.out.println("===================");


    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void addOrderNo(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        Boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("编号已经存在%d\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    public void delete(HeroNode2 heroNode) {
        HeroNode2 tmp = head.next;
        boolean flag = false;
        while (tmp != null) {
            if (tmp.no == heroNode.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            if (tmp.prev != null) {
                tmp.prev.next = tmp.next;
            }
            if (tmp.next != null) {
                tmp.next.prev = tmp.prev;
            }
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能删除\n", heroNode.no);
        }
    }

    public void update(HeroNode2 heroNode) {
        HeroNode2 tmp = head.next;
        Boolean flag = false;
        while (tmp != null) {
            if (tmp.no == heroNode.no) {
                flag = true;
                break;
            }
            if (tmp == null) {
                return;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.name = heroNode.name;
            tmp.nickName = heroNode.nickName;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
        }
    }

    public void add(HeroNode2 herNode) {
        HeroNode2 tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            } else {
                tmp = tmp.next;
            }
        }
        tmp.next = herNode;
        herNode.prev = tmp;
    }

    public void list() {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

class HeroNode2 {
    int no;
    String name;
    String nickName;
    HeroNode2 next;
    HeroNode2 prev;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +

                '}';
    }
}

package data_structure.linkList;


public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();
        HeroNode newHerNode = new HeroNode(4, "林冲chong", "豹子小头");
        HeroNode newHerNode2 = new HeroNode(5, "林冲chong", "豹子小头");
        System.out.println("=======");
        singleLinkedList.update(newHerNode);
        singleLinkedList.update(newHerNode2);
        singleLinkedList.list();
        System.out.println("=========");
        singleLinkedList.remove(4);
        singleLinkedList.remove(5);
        singleLinkedList.list();
        System.out.println(getLength(singleLinkedList.getHead()));

        System.out.println(findLastIndexHeroNode(singleLinkedList.getHead(), 1));
    }

    public static HeroNode findLastIndexHeroNode(HeroNode head,int index){
        if(head.next==null){
            System.out.printf("empty");
        }
        int size = getLength(head);
        HeroNode currNode =head.next;
        if(index<0 || index>size){
            System.out.printf("超出范围");
        }
        for (int i = 0; i < size - index; i++) {
            currNode=currNode.next;
        }
        return currNode;
    }
    public static  int getLength(HeroNode head){
        if(head.next==null){
            System.out.printf("empty");
            return 0;
        }
        HeroNode currNode =head.next;
        int len =0;
        while (currNode!=null){
            currNode=currNode.next;
            len++;
        }
        return len;
    }
    static class SingleLinkedList {
        private HeroNode head = new HeroNode(0, "", "");

        public HeroNode getHead() {
            return head;
        }



        public void remove(int no){
            HeroNode temp = head;
            Boolean flag=false;
            while (true){
                if(temp.next==null){
                    break;
                }else if(temp.next.no==no){
                    flag=true;
                    break;
                }
                temp =temp.next;
            }
            if(flag){
                temp.next=temp.next.next;
            }else {
                System.out.printf("没有找到%d\n",no);
            }
        }
        public void update(HeroNode newHerNode){
            HeroNode temp = head.next;
            Boolean flag=false;
            while (true){
                if(temp==null){
                    break;
                }else if(temp.no==newHerNode.no){
                    flag=true;
                    break;
                }
                temp=temp.next;
            }
            if(flag){
                temp.name=newHerNode.name;
                temp.nickName=newHerNode.nickName;
            }else {
                System.out.printf("没有找到编号为%d\n",newHerNode.no);
            }
        }
        public void add(HeroNode herNode) {
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = herNode;
        }

        public void addByOrder(HeroNode heroNode) {
            HeroNode temp = head;
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

        public void list() {
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
                System.out.println(temp);
            }
        }



    }



    static class HeroNode {
        int no;
        String name;
        String nickName;
        HeroNode next;

        public HeroNode(int no, String name, String nickName) {
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
}




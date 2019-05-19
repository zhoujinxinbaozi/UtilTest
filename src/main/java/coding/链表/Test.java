package coding.链表;

public class Test {
    public static void main(String[] args) {
        Entity head = init();
        print(head,"first print");
        head = reverseList(head);
        print(head,"second print");
    }

    // 就地反转法
    public static Entity reverseList(Entity head) {
        if (head == null)
            return head;
        Entity dummy = new Entity(-1);
        dummy.next = head;
        Entity prev = dummy.next;
        Entity pCur = prev.next;
        while (pCur != null) {
            prev.next = pCur.next;  // prev 连接下一次要反转的节点
            pCur.next = dummy.next;  // 反转节点pCur
            dummy.next = pCur;       // 纠正头结点dummy的指向
            pCur = prev.next;        // pCur指向下一次要反转的节点
        }
        return dummy.next;
    }

    private static void print(Entity head, String exp) {
        System.out.println("=====" + exp + "=====");
        Entity dump = head;
        while(dump != null){
            System.out.print(dump.value + "\t");
            dump = dump.next;
        }
        System.out.println();
    }

    private static Entity init() {
        Entity head = new Entity(1);
        Entity n1 = new Entity(2);
        Entity n2 = new Entity(3);
        Entity n3 = new Entity(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        return head;

    }
}

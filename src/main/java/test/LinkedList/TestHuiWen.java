package test.LinkedList;

public class TestHuiWen {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(1);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        TestHuiWen th = new TestHuiWen();
        System.out.println(th.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        int count = 0;
        while(tmp != null){
            tmp = tmp.next;
            count ++;
        }

        if((count & 1) == 1){
            count = count/2 + 1;
        }else{
            count = count/2;
        }
        System.out.println("count = " + count);

        ListNode tt = head;
        while(count != 0){
            tt = tt.next;
            count --;
        }

        while(tt != null && head != null){
            System.out.println(String.format("tt=%s, head=%s", tt.val,head.val));
            if(tt.val != head.val){
                return false;
            }
            tt = tt.next;
            head = head.next;
        }
        return true;
    }
}

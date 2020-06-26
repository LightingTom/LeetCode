public class Day7 {
    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode ptr1 = head.next;
        ListNode ptr1_prev = head;
        while (ptr1 != null){
            ListNode ptr2 = head;
            boolean find = false;
            while (ptr2 != ptr1){
                if (ptr2.val == ptr1.val){
                    ptr1_prev.next = ptr1.next;
                    ptr1.next = null;
                    ptr1 = ptr1_prev.next;
                    find = true;
                    break;
                }
                ptr2 = ptr2.next;
            }
            if (!find) {
                ptr1_prev = ptr1;
                ptr1 = ptr1.next;
            }
        }
        return head;
    }
//easy linked list
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        ListNode g = removeDuplicateNodes(a);
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){this.val = val;}
}

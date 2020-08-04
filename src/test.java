import java.util.Arrays;

public class test {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode(0);
        ans.val = (l1.val + l2.val) % 10;
        carry = (l1.val + l2.val) / 10;
        ListNode head = ans;
        while(l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            int result = l1.val + l2.val + carry;
            carry = result / 10;
            ans.next = new ListNode(result % 10);
            ans = ans.next;
        }
        while(l1.next != null){
            l1 = l1.next;
            int result = l1.val + carry;
            carry = result / 10;
            ans.next = new ListNode(result % 10);
            ans = ans.next;
        }
        while(l2.next != null){
            l2 = l2.next;
            int result = l2.val + carry;
            carry = result / 10;
            ans.next = new ListNode(result % 10);
            ans = ans.next;
        }
        ans.next = (carry == 0)?null:new ListNode(carry);
        return head;
    }

}

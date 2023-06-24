public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode head = res;
        int temp = 0;
        while(l1 != null || l2 != null || temp != 0){
            if(l1 != null && l2 != null){
                temp = temp + l1.val + l2.val ;
                l1 = l1.next;
                l2 = l2.next;
            }else{
                if(l1 != null){
                    temp = temp + l1.val;
                    l1 = l1.next;
                }
                if(l2 != null){
                    temp = temp + l2.val ;
                    l2 = l2.next;
                }
            }
            if(l1 != null || l2 != null ){
                if(temp < 10){
                    head.val = temp;
                    temp = 0;
                }else{
                    head.val = temp % 10;
                    temp = temp / 10;
                }
                head.next = new ListNode();
                head = head.next;
            }else if(temp != 0){
                if(temp < 10){
                    head.val = temp;
                }else{
                    head.val = temp % 10;
                    head.next = new ListNode(temp / 10);
                }
                break;
            }else{
                break;
            }
        }
        return res;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(S.addTwoNumbers(l1, l2));
    }
}
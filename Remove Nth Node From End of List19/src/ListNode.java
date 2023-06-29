public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 1;
        head = reserve(head);
        ListNode ans = head;
        if(n == 1){
            ans = head.next;
            return reserve(ans);
        }else{
            while(i < n - 1){
                head = head.next;
                i++;
            }
        }

        if(head.next != null && head.next.next == null){
            head.next = null;
            ans = reserve(ans);
        }else if(head.next != null && head.next.next != null){
            head.next = head.next.next;
            ans = reserve(ans);
        }else{
            ans = null;
        }
        return ans;
    }

    public ListNode reserve(ListNode head){
        ListNode res = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        s.removeNthFromEnd(node,2);
    }
}
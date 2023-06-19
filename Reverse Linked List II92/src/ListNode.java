public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode list = new ListNode(0);
        list.next = head;
        ListNode pre = list;
        for(int i = 1; i < left; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = left; i < right; i++){
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return list.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution S = new Solution();
        ListNode res = S.reverseBetween(head, 2, 4);
//        head = S.ListNodeReserve(head);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
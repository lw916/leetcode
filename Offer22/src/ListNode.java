
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
class Solution {
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        head = reserve(head);
//        ListNode res = head;
//        ListNode temp = res;
//        int i = 0;
//        while( i < k){
//            temp.next = head.next;
//            temp = temp.next;
//            head = head.next;
//            i++;
//        }
//        temp.next = null;
//        res = reserve(res);
//        return res;
//    }
//
//    public ListNode reserve(ListNode root){
//        ListNode current = null;
//        while(root != null){
//            ListNode temp = root.next;
//            root.next = current;
//            current = root;
//            root = temp;
//        }
//        return current;
//    }

    // 双指针做法
    // 让快指针比慢指针快k个数，当快指针到末尾时返回慢指针即可
    public ListNode getKthFromEnd(ListNode head, int k){
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
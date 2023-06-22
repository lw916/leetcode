public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// 解决思路： 快慢指针找中间节点，分开成两个链表后一个链表反转
// 链表大杂烩
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        right = reserveListNode(right);
        head = mergeListNode(right,left);
    }

    public ListNode reserveListNode(ListNode head){
        ListNode current = null;
        while(head != null){
           ListNode temp = head.next;
           head.next = current;
           current = head;
           head = temp;
        }
        return current;
    }

    public ListNode mergeListNode(ListNode right, ListNode left){
        ListNode temp = new ListNode(-1);
        ListNode ans = temp;
        while(left != null || right != null){
            if(left != null){
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
            if (right != null) {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        return ans.next;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        ListNode tmp = new ListNode(1);
        tmp.next = new ListNode(2);
        tmp.next.next = new ListNode(3);
        tmp.next.next.next = new ListNode(4);
        tmp.next.next.next.next = new ListNode(5);
        S.reorderList(tmp);
    }
}
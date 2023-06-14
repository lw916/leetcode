import java.util.Arrays;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        int[] nums = new int[5000];
        int length = 0;
        while(head != null){
            nums[length] = head.val;
            length++;
            head = head.next;
        }
        ListNode newNode = new ListNode(nums[length - 1]);
        length -= 2;
        ListNode root = newNode;
        while(length >= 0){
            newNode.next = new ListNode(nums[length]);
            length --;
            newNode = newNode.next;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node = S.reverseList(node);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
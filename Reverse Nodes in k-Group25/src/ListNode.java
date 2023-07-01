
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode(-1);
        ListNode root = ans;
        while(head != null){
            int count = 0;
            ListNode temp = new ListNode(-1);
            ListNode tempHead = temp;
            tempHead.next = head;
            for(int i = 0; i < k; i++){
                if(head != null){
                    tempHead = tempHead.next;
                    head = head.next;
                    count++;
                }else{
                    break;
                }
            }
            tempHead.next = null;
            if (count == k) {
                temp = reserve(temp.next);
                root.next = temp;
                for(int i = 0; i < k; i++){
                    root = root.next;
                }
            }else{
                root.next = temp.next;
                break;
            }
        }
        return ans.next;
    }

    public ListNode reserve(ListNode root){
        ListNode head = null;
        while(root != null){
            ListNode temp = root.next;
            root.next = head;
            head = root;
            root = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        s.reverseKGroup(node, 2);
    }
}
import java.util.HashMap;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){ return null; }
        ListNode result = new ListNode(0, head); // 一定要有第一个无关的数字作为链表头，才可让后续进行对比
        ListNode pointer = result;
        while(pointer.next != null && pointer.next.next != null){
            if(pointer.next.val == pointer.next.next.val){
                int temp = pointer.next.val;
                while(pointer.next != null && pointer.next.val == temp){
                    pointer.next = pointer.next.next;
                }
            }else{
                pointer = pointer.next;
            }
        }
        return result.next;
    }
}
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeLinkList(ans, list);
        }
        return ans;
    }

    public ListNode mergeLinkList(ListNode list1, ListNode list2){
        if(list1 == null || list2 == null){
            return list1 != null ? list1 : list2;
        }
        ListNode root = new ListNode(-1);
        ListNode head = root;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                head.next = list1;
                list1 = list1.next;
            } else{
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        head.next = (list1 != null ? list1 : list2);
        return root.next;
    }
}
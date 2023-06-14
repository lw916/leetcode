
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }else{
            ListNode node = new ListNode();
            ListNode head = node;
            while(true){
                if(list1 != null && list2 != null){
                    if(list1.val >= list2.val){
                        node.val = list2.val;
                        node.next = new ListNode();
                        node = node.next;
                        list2 = list2.next;
                    }else{
                        node.val = list1.val;
                        node.next = new ListNode();
                        node = node.next;
                        list1 = list1.next;
                    }
                }else if(list1 != null && list2 == null){
                    if(list1.next != null){
                        node.val = list1.val;
                        node.next = new ListNode();
                        node = node.next;
                        list1 = list1.next;
                    }else{
                        node.val = list1.val;
                        list1 = list1.next;
                    }
                }else if(list1 == null && list2 != null){
                    if(list2.next != null){
                        node.val = list2.val;
                        node.next = new ListNode();
                        node = node.next;
                        list2 = list2.next;
                    }else{
                        node.val = list2.val;
                        list2 = list2.next;
                    }
                }else{
                    break;
                }
            }
            return head;
        }
    }
}
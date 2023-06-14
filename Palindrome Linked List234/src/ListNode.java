import java.util.Arrays;
import java.util.HashMap;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }
        StringBuilder sbFront = new StringBuilder();
        StringBuilder sbBack = new StringBuilder();
        StringBuilder wholeString = new StringBuilder();
        while(head != null){
            wholeString.append(head.val);
            head = head.next;
        }
        if(wholeString.length() % 2 == 0){
            sbFront.append(wholeString.substring(0,wholeString.length() / 2));
            sbBack.append(wholeString.substring(wholeString.length() / 2, wholeString.length())).reverse();
            return sbFront.toString().contentEquals(sbBack);
        }else{
            sbFront.append(wholeString.substring(0,wholeString.length() / 2 ));
            sbBack.append(wholeString.substring(wholeString.length() / 2 + 1, wholeString.length())).reverse();
            return sbFront.toString().contentEquals(sbBack);
        }
    }

    // 用数组解决:
    public boolean isPalindrome2(ListNode head){
        if(head.next == null){
            return true;
        }
        int[] num = new int[10000];
        int i = 0;
        int count = 0;
        int j =0;
        while(head != null){
            num[i++] = head.val;
            count++;
            head = head.next;
        }
        int length = count / 2;
        while( j != length){
            if(num[j++] != num[--count]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(1);
//        ListNode head4 = new ListNode(1);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
//        head3.next = head4;
        System.out.println(S.isPalindrome2(head));
    }
}
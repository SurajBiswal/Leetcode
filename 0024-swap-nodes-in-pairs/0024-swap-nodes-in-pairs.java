/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode node1 = head;
        ListNode prev = head;
        ListNode node2 = head.next;
        ListNode ans = head.next;
        while(node1!=null && node2!=null){
            prev = node1;
            node1.next = node2.next;
            node2.next = node1;
            if(node1.next == null || node1.next.next == null) break;
            node2 = node1.next.next;
            node1 = node1.next;
            prev.next = node2;
        }
        return ans;
    }
}
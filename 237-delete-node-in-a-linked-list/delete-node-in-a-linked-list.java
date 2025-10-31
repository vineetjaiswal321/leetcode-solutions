/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //5 -> Given
        //4 -> 5 -> 7 -> 9 -> 13
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
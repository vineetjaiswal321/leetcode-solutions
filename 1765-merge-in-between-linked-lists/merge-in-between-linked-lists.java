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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode h1=list1;
        for(int i=1;i<a;i++)   h1=h1.next;
        ListNode h2=h1;
        for(int i=a;i<=b+1;i++)   h2=h2.next;
        h1.next=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=h2;
        return list1;
    }
}
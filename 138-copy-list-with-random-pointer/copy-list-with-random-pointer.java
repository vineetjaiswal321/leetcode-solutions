/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //Insert copy node in between 
        Node temp=head;
        while(temp!=null){
            Node copyNode=new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=temp.next.next;
        }

        //Connect random pointer
        temp=head;
        while(temp!=null){
            Node rnd=temp.random;
            if(rnd!=null)  temp.next.random=rnd.next;
            temp=temp.next.next;
        }

        //Connect next pointer of copy node
        temp=head;
        Node dummy=new Node(-1), res=dummy;
        while(temp!=null){
            dummy.next=temp.next;
            temp.next=temp.next.next;
            temp=temp.next;
            dummy=dummy.next;
        }
        return res.next;
    }
}
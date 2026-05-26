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
        HashMap<Node, Node> oldToCopy = new HashMap<>();

        Node curr = head;

        // 1. Create copies of every node
        while (curr != null) {
            Node copy = new Node(curr.val);
            oldToCopy.put(curr, copy);
            curr = curr.next;
        }
        
        curr = head;

        // 2. Connect next and random pointers
        while (curr != null) {
            Node copy = oldToCopy.get(curr);

            copy.next = oldToCopy.get(curr.next);
            copy.random = oldToCopy.get(curr.random);

            curr = curr.next;
        }

        return oldToCopy.get(head);
    }
}

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
        Map<Node, Node> map = new HashMap<>();

        Node prev = null;
        Node first = head;
        Node startList = null;
        while (first != null) {
            Node newNode = new Node(first.val);
            if (prev != null)
                prev.next = newNode;
            else {
                startList = newNode;
            }
            map.put(first, newNode);
            prev = newNode;

            first = first.next;
        }
        first = startList;
        while (head != null) {
            if (head.random == null) {
                startList.random = null;
            } else {
                startList.random = map.get(head.random);
            }
            head = head.next;
            startList = startList.next;
        }
        return first;
    }
}

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
        Map<Node, Integer> fmap = new HashMap<>();
        Map<Integer, Node> nmap = new HashMap<>();

        Node prev = null;
        Node first = head;
        Node startList = null;
        int length = 0;
        while (first != null) {
            fmap.put(first, length);
            Node newNode = new Node(first.val);
            if (prev != null)
                prev.next = newNode;
            else {
                startList = newNode;
            }
            nmap.put(length, newNode);

            length++;
            prev = newNode;

            first = first.next;
        }
        first = startList;
        while (head != null) {
            if (head.random == null) {
                startList.random = null;
            } else {
                int pos = fmap.get(head.random);

                startList.random = nmap.get(pos);
            }
            head = head.next;
            startList = startList.next;
        }
        return first;
    }
}

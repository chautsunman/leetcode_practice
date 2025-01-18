package topinterview150.linkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fasterNode = head;
        ListNode slowerNode = head;
        while (fasterNode != null && fasterNode.next != null) {
            fasterNode = fasterNode.next.next;
            slowerNode = slowerNode.next;
            if (fasterNode == slowerNode) {
                return true;
            }
        }
        return false;

        // final Set<Integer> visited = new HashSet();
        // while (head != null) {
        //     if (visited.contains(head.val)) {
        //         return true;
        //     }
        //     visited.add(head.val);
        //     head = head.next;
        // }
        // return false;
    }
}

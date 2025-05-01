package _141;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creates a cycle

        System.out.println(hasCycle(head)); // Output: true
    }
    
    /* My method (modified) */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode tempNode = head;
        while(tempNode != null) {
            if(set.contains(tempNode)) {
                return true;
            }
            set.add(tempNode);
            tempNode = tempNode.next;
        }
        return false;
    }

    /* Solution (Slow Fast Pointers) */
    // public static boolean hasCycle(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return false;
    //     }

    //     ListNode slow = head;
    //     ListNode fast = head.next;

    //     while (slow != fast) {
    //         if (fast == null || fast.next == null) {
    //             return false;
    //         }
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }

    //     return true;
    // }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
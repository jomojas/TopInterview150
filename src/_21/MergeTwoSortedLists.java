package _21;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = solution.mergeTwoLists(l1, l2);
        printList(mergedList);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/* My method */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        else if(list2 == null) return list1;
        ListNode tempi = (list1.val <= list2.val) ? list1 : list2;
        ListNode tempj = (list1.val > list2.val) ? list1 : list2;
        ListNode temp;
        
        while(tempj != null) {
            // if(tempi.val == tempj.val || (tempi.val < tempj.val && tempi.next == null) || (tempi.val < tempj.val && tempi.next.val > tempj.val)) {
            //     temp = tempj;
            //     tempj = temp.next;
            //     temp.next = tempi.next;
            //     tempi.next = temp;
            //     tempi = temp;
            // } else {
            //     tempi = tempi.next;
            // }
            /* Revised by GPT */
            if (tempi.next == null || tempi.next.val > tempj.val) {
                temp = tempj;
                tempj = temp.next;
                temp.next = tempi.next;
                tempi.next = temp;
                tempi = temp;
            } else {
                tempi = tempi.next;
            }
        }
        return (list1.val <= list2.val) ? list1 : list2;
    }
}

/* Solution */
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode dummy = new ListNode();
//         ListNode cur = dummy;

//         while (list1 != null && list2 != null) {
//             if (list1.val > list2.val) {
//                 cur.next = list2;
//                 list2 = list2.next;
//             } else {
//                 cur.next = list1;
//                 list1 = list1.next;
//             }
//             cur = cur.next;
//         }

//         cur.next = (list1 != null) ? list1 : list2;

//          return dummy.next;        
//     }
// }
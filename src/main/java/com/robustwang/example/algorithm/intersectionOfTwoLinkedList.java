package com.robustwang.example.algorithm;

public class intersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ap = headA, bp = headB;
        while (ap != bp) {
            ap = ap == null ? headB : ap.next;
            bp = bp == null ? headA : bp.next;
        }
        return ap;
    }
}

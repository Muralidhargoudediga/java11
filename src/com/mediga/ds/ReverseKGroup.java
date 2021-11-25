package com.mediga.ds;

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 2; i < 6; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        reverseKGroup(head, 2);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        //Deque<ListNode> stack = new LinkedList<>();
        ListNode temp = head;
        int i = 1;
        while(i < k && temp != null && temp.next != null) {
            temp = temp.next;
            i++;
        }
        if(i < k) {
            return head;
        }
        ListNode prev = reverseKGroup(temp.next, k);
        temp.next = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

       /* while(true){
             for(int i = 0; i < k; i++) {
                if(temp == null) {
                    return dummy.next;
                }
                stack.addFirst(temp);
                temp = temp.next;
            }
            while(!stack.isEmpty()) {
                iter.next = stack.pop();
                iter = iter.next;
            }
            iter.next = temp;
        }*/
    }

}

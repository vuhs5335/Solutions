package com.hersa.solution.sum;


import java.math.BigInteger;

class Solution1 {
    public static void main(String[] args){
        ListNode n1 = new ListNode(9);
        //n1.next = new ListNode(4);
        //n1.next.next = new ListNode(9);

        ListNode n2 = new ListNode(1);

        n2.next = new ListNode(9);
        n2.next.next = new ListNode(9);
        n2.next.next.next = new ListNode(9);
        n2.next.next.next.next = new ListNode(9);
        n2.next.next.next.next.next = new ListNode(9);
        n2.next.next.next.next.next.next = new ListNode(9);
        n2.next.next.next.next.next.next.next = new ListNode(9);
        n2.next.next.next.next.next.next.next.next = new ListNode(9);
        n2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        n2.next.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode sol =  addTwoNumbers(n1, n2);
        System.out.println(sol);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuffer sb = new StringBuffer();

        BigInteger int1 = BigInteger.ZERO;
        BigInteger int2 = BigInteger.ZERO;

        reverseNode(l1, sb);

        int1 = new BigInteger(sb.toString());

        sb = new StringBuffer();

        reverseNode(l2, sb);

        int2 = new BigInteger(sb.toString());

        BigInteger sum = int1.add(int2);

        String ssum = String.valueOf(sum);

        String[] arr = ssum.split("");

        ListNode solution = null;

        for(int i = arr.length - 1; i >= 0; i--){
            int val = Integer.valueOf(arr[i]);
           solution =  addRecursive(solution, val);
        }

        return solution;
    }

    private static void reverseNode(ListNode node, StringBuffer sb){
        if(node != null){

            if(node.next == null){
                sb.append(node.val);
                return;
            }

            reverseNode(node.next, sb);
            sb.append(node.val);
        }
    }

    public static ListNode addRecursive(ListNode node , int val){
        if(node == null){
            return new ListNode(val);
        }

        node.next = addRecursive(node.next, val);
        return node;
    }
}

 class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
package com.hzq.demo.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * @author HZQ
 * @Date: 2021/11/2
 * @Time: 2:39 下午
 * @description
 */
public class TestListNode {





    public static int getDepth(String str) {
        Stack<Character> stack = new Stack<>();
        int depth = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                depth = Math.max(depth, stack.size());
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return -1;
                }
            }
        }
        return stack.isEmpty() ? depth : -1;
    }

    public static void main(String[] args) {
        System.out.println(getDepth("()")); // 1
        System.out.println(getDepth("(()(()))")); // 3
        System.out.println(getDepth("())()")); // -1
    }


    public ListNode reverseKGroup(ListNode head, int k) {


        ListNode pre=null;
        ListNode current=head;

        ListNode result=null;
        ListNode resultTail=null;

        while (current.next!=null){
            for (int i = 0; i < k; i++) {
                ListNode next=current.next;
                current.next=pre;
                pre= current;
                current=next;
            }
            if(result == null){
                result=pre;
                resultTail=head;
            }else {
                resultTail.next=pre;
            }
            pre=null;

        }
        return null;
    }



    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(Objects.isNull(head) || left==right){
            return head;
        }
        int index=1;
        //设置反转链表
        ListNode temp;

        ListNode current=head;

        ListNode res=null;
        while (current.next != null){
            if(index>=left){
                res=current.next;

            }
            index++;
            current=current.next;
        }

        return null;

    }

    public ListNode reverseList(ListNode head) {
        ListNode current=head;

        ListNode result=null;
        while (current.next !=null){
            ListNode temp=current.next;
            result=current;

            current=temp;
        }

        return result;
    }




    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

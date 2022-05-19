package com.hzq.demo.leetcode;

import java.util.Objects;

/**
 * @author HZQ
 * @Date: 2021/11/2
 * @Time: 2:39 下午
 * @description
 */
public class TestListNode {


    public static void main(String[] args) {


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
            if(result=null){
                result=pre;
                resultTail=head
            }else {
                resultTail.next=pre;
            }
            pre=null;

        }

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

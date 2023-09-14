package com.hzq.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HZQ
 * @Date: 2021/11/4
 * @Time: 4:43 下午
 * @description  最近最少使用算法
 */ 
public class LRUCache {

    int capacity;

    Map<Integer,Node> valueMap;

    //头节点
    Node head;

    //尾节点
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        valueMap= new HashMap<Integer,Node>(capacity);
        Node temp=new Node(-1,-1);
        head=temp;
        tail=temp;
        head.next=temp;
        tail.pre=temp;
        valueMap.put(-1,temp);
    }

    public int get(int key) {
        if(valueMap.containsKey(key)){
            Node node = valueMap.get(key);
            if(node==head){
                return head.key;
            }
            Node pre = node.pre;
            if(node==tail){
                pre.next=null;
                tail=pre;
            }else {
                Node next = node.next;
                pre.next=next;
                next.pre=pre;
            }
            node.pre=null;
            node.next=head;
            head.pre=node;
            head=node;
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(valueMap.containsKey(key)){
            Node node = valueMap.get(key);
            if(node==head){
                head.value=value;
                return;
            }
            Node pre = node.pre;
            if(node==tail){
                pre.next=null;
                tail=pre;
            }else {
                Node next = node.next;
                pre.next=next;
                next.pre=pre;
            }
            node.pre=null;
            node.next=head;
            head.pre=node;
            head=node;
            return;
        }
        Node node = new Node(key,value);
        node.next=head;
        head.pre=node;
        head=node;
        if(valueMap.size()==capacity){
            valueMap.remove(tail.key);
            Node last= tail.pre;
            last.next=null;
            tail.pre=null;
            tail=last;
        }
        valueMap.put(key, node);
        System.out.println(valueMap.size());
    }

    class Node{
        int key;
        int value;
        Node next;

        Node pre;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }


    public int findKthLargest(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            for (int j=0;j<nums.length-1;j--){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums[nums.length-k];
    }

}

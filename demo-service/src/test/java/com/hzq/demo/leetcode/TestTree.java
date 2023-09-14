package com.hzq.demo.leetcode;

/**
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * @author HZQ
 * @description
 * @Date: 2020-12-15
 * @Time: 16:44
 */
public class TestTree {

    static int sumResult=0;

    public static void main(String[] args) {

        System.out.println();

        System.out.println(3%2);

        String s = "1234";
        System.out.println(s.substring(0,s.length()-1));
    }



    public static int sumNumbers(TreeNode root) {
        return sum(root,0);
    }

    public static int sum(TreeNode node,Integer current){
        if(node==null){
            return 0;
        }
        current=current *10 +node.val;
        if(node.left==null && node.right ==null){
            return current;
        }
        return sum(node.left, current)+sum(node.right, current);
    }






   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
   }
}

package com.hzq.test.algorithm;

import com.hzq.demo.model.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

/**
 * @author HZQ
 * @description
 * @Date: 2020-12-08
 * @Time: 16:49
 */
public class TreeTest {

    Node node=null;



    @Before
    public void setUp() throws Exception {
        Node node8 = new Node(8, null, null);
        Node node7 = new Node(7, null, node8);
        Node node9 = new Node(9, node7, null);

        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, node4, null);

        Node node2 = new Node(2, null, null);
        Node node1 = new Node(1, null, node2);

        Node node3 = new Node(3, node1, node5);

        Node node6 = new Node(6, node3, node9);
        node=node6;
    }

    /**
     * 先序遍历
     */
    @Test
    public void testFirst(){

        if(Objects.isNull(node)){
            System.out.print("不存在");
            return;
        }
        first(node);
    }

    public static void first(Node node){
        if (Objects.isNull(node)){
            return;
        }
        System.out.print(node.getDate());
        first(node.getLeft());
        first(node.getRight());
    }


    @Test
    public void testMiddle(){
        if(Objects.isNull(node)){
            System.out.print("不存在");
            return;
        }
        middle(node);

    }

    public static void middle(Node node){
        if (Objects.isNull(node)){
            return;
        }
        middle(node.getLeft());
        System.out.print(node.getDate());
        middle(node.getRight());
    }

    @Test
    public void always(){






    }


}

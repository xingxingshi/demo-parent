package com.hzq.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HZQ
 * @description
 * @Date: 2020-12-08
 * @Time: 17:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private Integer date;

    private Node left;

    private Node right;
}

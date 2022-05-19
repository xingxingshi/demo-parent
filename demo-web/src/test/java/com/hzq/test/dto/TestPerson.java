package com.hzq.test.dto;

import java.io.Serializable;

/**
 * @author HZQ
 * @description
 * @Date: 1/11/21
 * @Time: 2:25 PM
 */
public class TestPerson implements Serializable {

    private String name;
    private int age;
    //我不提供无参构造器
    public TestPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

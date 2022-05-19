package com.hzq.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author HZQ
 * @description
 * @Date: 1/11/21
 * @Time: 2:39 PM
 */
@Getter
@Setter
public class TestTeacher implements Serializable {

    private String name;
    private TestPerson person;

    public TestTeacher(String name, TestPerson person) {
        this.name = name;
        this.person = person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", person=" + person.toString() +
                '}';
    }

}

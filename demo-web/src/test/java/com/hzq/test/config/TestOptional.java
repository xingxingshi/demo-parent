package com.hzq.test.config;

import com.hzq.demo.model.auto.User;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * @author HZQ
 * @description
 * @Date: 2020-08-25
 * @Time: 16:05
 */
public class TestOptional {

    @Test(expected = NoSuchElementException.class)
    public void testOptional1(){
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void testOptional2(){
        Optional<User> emptyOpt = Optional.of(null);
        emptyOpt.get();
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);

        assertEquals("John", opt.get());
    }

    @Test
    public void testOptional3() {

        Optional<String> opt = Optional.ofNullable(null);
        if(opt.isPresent()){
            System.out.println(opt.get());
        }

        Optional<String> opt2 = Optional.ofNullable("test3");
        if(opt2.isPresent()){
            System.out.println(opt2.get());
        }
    }

    @Test
    public void testOptional4() {
        Object vvvv = Optional.ofNullable("vvvv").orElse("aaa");
        System.out.println(vvvv);

        Object ddd = Optional.ofNullable(null).orElse("ddd");
        System.out.println(ddd);

        Object ddda = Optional.ofNullable(null).orElseGet(()->"dddd"+"tgtg");
        System.out.println(ddda);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOptional5() {
        Object ddd = Optional.ofNullable(null).orElseThrow(() -> new IllegalArgumentException());
        System.out.println(ddd);
    }




}

package com.hzq.test.utils;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author HZQ
 * @description
 * @Date: 1/20/21
 * @Time: 3:43 PM
 */
public class MatchUtils {

    public static Predicate<Integer> matchType= p -> Objects.equals(p,1);

    public static Predicate<String> matchSource= p -> {
        if(Objects.equals(p,"a") || Objects.equals(p,"b")){
            return true;
        }
        return false;
    };


    public static void test(Predicate<String> predicate){
        predicate.test("");
    }
}

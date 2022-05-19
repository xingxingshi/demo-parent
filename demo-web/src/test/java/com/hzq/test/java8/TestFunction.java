package com.hzq.test.java8;

import com.hzq.test.interfaces.Bird;
import com.hzq.test.utils.MatchUtils;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToLongFunction;

/**
 * @author HZQ
 * @description
 * @Date: 1/20/21
 * @Time: 11:16 AM
 */
public class TestFunction {



    @Test
    public void test1(){

        Function<Integer,Integer> addfunc= p -> p+10;
        Integer apply = addfunc.apply(4);
        System.out.println(apply);

        Function<Integer,String> addfunc2= p ->  p+"hahahha";
        String apply2 = addfunc2.apply(4);
        System.out.println(apply2);

        Function<Integer,Integer> addfunc3= p -> {
            System.out.println("加法计算");
            return p+40;
        };
        Integer apply3 = addfunc3.apply(4);
        System.out.println(apply3);
    }

    @Test
    public void test2(){

        Consumer<String> consumer= p-> System.out.println(p);

        consumer.accept("iiii");
    }

    @Test
    public void test3(){

        Supplier<Integer> supplier=() ->100;
        System.out.println(supplier.get());



        Supplier<Bird> birdSupplier=Bird::new;
        Bird bird = birdSupplier.get();
        bird.fly();
        bird.swim();
    }

    @Test
    public void test4(){
        Predicate<Integer> integerPredicate=p-> p==10;

        System.out.println(integerPredicate.test(10));
        System.out.println(integerPredicate.test(11));


    }

    @Test
    public void test5(){
        ToLongFunction<String> stringToLongFunction= p->{
            System.out.println(p+"aaa");
            return Long.parseLong(p);
        };
        long aLong = stringToLongFunction.applyAsLong("5");
        System.out.println(aLong);
    }

    @Test
    public void testUtil(){

        boolean a = MatchUtils.matchSource.test("a");
        System.out.println(a);
        boolean c = MatchUtils.matchSource.test("c");
        System.out.println(c);

        boolean test = MatchUtils.matchType.test(1);
        System.out.println(test);

    }




}

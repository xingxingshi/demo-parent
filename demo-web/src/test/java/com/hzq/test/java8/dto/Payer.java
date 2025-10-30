package com.hzq.test.java8.dto;

import java.util.Queue;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/4/11 16:46
 * @Version: 1.0
 */
public class Payer {

    /**
     * 姓名
     */
    private String name;

    /**
     * 钱
     */
    private String money;

    /**
     * 重量
     */
    private Integer weight;

    private Payer(PayerBuilder payerBuilder){
        this.name=payerBuilder.name;
        this.money=payerBuilder.money;
        this.weight = payerBuilder.weight;
    }

    public static PayerBuilder beginBuild(){
        return new PayerBuilder();
    }

    public String print(){
        return name+money+weight;
    }

    public static class PayerBuilder{
        /**
         * 姓名
         */
        private String name;

        /**
         * 钱
         */
        private String money;

        /**
         * 重量
         */
        private Integer weight;

        public PayerBuilder name(String name){
            this.name=name;
            return this;
        }

        public PayerBuilder money(String money){
            this.money=money;
            return this;
        }

        public PayerBuilder weight(Integer weight){
            this.weight = weight;
            return this;
        }

        /**
         * 构造器最后返回对象
         * @return
         */
        public Payer build(){
            return new Payer(this);
        }

    }
}

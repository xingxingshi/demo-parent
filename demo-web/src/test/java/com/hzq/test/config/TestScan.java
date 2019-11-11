package com.hzq.test.config;

import com.alibaba.fastjson.JSON;
import com.hzq.demo.common.core.PageReqBase;
import com.hzq.test.BaseTest;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author HZQ
 * @description
 * @Date: 2019-11-11
 * @Time: 14:56
 */
public class TestScan extends BaseTest {


    @Test
    public void testJavaScan(){
        String basePackages="com.hzq.demo.control";
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                    .forPackages(basePackages)
                    //设置扫描类型 子类等 没有配置不能扫描
                    .addScanners(new SubTypesScanner())
                    .addScanners(new MethodAnnotationsScanner())
                    .addScanners(new FieldAnnotationsScanner()));

        //获取所带注解的类
        Set<Class<?>> typeClass = reflections.getTypesAnnotatedWith(RestController.class, false);
        System.out.println("获取所有带RestController注解的类");
        typeClass.forEach(e-> System.out.println(e.getName()));

        //获取所有带注解的方法
        Set<Method> methods = reflections.getMethodsAnnotatedWith(RequestMapping.class);
        System.out.println("获取所有带RequestMapping注解的方法");
        methods.forEach(e-> System.out.println(e.getName()));

        //获取子类
        Set<Class<? extends PageReqBase>> subTypesOf = reflections.getSubTypesOf(PageReqBase.class);
        System.out.println("获取所有PageReqBase的子类");
        subTypesOf.forEach(e-> System.out.println(e.getName()));

        //获取所有带注解的成员变量
        Set<Field> fields = reflections.getFieldsAnnotatedWith(Autowired.class) ;
        System.out.println("获取所有带Autowired注解的成员变量");
        fields.forEach(e-> System.out.println(e.getName()));

    }

    @Test
    public void testConfigScan(){
        String basePackages="";
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages(basePackages)
                .addScanners(new ResourcesScanner()));

        Set<String> properties = reflections.getResources(Pattern.compile(".*\\.yml"));

        System.out.println("获取配置");
        properties.forEach(e-> {
            System.out.println(e+"配置项如下");
            Yaml yaml = new Yaml();
            InputStream resourceAsStream = TestScan.class.getClassLoader().getResourceAsStream(e);
            Iterable<Object> objects = yaml.loadAll(resourceAsStream);
            System.out.println(1);
            objects.forEach(b-> System.out.println(b));
            System.out.println(2);
            objects.forEach(b-> System.out.println(JSON.toJSONString(b)));
            System.out.println(3);
            Map<String, String> map =(Map<String, String>)yaml.load(resourceAsStream);
            System.out.println(map);


            /*obj.forEach((k,v)->{

                System.out.println("配置项："+k +"-->值:"+v);
            });*/

        });
    }
}

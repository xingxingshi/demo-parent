package com.hzq.test.config;

import com.hzq.test.dto.TestPerson;
import com.hzq.test.dto.TestTeacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author HZQ
 * @description 测试序列化
 * https://www.cnblogs.com/9dragon/p/10901448.html
 * @Date: 1/11/21
 * @Time: 11:04 AM
 */
@Slf4j
public class TestSerial {

    @Test
    public void testSerial(){
        try (//创建一个ObjectOutputStream输出流
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testObject.txt"))) {
         //将对象序列化到文件s
            TestPerson person = new TestPerson("9龙", 23);
            oos.writeObject(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadSerial(){
        try (//创建一个ObjectInputStream输入流
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testObject.txt"))) {
            TestPerson brady = (TestPerson) ois.readObject();
            System.out.println(brady);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void multiplySerial(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"))) {
            TestPerson person = new TestPerson("路飞", 20);
            TestTeacher t1 = new TestTeacher("雷利", person);
            TestTeacher t2 = new TestTeacher("红发香克斯", person);
            //依次将4个对象写入输入流
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(person);
            oos.writeObject(t2);
            t2.setName("红发香克斯2.0");
            oos.writeObject(t2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readMultiplySerial(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"))) {
            TestTeacher t1 = (TestTeacher) ois.readObject();
            TestTeacher t2 = (TestTeacher) ois.readObject();
            TestPerson p = (TestPerson) ois.readObject();
            TestTeacher t3 = (TestTeacher) ois.readObject();
            TestTeacher t4 = (TestTeacher) ois.readObject();
            System.out.println(t1 == t2);
            System.out.println(t1.getPerson() == p);
            System.out.println(t2.getPerson() == p);
            System.out.println(t2 == t3);
            System.out.println(t2);
            System.out.println(t3);
            System.out.println(t1.getPerson() == t2.getPerson());

            System.out.println(t4);
            System.out.println(t2 == t4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

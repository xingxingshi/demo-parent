package com.hzq.demo.other;

import com.hzq.demo.util.CollectionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/8/22 22:26
 * @Version: 1.0
 */
public class OtherPathTest {

    public List<String> range = new ArrayList<>();

    public List<Triangle> triangles = new ArrayList<>();

    @Before
    public void before(){
        range.add("1,1");
        range.add("1,2");
        range.add("2,3");
        range.add("4,4");

        //两点成线，三点成面
        if(range.size() < 3) {
            throw new RuntimeException("参数不合法");
        }

        List<List<String>> triangleString  = CollectionUtil.findAllSubList(range, 3);
        for (List<String> strings : triangleString) {
            Triangle triangle = new Triangle(strings);
            System.out.println(triangle);
            triangles.add(new Triangle(strings));
        }
    }

    public class Triangle {

        /**
         * 第一个点经度
         */
        public double longitudeOne;

        /**
         * 第一个点纬度
         */
        public double latitudeOne;

        /**
         * 第二个点经度
         */
        public double longitudeTwo;

        /**
         * 第二个点纬度
         */
        public double latitudeTwo;

        /**
         * 第三个点经度
         */
        public double longitudeThree;

        /**
         * 第三个点纬度
         */
        public double latitudeThree;

        public Triangle() {
        }

        /**
         * 构造三角形坐标
         * @param locations
         */
        public Triangle(List<String> locations) {
            if(locations.size()!=3){
                throw new RuntimeException("参数不合法");
            }
            longitudeOne= new Double(locations.get(0).split(",")[0]);
            latitudeOne= new Double(locations.get(0).split(",")[1]);

            longitudeTwo= new Double(locations.get(1).split(",")[0]);
            latitudeTwo= new Double(locations.get(1).split(",")[1]);

            longitudeThree= new Double(locations.get(2).split(",")[0]);
            latitudeThree= new Double(locations.get(2).split(",")[1]);
        }


        @Override
        public String toString() {
            return "三角形第一个点坐标("+longitudeOne+","+latitudeOne+") 第二个点坐标("+longitudeTwo+","+latitudeTwo+") 第三个点坐标("+longitudeThree+","+latitudeThree+")";
        }

        /**
         * 是否在三角形内部 用向量乘积的方式
         *
         * @param longitude  经度 x
         * @param latitude  纬度  y
         * @return
         */
        public Boolean isInside(double longitude,double latitude){
            double crossOne= (longitudeTwo - longitudeOne)*(latitude -latitudeOne) - (latitudeTwo - latitudeOne) * (longitude - longitudeOne);
            double crossTwo= (longitudeThree - longitudeTwo)*(latitude -latitudeTwo) - (latitudeThree - latitudeTwo) * (longitude -longitudeTwo);
            double crossThree = (longitudeOne - longitudeThree)*(latitude -latitudeThree) - (latitudeOne - latitudeThree) * (longitude - longitudeThree);
            if((Math.abs(crossOne)+Math.abs(crossTwo)+Math.abs(crossThree)) == Math.abs(crossOne + crossTwo + crossThree)){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

    }



    @Test
    public void findInclude (){
        for (Triangle triangle : triangles) {
            if (triangle.isInside(2,6)){
                System.out.println("在里面");
                return;
            }
        }
        System.out.println("不在");
    }
}

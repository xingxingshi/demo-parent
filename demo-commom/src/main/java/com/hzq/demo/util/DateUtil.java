package com.hzq.demo.util;

import java.time.LocalDate;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/11/21 10:59
 * @Version: 1.0
 */
public class DateUtil {


    public static LocalDate addDate(int year ,int month,int day,int afterDays){
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.plusDays(afterDays);
    }
}

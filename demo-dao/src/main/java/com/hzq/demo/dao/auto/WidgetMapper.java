package com.hzq.demo.dao.auto;

import com.hzq.demo.model.auto.Widget;

public interface WidgetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Widget record);

    int insertSelective(Widget record);

    Widget selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Widget record);

    int updateByPrimaryKey(Widget record);
}
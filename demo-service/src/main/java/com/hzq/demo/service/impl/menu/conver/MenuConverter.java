package com.hzq.demo.service.impl.menu.conver;

import com.hzq.demo.model.auto.Menu;
import com.hzq.demo.model.dto.AuthMenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenuConverter {

    MenuConverter INSTANCE = Mappers.getMapper(MenuConverter.class);

    List<AuthMenuDTO> toAuthMenuDTOList(List<Menu> menus) ;


}

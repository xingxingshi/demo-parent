package com.hzq.demo.control.menu.converter;

import com.hzq.demo.control.menu.vo.AuthMenuVO;
import com.hzq.demo.model.dto.AuthMenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenuWebConverter {

    MenuWebConverter INSTANCE = Mappers.getMapper(MenuWebConverter.class);

    List<AuthMenuVO> toAuthMenuVO(List<AuthMenuDTO> authMenuDTO);

}



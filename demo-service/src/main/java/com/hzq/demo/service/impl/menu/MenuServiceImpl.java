package com.hzq.demo.service.impl.menu;

import com.hzq.demo.dao.auto.MenuMapper;
import com.hzq.demo.dao.ext.MenuExtMapper;
import com.hzq.demo.model.auto.Menu;
import com.hzq.demo.model.dto.AuthMenuDTO;
import com.hzq.demo.service.impl.menu.conver.MenuConverter;
import com.hzq.demo.service.menu.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-03
 * @Time: 18:44
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuExtMapper menuExtMapper;


    @Override
    public List<AuthMenuDTO> findAuthMenu() {

        List<Menu> menus = menuMapper.selectAllValidMenu();
        List<AuthMenuDTO> menuDTOList = MenuConverter.INSTANCE.toAuthMenuDTOList(menus);

        Map<Integer, List<AuthMenuDTO>> levelMenu = menuDTOList.stream().collect(Collectors.groupingBy(AuthMenuDTO::getLevel));

        return buildMenu(1,"000",levelMenu);
    }

    private List<AuthMenuDTO> buildMenu(int level,String code,Map<Integer, List<AuthMenuDTO>> levelMenu){
        if(CollectionUtils.isEmpty(levelMenu.get(level))){
            return null;
        }
        return levelMenu.get(level).stream()
                .filter(e -> Objects.equals(e.getParentCode(),code))
                .map(e ->{
                    e.setChildMenu(buildMenu(level +1,e.getCode(),levelMenu));
                    return e;
                })
                .sorted((x,y)->  x.getSort().compareTo(y.getSort()))
                .collect(Collectors.toList());
    }
}

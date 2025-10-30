package com.hzq.demo.control.common;

import com.hzq.demo.common.core.Result;
import com.hzq.demo.control.menu.converter.MenuWebConverter;
import com.hzq.demo.control.menu.vo.AuthMenuVO;
import com.hzq.demo.model.dto.AuthMenuDTO;
import com.hzq.demo.model.dto.SportsLotteryDTO;
import com.hzq.demo.service.common.ToolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2023/11/20 16:42
 * @Version: 1.0
 */
@RestController
@Api("工具相关接口")
@RequestMapping("/toolApi")
public class ToolApi {

    @Autowired
    private ToolService toolService;

}

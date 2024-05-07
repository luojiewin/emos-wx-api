package com.landx.emos.wx.controller;

import com.landx.emos.wx.entity.SysUser;
import com.landx.emos.wx.service.SysUserService;
import com.landx.emos.wx.util.MapperUtil;
import com.landx.emos.wx.util.R;
import com.landx.emos.wx.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户类")
public class user {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "获取用户姓名")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(
                    name = "userVo",
                    value = "用户页面信息",
                    required = true,
                    paramType = "query"
            )
    })
    @PostMapping("/updateUserName")
    public R updateUserName(@Valid @RequestBody UserVo userVo) {
        boolean updateByIdRet  = sysUserService.updateById(new MapperUtil().map(userVo,SysUser.class));
        log.info(String.valueOf(updateByIdRet));
        return R.ok();
    }
}

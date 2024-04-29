package com.landx.emos.wx.controller;

import com.landx.emos.wx.entity.SysUser;
import com.landx.emos.wx.service.SysUserService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class user {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/getName")
    public String getName(){
        String name;
        SysUser sysUser = sysUserService.getById(1);
        name = sysUser.getName();
        log.info(name);
        return name;
    }
}

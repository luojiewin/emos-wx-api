package com.landx.emos.wx.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserVo {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer age;
}

package com.landx.emos.wx.util;

/**
 * @Title: MapperUtil.java
 * @Description:
 * @author roger
 * @date 2019年7月23日
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

/**
 * @Title: MapperUtil
 * @Description: DTO与DAO相互转换
 * @author roger
 * @date 2019年7月23日
 */
public class MapperUtil {

    private ModelMapper modelMapper = new ModelMapper();

    public <T,V> T map(V v,Class<T> t) {
        return modelMapper.map(v, t);
    }


    public <T,V> List<T> map(List<V> lv,Class<T> t){
        if(lv==null) {
            return new ArrayList<T>();
        }
        List<T> result = new ArrayList<T>();
        for(V v : lv) {
            result.add(modelMapper.map(v,t));
        }
        return result;
    }
}

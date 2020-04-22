package com.lz.yr.second.service.Impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.yr.second.entity.AaInfo;
import com.lz.yr.second.mapper.AaMapper;
import com.lz.yr.second.service.AaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:49
 * version $Id: UserServiceImpl.java$
 */
@Service
public class AaServiceImpl extends ServiceImpl<AaMapper, AaInfo> implements AaService {

    @Autowired(required = false)
    private AaMapper aaMapper;

    @Override
    public AaInfo getByStu(String stu) {
        AaInfo aaInfo = aaMapper.selectOne(new QueryWrapper<AaInfo>().eq("stu",stu));
        if (aaInfo != null) {
            return aaInfo;
        }

        return null;
    }
}

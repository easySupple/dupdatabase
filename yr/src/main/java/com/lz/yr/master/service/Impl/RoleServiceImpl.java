package com.lz.yr.master.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.yr.master.entity.RoleInfo;
import com.lz.yr.master.mapper.RoleMapper;
import com.lz.yr.master.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:49
 * version $Id: UserServiceImpl.java$
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleInfo> implements RoleService {

    @Override
    public List<RoleInfo> getListByUesrId(Long userId) {
        return this.list(new QueryWrapper<RoleInfo>().eq("user_id",userId));
    }
}

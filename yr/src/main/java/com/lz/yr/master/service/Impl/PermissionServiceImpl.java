package com.lz.yr.master.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.yr.master.entity.PermissionInfo;
import com.lz.yr.master.mapper.PermissionMapper;
import com.lz.yr.master.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:49
 * version $Id: UserServiceImpl.java$
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionInfo> implements PermissionService {
    @Override
    public List<PermissionInfo> getListByRoleId(Long roleId) {
        return this.list(new QueryWrapper<PermissionInfo>().eq("role_id",roleId));
    }
}

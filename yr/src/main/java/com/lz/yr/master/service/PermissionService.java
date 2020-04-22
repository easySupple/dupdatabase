package com.lz.yr.master.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lz.yr.master.entity.PermissionInfo;

import java.util.List;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:47
 * version $Id: UserService.java$
 */
public interface PermissionService extends IService<PermissionInfo> {

    List<PermissionInfo> getListByRoleId(Long roleId);

}

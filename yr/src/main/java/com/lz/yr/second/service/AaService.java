package com.lz.yr.second.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lz.yr.second.entity.AaInfo;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:47
 * version $Id: UserService.java$
 */

public interface AaService extends IService<AaInfo> {
    AaInfo getByStu(String stu);
}

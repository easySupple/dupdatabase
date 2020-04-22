package com.lz.yr.master.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lz.yr.master.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:44
 * version $Id: UserMappler.java$
 */
@Mapper
public interface UserMapper  extends BaseMapper<UserInfo> {
}

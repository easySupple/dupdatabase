package com.lz.yr.master.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.yr.master.entity.UserInfo;
import com.lz.yr.master.mapper.UserMapper;
import com.lz.yr.master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:49
 * version $Id: UserServiceImpl.java$
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

}

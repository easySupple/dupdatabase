package com.lz.yr.controller;

import com.lz.yr.master.entity.UserInfo;
import com.lz.yr.master.service.UserService;
import com.lz.yr.response.ResUserInfo;
import com.lz.yr.second.entity.AaInfo;
import com.lz.yr.second.service.AaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/22 10:04
 * version $Id: TestController.java$
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private AaService aaService;

    @Autowired
    private UserService userService;

    @GetMapping("/getId")
    public AaInfo test(String stu){
     AaInfo aaInfo = aaService.getByStu(stu);
      return aaInfo;
    }

    @GetMapping("/getUserById")
    public ResUserInfo getUser(Long id){

        UserInfo userInfo =  userService.getById(id);
        if(userInfo != null){
            ResUserInfo resUserInfo = new ResUserInfo();
            BeanUtils.copyProperties(userInfo, resUserInfo);
            return  resUserInfo;
        }

        return  null;
    }
}

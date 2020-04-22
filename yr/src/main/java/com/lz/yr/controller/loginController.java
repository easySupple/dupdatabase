package com.lz.yr.controller;

import com.lz.yr.master.entity.PermissionInfo;
import com.lz.yr.master.entity.RoleInfo;
import com.lz.yr.master.entity.UserInfo;;
import com.lz.yr.response.ResUserInfo;
import com.lz.yr.response.SysResult;
import com.lz.yr.master.service.PermissionService;
import com.lz.yr.master.service.RoleService;
import com.lz.yr.master.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:55
 * version $Id: loginController.java$
 */
@RestController
public class loginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;



    @PostMapping("/login")
    public SysResult login(@RequestBody UserInfo userInfo){

        SysResult sysResult  = new SysResult();
       Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(userInfo.getCode());
        token.setPassword(userInfo.getPassword().toCharArray());
        try {
            subject.login(token);
            ResUserInfo resUserInfo  = new ResUserInfo();
            UserInfo userInfo1 = (UserInfo) subject.getPrincipal();
            BeanUtils.copyProperties(userInfo1,resUserInfo);
            subject.getSession().setAttribute("SESSION_USER",userInfo1.getCode());
            List<RoleInfo> roleList  = roleService.getListByUesrId(userInfo1.getId());
            List<String> menuList = new ArrayList<>();
            roleList.stream().forEach( role ->{
                List<PermissionInfo> permissionList = permissionService.getListByRoleId(role.getId());
                if(permissionList != null && !permissionList.isEmpty()){
                    permissionList.stream().forEach(p ->{
                        menuList.add(p.getPermission());
                    });
                    resUserInfo.setPermission(menuList);
                }
            });
            sysResult.setSysInfo(resUserInfo);
        }catch (UnknownAccountException e){
            sysResult.setSysCode("0001");
            sysResult.setSysName("用户不存在");
        }catch (IncorrectCredentialsException e){
            sysResult.setSysCode("0002");
            sysResult.setSysName("密码错误");
        }

        return  sysResult;
    }
}

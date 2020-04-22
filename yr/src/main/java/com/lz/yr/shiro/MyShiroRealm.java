package com.lz.yr.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.yr.comm.MD5Encrypt;
import com.lz.yr.master.entity.UserInfo;
import com.lz.yr.master.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 17:10
 * version $Id: MyShiro.java$
 */
public class MyShiroRealm  extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        UserInfo userInfo = userService.getOne(new QueryWrapper<UserInfo>().eq("code",token1.getUsername()));
        if(userInfo == null){
            throw new UnknownAccountException("该操作员不存在，不能登录系统！");
        }
        // 验证密码
        String pswStr = MD5Encrypt.encrypt(MD5Encrypt.returnStrNotDigital(token1.getUsername(),
                String.valueOf(token1.getPassword())));
        token1.setPassword(pswStr.toCharArray());
        System.out.println("md5:" + pswStr);
//        if(!pswStr.equals(userInfo.getPassword())){
//            throw new IncorrectCredentialsException("操作员密码不正确，请重新登陆！");
//        }
        return new SimpleAuthenticationInfo(userInfo,userInfo.getPassword(),getName());
    }
}

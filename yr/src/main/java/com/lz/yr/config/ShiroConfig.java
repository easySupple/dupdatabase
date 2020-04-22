package com.lz.yr.config;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 17:04
 * version $Id: ShrioConfig.java$
 */

import com.lz.yr.shiro.MyShiroRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean sb = new ShiroFilterFactoryBean();
        sb.setSecurityManager(securityManager);
        sb.setLoginUrl("/login");
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login", "anon");
        filterMap.put("/staticpage/**", "anon");
        filterMap.put("/test/**","anon");
        filterMap.put("/**", "authc");
        sb.setFilterChainDefinitionMap(filterMap);
        return sb;
    }

    @Bean
    public SecurityManager securityManager(MyShiroRealm realm){
        DefaultSecurityManager dsm = new DefaultWebSecurityManager();
        dsm.setRealm(realm);
        return dsm;
    }

    @Bean
    public MyShiroRealm realm(){
        return new MyShiroRealm();
    }

}

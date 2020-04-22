package com.lz.yr.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/22 13:51
 * version $Id: DataSourceSwitchAspect.java$
 */
@Component
@Order(value = -100)
@Slf4j
@Aspect
public class DataSourceSwitchAspect {

    @Pointcut("execution(* com.lz.yr.master.mapper.*.*(..))")
    private void db1Aspect() {
    }

    @Pointcut("execution(* com.lz.yr.second.mapper.*.*(..))")
    private void db2Aspect() {
    }


    @Before("db1Aspect()")
    public void db1() {
        log.info("切换到db1 数据源...");
        DbContextHolder.setDbType("db1");
    }

    @Before("db2Aspect()")
    public void db2() {
        log.info("切换到db2 数据源...");
        DbContextHolder.setDbType("db2");
    }

}

package com.lz.yr.config;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/22 10:49
 * version $Id: DbContextHolder.java$
 */
public class DbContextHolder {

    private static final ThreadLocal contextHolder = new ThreadLocal<>();

    public static void setDbType(String dbname) {
        contextHolder.set(dbname);
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getDbType() {
        return (String) contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearDbType() {
        contextHolder.remove();
    }
}

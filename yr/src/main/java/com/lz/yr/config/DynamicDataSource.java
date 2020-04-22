package com.lz.yr.config;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/22 10:49
 * version $Id: DynamicDataSource.java$
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}

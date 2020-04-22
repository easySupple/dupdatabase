package com.lz.yr.response;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/21 11:33
 * version $Id: SysResult.java$
 */
@Data
public class SysResult {

    private String sysCode;
    private String sysName;
    private String sysTime;
    private Object sysInfo;

    public SysResult() {
        this.sysCode = "0000";
        this.sysName = "成功";
        this.sysTime = new SimpleDateFormat("yyyyMMddHHmmss",
                Locale.getDefault()).format(new Date());
    }
}

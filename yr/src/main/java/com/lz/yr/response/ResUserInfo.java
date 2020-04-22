package com.lz.yr.response;

import com.lz.yr.master.entity.UserInfo;
import lombok.Data;

import java.util.List;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:56
 * version $Id: UserInfoRes.java$
 */
@Data
public class ResUserInfo extends UserInfo{

    private List<String> permission;

    @Override
    public String toString() {
        return "ResUserInfo{" +
                "permission=" + permission +
                '}';
    }
}

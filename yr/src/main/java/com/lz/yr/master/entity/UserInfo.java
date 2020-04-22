package com.lz.yr.master.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:31
 * version $Id: UserInfo.java$
 */
@TableName("user")
@Entity
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private String name;

    private String password;

}

package com.lz.yr.master.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:40
 * version $Id: PermissionInfo.java$
 */
@TableName("permission")
@Entity
@Data
public class PermissionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "permission")
    private String permission;

    @Column(name = "role_id")
    private Long roleId;
}

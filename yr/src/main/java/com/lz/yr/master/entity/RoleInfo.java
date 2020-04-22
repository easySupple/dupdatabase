package com.lz.yr.master.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:39
 * version $Id: RoleInfo.java$
 */
@TableName("role")
@Entity
@Data
public class RoleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "permission_id")
    private Long permissionId;
}

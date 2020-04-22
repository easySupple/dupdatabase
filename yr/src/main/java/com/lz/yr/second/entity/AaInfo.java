package com.lz.yr.second.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/20 16:31
 * version $Id: UserInfo.java$
 */
@TableName("aa")
@Entity
@Data
public class AaInfo {

    @Id
    private String stu;

    private String name;


}

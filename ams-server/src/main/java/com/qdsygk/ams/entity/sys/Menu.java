package com.qdsygk.ams.entity.sys;

import com.qdsygk.ams.common.CrudEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 菜单
 *
 * @Author: lilinzhen
 * @Version: 2019/11/29
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@Table(name = "sys_menu")
public class Menu extends CrudEntity implements Serializable {


    private String url;
    private String path;
    private String component;
    private String name;
    private String iconCls;
    private Long parentId;
    @Transient //表示该属性并非一个到数据库表的字段的映射
    private List<Role> roles;
    @Transient
    private List<Menu> children;
    @Embedded
    private MenuMeta meta;
    private boolean enabled;

}

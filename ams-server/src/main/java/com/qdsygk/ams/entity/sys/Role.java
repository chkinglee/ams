package com.qdsygk.ams.entity.sys;

import com.qdsygk.ams.common.CrudEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 角色
 *
 * @Author: lilinzhen
 * @Version: 2019/11/29
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@Table(name = "sys_role")
public class Role extends CrudEntity implements Serializable {
    private String name;
    private String nameZh;

}

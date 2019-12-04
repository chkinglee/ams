package com.qdsygk.ams.entity.sys;

import com.qdsygk.ams.common.CrudEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/11/29
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@Table(name = "sys_menu_role")
public class MenuRole extends CrudEntity {

    @OneToOne
    private Menu menu;

    @OneToOne
    private Role role;

}

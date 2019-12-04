package com.qdsygk.ams.entity.user;

import com.qdsygk.ams.common.CrudEntity;
import com.qdsygk.ams.entity.sys.Role;
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
 * @Version: 2019/11/30
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@Table(name = "user_role")
public class UserRole extends CrudEntity {

    @OneToOne
    private User user;

    @OneToOne
    private Role role;

}

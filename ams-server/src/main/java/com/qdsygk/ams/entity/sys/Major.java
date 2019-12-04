package com.qdsygk.ams.entity.sys;

import com.qdsygk.ams.common.CrudEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 专业
 *
 * @Author: lilinzhen
 * @Version: 2019/10/7
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@Table(name = "sys_major")
public class Major extends CrudEntity {

    // 专业名称
    private String majorName;

    // 所属学院
    @ManyToOne(optional=false)
    @JoinColumn(name = "majorCollege")
    private College majorCollege;
}

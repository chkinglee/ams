package com.qdsygk.ams.entity.user;

import com.qdsygk.ams.common.CommonEnum;
import com.qdsygk.ams.common.CrudEntity;
import com.qdsygk.ams.entity.sys.Major;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.*;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/7/31
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@Table(name = "user_student")
public class UserStudent extends CrudEntity {

    private String stuName;
    private Long stuNumber;

    private int stuAge;
    private Long stuTel;


    @Enumerated(EnumType.ORDINAL)
    private CommonEnum.Gender stuGender;

    @ManyToOne()
    @JoinColumn(name = "stuMajor")
    private Major stuMajor;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

}

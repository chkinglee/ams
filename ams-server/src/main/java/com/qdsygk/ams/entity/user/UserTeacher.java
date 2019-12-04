package com.qdsygk.ams.entity.user;

import com.qdsygk.ams.common.CrudEntity;
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
@Table(name = "user_teacher")
public class UserTeacher extends CrudEntity {

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
    private Long teacherName;

}

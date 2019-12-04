package com.qdsygk.ams.entity.sys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qdsygk.ams.common.CrudEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * 学院
 *
 * @Author: lilinzhen
 * @Version: 2019/10/7
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@Table(name = "sys_college")
public class College extends CrudEntity {

    // 学院名称
    private String collegeName;

    // 专业列表
    @JsonIgnore
    @OneToMany(mappedBy = "majorCollege",
            cascade = CascadeType.ALL,
            fetch= FetchType.LAZY)
    private List<Major> collegeMajorList;
}

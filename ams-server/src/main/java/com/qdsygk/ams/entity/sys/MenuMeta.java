package com.qdsygk.ams.entity.sys;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/11/30
 **/
@Data
public class MenuMeta implements Serializable {

    private boolean keepAlive;
    private boolean requireAuth;
}

package com.qdsygk.ams.rest;

import com.qdsygk.ams.entity.sys.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/11/30
 **/
@RestController
public class RegLoginController {
    @RequestMapping("/login_p")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录!");
    }

}

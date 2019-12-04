package com.qdsygk.ams.rest;

import com.qdsygk.ams.entity.sys.Menu;
import com.qdsygk.ams.entity.user.User;
import com.qdsygk.ams.service.sys.MenuService;
import com.qdsygk.ams.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/11/30
 **/
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    MenuService menuService;
    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu() {
        return menuService.getMenusByUserId();
    }

    @RequestMapping("/user")
    public User currentUser() {
        return UserUtils.getCurrentUser();
    }
}

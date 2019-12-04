package com.qdsygk.ams.mapper;

import com.qdsygk.ams.entity.sys.Menu;

import java.util.List;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/11/30
 **/
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByUserId(Long UserId);

    List<Menu> menuTree();

    List<Long> getMenusByRoleId(Long roleId);
}

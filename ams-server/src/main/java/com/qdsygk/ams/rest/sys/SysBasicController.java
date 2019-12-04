package com.qdsygk.ams.rest.sys;

import com.qdsygk.ams.entity.sys.Menu;
import com.qdsygk.ams.entity.sys.RespBean;
import com.qdsygk.ams.entity.sys.Role;
import com.qdsygk.ams.service.sys.MenuRoleService;
import com.qdsygk.ams.service.sys.MenuService;
import com.qdsygk.ams.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/12/1
 **/
@RestController
@RequestMapping("sys/basic")
public class SysBasicController {

    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @Autowired
    MenuRoleService menuRoleService;



    @RequestMapping(value = "/role/", method = RequestMethod.GET)
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @RequestMapping(value = "/role/", method = RequestMethod.POST)
    public RespBean addNewRole(String name, String nameZh) {
        Role role = roleService.addNewRole(name, nameZh);
        if (role != null && role.getId() != null ) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @RequestMapping(value = "/role/{rid}", method = RequestMethod.DELETE)
    public RespBean deleteRole(@PathVariable Long rid) {
        if (roleService.deleteRoleById(rid)) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }


    @RequestMapping(value = "/menuRole", method = RequestMethod.PUT)
    public RespBean updateMenuRole(Long rid, Long[] mids) {
        if (menuRoleService.updateMenuRole(rid, mids) == mids.length) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/menu/menuTree/{rid}", method = RequestMethod.GET)
    public Map<String, Object> menuTree(@PathVariable Long rid) {
        Map<String, Object> map = new HashMap<>();
        List<Menu> menus = menuService.menuTree();
        map.put("menus", menus);
        List<Long> selMids = menuService.getMenusByRid(rid);
        map.put("mids", selMids);
        return map;
    }
}

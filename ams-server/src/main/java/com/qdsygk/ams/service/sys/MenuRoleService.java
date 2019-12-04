package com.qdsygk.ams.service.sys;

import com.qdsygk.ams.entity.sys.Menu;
import com.qdsygk.ams.entity.sys.MenuRole;
import com.qdsygk.ams.entity.sys.Role;
import com.qdsygk.ams.repository.sys.MenuRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/12/1
 **/
@Service
@Transactional
public class MenuRoleService {

    @Autowired
    MenuRoleRepository menuRoleRepository;

    public int updateMenuRole(Long rid, Long[] mids) {
        menuRoleRepository.deleteAllByRoleId(rid);
        if (mids.length == 0) {
            return 0;
        }
        List<MenuRole> menuRoleList = new ArrayList<>();
        for (Long mid : mids) {
            MenuRole menuRole = new MenuRole();
            Menu menu = new Menu();
            menu.setId(mid);
            Role role = new Role();
            role.setId(rid);
            menuRole.setMenu(menu);
            menuRole.setRole(role);
            menuRoleList.add(menuRole);
        }
        return menuRoleRepository.saveAll(menuRoleList).size();
    }
}

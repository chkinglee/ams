package com.qdsygk.ams.service.sys;

import com.qdsygk.ams.entity.sys.Role;
import com.qdsygk.ams.repository.sys.MenuRoleRepository;
import com.qdsygk.ams.repository.sys.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/12/1
 **/
@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    MenuRoleRepository menuRoleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role addNewRole(String name, String nameZh) {
        if (!name.startsWith("ROLE_")) {
            name = "ROLE_" + name;
        }
        Role role = new Role();
        role.setName(name);
        role.setNameZh(nameZh);
        return roleRepository.save(role);
    }

    public Boolean deleteRoleById(Long roleId) {
        menuRoleRepository.deleteAllByRoleId(roleId);
        if (checkIsPresent(roleId)) {
            roleRepository.deleteById(roleId);
            if (!checkIsPresent(roleId)) {
                return true;
            }
        }
        return false;
    }


    private boolean checkIsPresent(Long id) {
        return roleRepository.findById(id).isPresent();
    }
}

package com.qdsygk.ams.repository.sys;

import com.qdsygk.ams.entity.sys.MenuRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/12/1
 **/
public interface MenuRoleRepository extends JpaRepository<MenuRole, Long> {

    @Modifying
    @Query(value = "delete from sys_menu_role where role_id = ?1", nativeQuery = true)
    void deleteAllByRoleId(Long roleId);
}

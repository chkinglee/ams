package com.qdsygk.ams.repository.sys;

import com.qdsygk.ams.entity.sys.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/11/30
 **/
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "select r.* from user_role ur, sys_role r where ur.role_id = r.id and ur.user_id = ?1", nativeQuery = true)
    List<Role> getRolesByUserId(Long userId);

    @Query(value = "select r.* from sys_role r order by r.id limit ?1, ?2", nativeQuery = true)
    List<Role> getRoleByPage(Integer start, Integer pageSize);
}

package com.qdsygk.ams.repository;

import com.qdsygk.ams.entity.sys.Role;
import com.qdsygk.ams.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/11/30
 **/
public interface UserRepository extends JpaRepository<User, Long> {


    User getUserByLogname(String logname);
}

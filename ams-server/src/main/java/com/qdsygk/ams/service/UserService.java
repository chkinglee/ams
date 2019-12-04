package com.qdsygk.ams.service;

import com.qdsygk.ams.entity.user.User;
import com.qdsygk.ams.repository.sys.RoleRepository;
import com.qdsygk.ams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/11/30
 **/
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.getUserByLogname(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        user.setRoles(roleRepository.getRolesByUserId(user.getId()));
        return user;
    }
}

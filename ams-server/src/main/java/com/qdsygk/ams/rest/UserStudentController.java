package com.qdsygk.ams.rest;

import com.qdsygk.ams.entity.user.UserStudent;
import com.qdsygk.ams.repository.UserStudentRepository;
import com.qdsygk.ams.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/7/31
 * @Controller + @ResponseBody = @RestController
 **/
@Slf4j
@RestController
@RequestMapping(value = "user/student")
public class UserStudentController {

    @Autowired
    private UserStudentRepository userStudentRepository;

    /**
     * 获取所有学生用户
     * @return list
     */
    @GetMapping("/")
    List<UserStudent> findAll() {
        return userStudentRepository.findAll();
    }

    /**
     * 通过id查询学生用户
     * @param id 用户id
     * @return US
     */
    @GetMapping("/{id}")
    UserStudent findOne(@PathVariable Long id) {
        return userStudentRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    /**
     * 创建新学生用户
     * @param userStudent 学生用户
     * @return US
     */
    @PostMapping("/")
    UserStudent newOne(@RequestBody UserStudent userStudent) {
        return userStudentRepository.save(userStudent);
    }

    /**
     * 更新学生用户
     * @param userStudent 学生用户
     * @param id 用户id
     * @return US
     */
    @PutMapping("/{id}")
    UserStudent updateOne(@RequestBody UserStudent userStudent, @PathVariable Long id) {
        UserStudent newUserStudent = userStudentRepository.findById(id)
                // 如果要更新的body中，存在null的value，直接调用save方法会把null覆盖到原有value上
                // 思路：将原有body找到，通过utils将新body除了null之外的value覆盖到原有body上
                // 然后再调用save保存原有body
                .map(oldUserStudent -> {
                    BeanUtils.copyPropertiesIgnoreNull(userStudent, oldUserStudent);
                    return userStudentRepository.save(oldUserStudent);
                })
                // 如果没有找到目标body，则新建一个
                .orElseGet(() -> {
                    userStudent.setId(id);
                    return userStudentRepository.save(userStudent);
                });
        return newUserStudent;
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return bool
     */
    @DeleteMapping("/{id}")
    boolean delOne(@PathVariable Long id) {
        if (checkIsPresent(id)) {
            userStudentRepository.deleteById(id);
            if (!checkIsPresent(id)) {
                return true;
            } else {
                log.error("delete UserStudent_{} error", id);
            }
        } else {
            log.error("UserStudent_{} isn't present", id);
        }
        return false;
    }

    private boolean checkIsPresent(Long id) {
        return userStudentRepository.findById(id).isPresent();
    }
}

package com.qdsygk.ams.rest.sys;

import com.qdsygk.ams.entity.sys.College;
import com.qdsygk.ams.repository.sys.SysCollegeRepository;
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
 * @Version: 2019/10/7
 **/
@Slf4j
@RestController
@RequestMapping(value = "sys/college")
public class CollegeController {

    @Autowired
    private SysCollegeRepository sysCollegeRepository;

    /**
     * 获取所有学生用户
     * @return list
     */
    @GetMapping("/")
    List<College> findAll() {
        return sysCollegeRepository.findAll();
    }

    /**
     * 通过id查询学生用户
     * @param id 用户id
     * @return US
     */
    @GetMapping("/{id}")
    College findOne(@PathVariable Long id) {
        return sysCollegeRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    /**
     * 创建新学生用户
     * @param college 学生用户
     * @return US
     */
    @PostMapping("/")
    College newOne(@RequestBody College college) {
        return sysCollegeRepository.save(college);
    }

    /**
     * 更新学生用户
     * @param college 学生用户
     * @param id 用户id
     * @return US
     */
    @PutMapping("/{id}")
    College updateOne(@RequestBody College college, @PathVariable Long id) {
        College newCollege = sysCollegeRepository.findById(id)
                .map(oldCollege -> {
                    BeanUtils.copyPropertiesIgnoreNull(college, oldCollege);
                    return sysCollegeRepository.save(oldCollege);
                })
                .orElseGet(() -> {
                    college.setId(id);
                    return sysCollegeRepository.save(college);
                });
        return newCollege;
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return bool
     */
    @DeleteMapping("/{id}")
    boolean delOne(@PathVariable Long id) {
        if (checkIsPresent(id)) {
            sysCollegeRepository.deleteById(id);
            if (!checkIsPresent(id)) {
                return true;
            } else {
                log.error("delete SysCollege_{} error", id);
            }
        } else {
            log.error("SysCollege_{} isn't present", id);
        }
        return false;
    }

    private boolean checkIsPresent(Long id) {
        return sysCollegeRepository.findById(id).isPresent();
    }
}


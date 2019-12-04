package com.qdsygk.ams.rest.sys;

import com.qdsygk.ams.entity.sys.Major;
import com.qdsygk.ams.repository.sys.SysMajorRepository;
import com.qdsygk.ams.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
@RequestMapping(value = "sys/major")
public class MajorController {

    @Autowired
    private SysMajorRepository sysMajorRepository;

    /**
     * 获取所有学生用户
     * @return list
     */
    @GetMapping("/")
    List<Major> findAll(@RequestBody Major major) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("majorName" , match -> match.contains());
        Example<Major> example = Example.of(major, exampleMatcher);
        return sysMajorRepository.findAll(example);
    }

    /**
     * 通过id查询学生用户
     * @param id 用户id
     * @return US
     */
    @GetMapping("/{id}")
    Major findOne(@PathVariable Long id) {
        return sysMajorRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    /**
     * 创建新学生用户
     * @param major 学生用户
     * @return US
     */
    @PostMapping("/")
    Major newOne(@RequestBody Major major) {
        return sysMajorRepository.save(major);
    }

    /**
     * 更新学生用户
     * @param major 学生用户
     * @param id 用户id
     * @return US
     */
    @PutMapping("/{id}")
    Major updateOne(@RequestBody Major major, @PathVariable Long id) {
        Major newMajor = sysMajorRepository.findById(id)
                .map(oldMajor -> {
                    BeanUtils.copyPropertiesIgnoreNull(major, oldMajor);
                    return sysMajorRepository.save(oldMajor);
                })
                .orElseGet(() -> {
                    major.setId(id);
                    return sysMajorRepository.save(major);
                });
        return newMajor;
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return bool
     */
    @DeleteMapping("/{id}")
    boolean delOne(@PathVariable Long id) {
        if (checkIsPresent(id)) {
            sysMajorRepository.deleteById(id);
            if (!checkIsPresent(id)) {
                return true;
            } else {
                log.error("delete SysMajor_{} error", id);
            }
        } else {
            log.error("SysMajor_{} isn't present", id);
        }
        return false;
    }

    private boolean checkIsPresent(Long id) {
        return sysMajorRepository.findById(id).isPresent();
    }
}


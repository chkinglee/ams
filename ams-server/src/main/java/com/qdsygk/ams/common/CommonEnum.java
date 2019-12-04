package com.qdsygk.ams.common;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * TODO
 *
 * @Author: lilinzhen
 * @Version: 2019/10/7
 **/
public interface CommonEnum {

    // 性别
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    enum Gender implements CommonEnum {
        MALE("男"),
        FAMALE("女");
        private String gender;

        Gender(String gender) {
            this.gender = gender;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }

    // 用户类型
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    enum UserType implements CommonEnum {
        ADMIN("系统管理员"),
        STUDENT("学生"),
        DEPART("部门");
        private String userType;

        UserType(String userType) {
            this.userType = userType;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }
    }
}

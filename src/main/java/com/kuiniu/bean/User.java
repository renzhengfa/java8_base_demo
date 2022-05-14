package com.kuiniu.bean;

import com.kn20210423.注解.Zj;

import java.io.Serializable;
import java.util.Objects;

/*
用户类
CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL COMMENT '乐观锁Version',
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '姓',
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名',
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '图片ID',
  PRIMARY KEY (`ID_`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户信息表';
 */
@SuppressWarnings("all")
public class User implements Serializable {
    private String ID_;
    private Integer REV_;
    private String FIRST_;
    private String LAST_;
    private String EMAIL_;
    private String PWD_;
    private String PICTURE_ID_;

    public User() {
    }


    public User(String ID_, Integer REV_, String FIRST_, String LAST_, String EMAIL_, String PWD_, String PICTURE_ID_) {
        this.ID_ = ID_;
        this.REV_ = REV_;
        this.FIRST_ = FIRST_;
        this.LAST_ = LAST_;
        this.EMAIL_ = EMAIL_;
        this.PWD_ = PWD_;
        this.PICTURE_ID_ = PICTURE_ID_;
    }


    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public Integer getREV_() {
        return REV_;
    }

    public void setREV_(Integer REV_) {
        this.REV_ = REV_;
    }

    public String getFIRST_() {
        return FIRST_;
    }

    public void setFIRST_(String FIRST_) {
        this.FIRST_ = FIRST_;
    }

    public String getLAST_() {
        return LAST_;
    }

    public void setLAST_(String LAST_) {
        this.LAST_ = LAST_;
    }

    public String getEMAIL_() {
        return EMAIL_;
    }

    public void setEMAIL_(String EMAIL_) {
        this.EMAIL_ = EMAIL_;
    }

    public String getPWD_() {
        return PWD_;
    }

    public void setPWD_(String PWD_) {
        this.PWD_ = PWD_;
    }

    public String getPICTURE_ID_() {
        return PICTURE_ID_;
    }

    public void setPICTURE_ID_(String PICTURE_ID_) {
        this.PICTURE_ID_ = PICTURE_ID_;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID_='" + ID_ + '\'' +
                ", REV_=" + REV_ +
                ", FIRST_='" + FIRST_ + '\'' +
                ", LAST_='" + LAST_ + '\'' +
                ", EMAIL_='" + EMAIL_ + '\'' +
                ", PWD_='" + PWD_ + '\'' +
                ", PICTURE_ID_='" + PICTURE_ID_ + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(ID_, user.ID_) &&
                Objects.equals(REV_, user.REV_) &&
                Objects.equals(FIRST_, user.FIRST_) &&
                Objects.equals(LAST_, user.LAST_) &&
                Objects.equals(EMAIL_, user.EMAIL_) &&
                Objects.equals(PWD_, user.PWD_) &&
                Objects.equals(PICTURE_ID_, user.PICTURE_ID_);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, PICTURE_ID_);
    }
}

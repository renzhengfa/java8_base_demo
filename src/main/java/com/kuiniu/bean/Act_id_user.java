package com.kuiniu.bean;

import java.io.Serializable;

public class Act_id_user implements Serializable {

    private Integer ID_;
    private Integer REV_;
    private String FIRST_;
    private String LAST_;
    private String EMAIL_;
    private String PWD_;
    private String PICTURE_ID_;

    public Act_id_user() {
    }

    public Act_id_user(Integer ID_, Integer REV_, String FIRST_, String LAST_, String EMAIL_, String PWD_, String PICTURE_ID_) {
        this.ID_ = ID_;
        this.REV_ = REV_;
        this.FIRST_ = FIRST_;
        this.LAST_ = LAST_;
        this.EMAIL_ = EMAIL_;
        this.PWD_ = PWD_;
        this.PICTURE_ID_ = PICTURE_ID_;
    }

    public Integer getID_() {
        return ID_;
    }

    public void setID_(Integer ID_) {
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
        return "Act_id_user{" +
                "ID_='" + ID_ + '\'' +
                ", REV_=" + REV_ +
                ", FIRST_='" + FIRST_ + '\'' +
                ", LAST_='" + LAST_ + '\'' +
                ", EMAIL_='" + EMAIL_ + '\'' +
                ", PWD_='" + PWD_ + '\'' +
                ", PICTURE_ID_='" + PICTURE_ID_ + '\'' +
                '}';
    }
}

package com.de.base.entity;

import java.io.Serializable;

public class SysTemp implements Serializable {
    private String id;

    private String name;

    private String nameEn;

    private String namePy;

    private String province;

    private String weathercnid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public String getNamePy() {
        return namePy;
    }

    public void setNamePy(String namePy) {
        this.namePy = namePy == null ? null : namePy.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getWeathercnid() {
        return weathercnid;
    }

    public void setWeathercnid(String weathercnid) {
        this.weathercnid = weathercnid == null ? null : weathercnid.trim();
    }
}
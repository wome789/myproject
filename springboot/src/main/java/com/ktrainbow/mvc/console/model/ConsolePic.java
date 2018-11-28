package com.ktrainbow.mvc.console.model;

import java.util.Date;

/**
 * 图片
 * 
 * @author wcyong
 * 
 * @date 2018-06-30
 */
public class ConsolePic {
    private Integer id;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 图片分类id
     */
    private String picTypeId;

    /**
     * 图片分类名称
     */
    private String picTypeName;

    /**
     * 网站网址
     */
    private String url;

    /**
     * 网站网址
     */
    private String jumpUrl;

    /**
     * 状态 1正常 0已删除
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPicTypeId() {
        return picTypeId;
    }

    public void setPicTypeId(String picTypeId) {
        this.picTypeId = picTypeId == null ? null : picTypeId.trim();
    }

    public String getPicTypeName() {
        return picTypeName;
    }

    public void setPicTypeName(String picTypeName) {
        this.picTypeName = picTypeName == null ? null : picTypeName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl == null ? null : jumpUrl.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
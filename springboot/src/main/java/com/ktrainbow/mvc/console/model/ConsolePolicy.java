package com.ktrainbow.mvc.console.model;

import java.util.Date;

/**
 * 隐私政策
 * 
 * @author wcyong
 * 
 * @date 2018-07-09
 */
public class ConsolePolicy {
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String info;

    /**
     * 状态 1正常 0已删除
     */
    private Byte status;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
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
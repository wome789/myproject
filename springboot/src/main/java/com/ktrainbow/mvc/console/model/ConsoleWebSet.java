package com.ktrainbow.mvc.console.model;

import java.util.Date;

/**
 * 网站设置表
 * 
 * @author wcyong
 * 
 * @date 2018-06-30
 */
public class ConsoleWebSet {
    private Integer id;

    /**
     * 网站名称
     */
    private String name;

    /**
     * 网站网址
     */
    private String url;

    /**
     * 网站关键字(关键字之间用逗号隔开)
     */
    private String importantKey;

    /**
     * 网站描述
     */
    private String info;

    /**
     * 网站Logo(大小为252X75)
     */
    private String logo;

    /**
     * 网站图标（图标必须是ico格式的,大小为48x48）
     */
    private String ico;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImportantKey() {
        return importantKey;
    }

    public void setImportantKey(String importantKey) {
        this.importantKey = importantKey == null ? null : importantKey.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico == null ? null : ico.trim();
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
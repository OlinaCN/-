package studyroom.bean;

import java.sql.Timestamp;

public class Announcement {
    private long id;
    private String content;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createdBy;

    public Announcement() {
        // 使用当前时间戳初始化时间字段
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.updateTime = new Timestamp(System.currentTimeMillis());
    }

    public Announcement(String content, String createdBy) {
        this();  // 调用默认构造函数来初始化时间字段
        this.content = content;
        this.createdBy = createdBy;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
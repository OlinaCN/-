package studyroom.service;

import studyroom.bean.Announcement;
import studyroom.exception.AppException;
import java.util.List;

public interface AnnouncementService {
    /**
     * 添加公告
     */
    void addAnnouncement(String content, String createdBy) throws AppException;

    /**
     * 删除公告
     */
    void deleteAnnouncement(long id) throws AppException;

    /**
     * 更新公告
     */
    void updateAnnouncement(long id, String content) throws AppException;

    /**
     * 获取所有公告
     */
    List<Announcement> getAllAnnouncements() throws AppException;

    /**
     * 获取单个公告
     */
    Announcement getAnnouncementById(long id) throws AppException;
}
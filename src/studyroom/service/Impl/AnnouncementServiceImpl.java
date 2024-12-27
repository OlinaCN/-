package studyroom.service.Impl;

import studyroom.bean.Announcement;
import studyroom.dao.AnnouncementDao;
import studyroom.dao.impl.AnnouncementDaoImpl;
import studyroom.exception.AppException;
import studyroom.service.AnnouncementService;

import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService {
    private AnnouncementDao announcementDao = new AnnouncementDaoImpl();

    @Override
    public void addAnnouncement(String content, String createdBy) throws AppException {
        try {
            if (content == null || content.trim().isEmpty()) {
                throw new AppException("公告内容不能为空");
            }
            if (createdBy == null || createdBy.trim().isEmpty()) {
                throw new AppException("发布者不能为空");
            }

            Announcement announcement = new Announcement(content, createdBy);
            int result = announcementDao.addAnnouncement(announcement);
            if (result != 1) {
                throw new AppException("添加公告失败");
            }
        } catch (Exception e) {
            throw new AppException("添加公告时发生错误: " + e.getMessage());
        }
    }

    @Override
    public void deleteAnnouncement(long id) throws AppException {
        try {
            int result = announcementDao.deleteById(id);
            if (result != 1) {
                throw new AppException("删除公告失败");
            }
        } catch (Exception e) {
            throw new AppException("删除公告时发生错误: " + e.getMessage());
        }
    }

    @Override
    public void updateAnnouncement(long id, String content) throws AppException {
        try {
            if (content == null || content.trim().isEmpty()) {
                throw new AppException("公告内容不能为空");
            }

            Announcement announcement = announcementDao.getAnnouncementById(id);
            if (announcement == null) {
                throw new AppException("公告不存在");
            }

            announcement.setContent(content);
            int result = announcementDao.updateAnnouncement(announcement);
            if (result != 1) {
                throw new AppException("更新公告失败");
            }
        } catch (Exception e) {
            throw new AppException("更新公告时发生错误: " + e.getMessage());
        }
    }

    @Override
    public List<Announcement> getAllAnnouncements() throws AppException {
        try {
            return announcementDao.getAllAnnouncements();
        } catch (Exception e) {
            throw new AppException("获取公告列表时发生错误: " + e.getMessage());
        }
    }

    @Override
    public Announcement getAnnouncementById(long id) throws AppException {
        try {
            Announcement announcement = announcementDao.getAnnouncementById(id);
            if (announcement == null) {
                throw new AppException("公告不存在");
            }
            return announcement;
        } catch (Exception e) {
            throw new AppException("获取公告详情时发生错误: " + e.getMessage());
        }
    }
}
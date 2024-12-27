package studyroom.dao;

import studyroom.bean.Announcement;
import java.util.List;

public interface AnnouncementDao {
    int addAnnouncement(Announcement announcement);
    int deleteById(long id);
    int updateAnnouncement(Announcement announcement);
    List<Announcement> getAllAnnouncements();
    Announcement getAnnouncementById(long id);
}
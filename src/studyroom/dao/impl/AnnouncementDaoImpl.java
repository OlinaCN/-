package studyroom.dao.impl;

import studyroom.bean.Announcement;
import studyroom.dao.AnnouncementDao;
import studyroom.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDaoImpl implements AnnouncementDao {
    @Override
    public int addAnnouncement(Announcement announcement) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO announcements(content, create_time, update_time, created_by) VALUES(?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, announcement.getContent());
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.setString(4, announcement.getCreatedBy());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }

    @Override
    public int deleteById(long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "DELETE FROM announcements WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }

    @Override
    public int updateAnnouncement(Announcement announcement) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE announcements SET content = ?, update_time = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, announcement.getContent());
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            ps.setLong(3, announcement.getId());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Announcement> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM announcements ORDER BY create_time DESC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Announcement announcement = new Announcement();
                announcement.setId(rs.getLong("id"));
                announcement.setContent(rs.getString("content"));
                announcement.setCreateTime(rs.getTimestamp("create_time"));
                announcement.setUpdateTime(rs.getTimestamp("update_time"));
                announcement.setCreatedBy(rs.getString("created_by"));
                list.add(announcement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }

    @Override
    public Announcement getAnnouncementById(long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Announcement announcement = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM announcements WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                announcement = new Announcement();
                announcement.setId(rs.getLong("id"));
                announcement.setContent(rs.getString("content"));
                announcement.setCreateTime(rs.getTimestamp("create_time"));
                announcement.setUpdateTime(rs.getTimestamp("update_time"));
                announcement.setCreatedBy(rs.getString("created_by"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return announcement;
    }
}
package studyroom.web.action;

import studyroom.bean.Announcement;
import studyroom.bean.Users;
import studyroom.exception.AppException;
import studyroom.service.AnnouncementService;
import studyroom.service.Impl.AnnouncementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/announcement/list", "/announcement/add", "/announcement/delete", "/announcement/edit"})
public class AnnouncementServlet extends HttpServlet {
    private AnnouncementService announcementService = new AnnouncementServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();

        // 检查是否是管理员
        HttpSession session = request.getSession(false);
        Users user = (Users) session.getAttribute("user");
        if (user == null || !"admin".equals(user.getName())) {
            if (!"/announcement/list".equals(servletPath)) {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
                return;
            }
        }

        try {
            switch (servletPath) {
                case "/announcement/list":
                    handleList(request, response);
                    break;
                case "/announcement/add":
                    handleAdd(request, response);
                    break;
                case "/announcement/delete":
                    handleDelete(request, response);
                    break;
                case "/announcement/edit":
                    handleEdit(request, response);
                    break;
            }
        } catch (AppException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private void handleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, AppException {
        List<Announcement> announcements = announcementService.getAllAnnouncements();
        request.setAttribute("announcements", announcements);
        request.getRequestDispatcher("/announcement/list.jsp").forward(request, response);
    }

    private void handleAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, AppException {
        String content = request.getParameter("content");
        Users user = (Users) request.getSession().getAttribute("user");
        announcementService.addAnnouncement(content, user.getName());
        response.sendRedirect(request.getContextPath() + "/announcement/list");
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, AppException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                long id = Long.parseLong(idStr);
                announcementService.deleteAnnouncement(id);
            } catch (NumberFormatException e) {
                throw new AppException("无效的公告ID");
            }
        }
        response.sendRedirect(request.getContextPath() + "/announcement/list");

    }


    private void handleEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, AppException {
        String idStr = request.getParameter("id");
        String content = request.getParameter("content");

        if (idStr != null && !idStr.trim().isEmpty() && content != null && !content.trim().isEmpty()) {
            try {
                long id = Long.parseLong(idStr);
                announcementService.updateAnnouncement(id, content);
            } catch (NumberFormatException e) {
                throw new AppException("无效的公告ID");
            }
        }
        response.sendRedirect(request.getContextPath() + "/announcement/list");
    }
}
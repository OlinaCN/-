<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>公告列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <style>
        .announcement-container {
            width: 80%;
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .page-title {
            color: #333;
            margin-bottom: 20px;
            padding-bottom: 10px;
            border-bottom: 2px solid #007bff;
        }
        .add-btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-bottom: 20px;
        }
        .announcement-item {
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 15px;
            margin-bottom: 15px;
            background-color: #f8f9fa;
        }
        .announcement-header {
            display: flex;
            justify-content: space-between;
            color: #666;
            margin-bottom: 10px;
            font-size: 14px;
        }
        .announcement-content {
            margin: 15px 0;
            line-height: 1.6;
        }
        .announcement-footer {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 10px;
            padding-top: 10px;
            border-top: 1px solid #eee;
        }
        .btn {
            padding: 6px 12px;
            border-radius: 4px;
            text-decoration: none;
            margin-left: 10px;
        }
        .btn-edit {
            background-color: #28a745;
            color: white;
        }
        .btn-delete {
            background-color: #dc3545;
            color: white;
        }
        .back-btn {
            display: inline-block;
            padding: 8px 16px;
            background-color: #6c757d;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="announcement-container">
    <a href="${pageContext.request.contextPath}/admin.jsp" class="back-btn">返回管理页面</a>
    <h1 class="page-title">公告列表</h1>

    <c:if test="${sessionScope.user.name == 'admin'}">
        <a href="${pageContext.request.contextPath}/announcement/add.jsp" class="add-btn">发布新公告</a>
    </c:if>

    <c:choose>
        <c:when test="${empty announcements}">
            <div style="text-align: center; padding: 20px; color: #666;">
                暂无公告内容
            </div>
        </c:when>
        <c:otherwise>
            <c:forEach items="${announcements}" var="announcement">
                <div class="announcement-item">
                    <div class="announcement-header">
                        <span>发布者: ${announcement.createdBy}</span>
                        <span>发布时间: <fmt:formatDate value="${announcement.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                    </div>
                    <div class="announcement-content">
                            ${announcement.content}
                    </div>
                    <div class="announcement-footer">
                        <span>更新时间: <fmt:formatDate value="${announcement.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                        <c:if test="${sessionScope.user.name == 'admin'}">
                            <div>
                                <a href="${pageContext.request.contextPath}/announcement/edit.jsp?id=${announcement.id}"
                                   class="btn btn-edit">编辑</a>
                                <a href="javascript:void(0);"
                                   onclick="if(confirm('确定要删除这条公告吗？')) window.location.href='${pageContext.request.contextPath}/announcement/delete?id=${announcement.id}'"
                                   class="btn btn-delete">删除</a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
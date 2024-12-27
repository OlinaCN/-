<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        /* 添加一些公告管理相关的样式 */
        .section {
            margin-bottom: 20px;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .section h2 {
            margin-bottom: 10px;
            color: #333;
        }
        .section a {
            display: inline-block;
            margin-right: 10px;
            padding: 8px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 3px;
        }
        .section a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>管理员界面</h1>
    <p>欢迎管理员! 在这里你可以管理用户、自习室、订单和公告</p>

    <div class="admin-actions">
        <!-- 用户管理部分 -->
        <div class="section">
            <h2>管理用户</h2>
            <a href="addUser.jsp">添加用户</a>
            <a href="admin/detail">查看所有用户</a>
        </div>

        <!-- 自习室管理部分 -->
        <div class="section">
            <h2>管理自习室</h2>
            <a href="studyroom/add">添加自习室</a>
            <a href="studyroom/detail">查看所有自习室</a>
        </div>

        <!-- 订单管理部分 -->
        <div class="section">
            <h2>管理订单</h2>
            <a href="order/detail">查看所有订单</a>
        </div>

        <!-- 新增公告管理部分 -->
        <div class="section">
            <h2>管理公告</h2>
            <a href="${pageContext.request.contextPath}/announcement/add.jsp">发布公告</a>
            <a href="${pageContext.request.contextPath}/announcement/list">查看所有公告</a>
        </div>
    </div>
</div>

<script>
    // 可以添加一些交互效果
    document.addEventListener('DOMContentLoaded', function() {
        // 添加鼠标悬停效果
        const sections = document.querySelectorAll('.section');
        sections.forEach(section => {
            section.addEventListener('mouseenter', function() {
                this.style.backgroundColor = '#f8f9fa';
            });
            section.addEventListener('mouseleave', function() {
                this.style.backgroundColor = 'transparent';
            });
        });
    });
</script>
</body>
</html>
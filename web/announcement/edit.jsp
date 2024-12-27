<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑公告</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <style>
        .form-container {
            width: 80%;
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .form-title {
            color: #333;
            margin-bottom: 20px;
            padding-bottom: 10px;
            border-bottom: 2px solid #007bff;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 8px;
            color: #333;
            font-weight: bold;
        }
        .form-group textarea {
            width: 100%;
            min-height: 200px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            resize: vertical;
        }
        .btn-group {
            margin-top: 20px;
        }
        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }
        .btn-submit {
            background-color: #007bff;
            color: white;
        }
        .btn-cancel {
            background-color: #6c757d;
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1 class="form-title">编辑公告</h1>
    <form action="${pageContext.request.contextPath}/announcement/edit" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div class="form-group">
            <label for="content">公告内容：</label>
            <textarea name="content" id="content" required>${announcement.content}</textarea>
        </div>
        <div class="btn-group">
            <button type="submit" class="btn btn-submit">保存</button>
            <a href="${pageContext.request.contextPath}/announcement/list" class="btn btn-cancel">取消</a>
        </div>
    </form>
</div>
</body>
</html>
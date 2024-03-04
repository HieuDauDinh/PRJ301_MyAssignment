<%-- 
    Document   : function
    Created on : Feb 29, 2024, 4:24:55 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FPT University Academic Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        header {
            text-align: center;
            margin-bottom: 20px;
        }
        header h1 {
            margin: 10px 0;
            font-size: 24px;
        }
        .btn-campus {
            background-color: #5cb85c;
            border: none;
            color: #fff;
            padding: 5px 10px;
            font-size: 12px;
            border-radius: 5px;
            margin-bottom: 10px;
        }
        .btn-campus:hover {
            cursor: pointer;
            background-color: #4cae4c;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
        }
        nav ul li {
            margin-bottom: 10px;
            background-color: #f9f9f9;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }
        nav ul li a {
            text-decoration: none;
            color: #333;
        }
        nav ul li a:hover {
            color: #5cb85c;
        }
        .lecturer-section {
            background-color: #f0f0f0;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        .lecturer-section h2 {
            margin-bottom: 10px;
            color: #5cb85c;
        }
        .lecturer-section ul {
            list-style-type: none;
            padding: 0;
        }
        .lecturer-section ul li {
            margin-bottom: 10px;
        }
        .lecturer-section ul li a {
            text-decoration: none;
            color: #333;
        }
        .lecturer-section ul li a:hover {
            color: #5cb85c;
        }
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1>FPT University Academic Portal</h1>
            <div class="d-flex justify-content-end d-flex align-items-start">
                <button type="button" class="btn btn-success h-15 pt-0 ms-1 me-5 mt-1"> CAMPUS: FPTU-Hòa Lạc </button></br>
                <input type="button" value="Home" class="btn btn-success h-15 pt-0 ms-1 me-5 mt-1" onclick="window.location.href ='Home.jsp'"/>
            </div>
        </header>
        <div class="row">
            <div class="mt-2">
                <div class="lecturer-section">
                    <h2>Lecturer Section</h2>                  
                    <c:set value="${sessionScope.acc}" var="acc"></c:set>
                    <ul>
                        <li><a href="weeklyTable">Weekly timetable </a>(Thời khóa biểu từng tuần)</li>
                        <li><a href="#" id="styleHref">Take Attendance</a> (Sửa điểm danh)</li>
                        <li><a href="#" id="styleHref">Attendance report </a> (Báo cáo điểm danh)</li>
                        <li><a href="#" id="styleHref">Mark Report</a> (Báo cáo điểm)</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

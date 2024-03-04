<%-- 
    Document   : inforSession
    Created on : Feb 29, 2024, 6:09:08 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4;
                color: #333;
                margin: 0;
                padding: 0;
            }

            .container {
                width: 80%;
                margin: 0 auto;
            }

            header {
                background-color: #007bff;
                color: #fff;
                text-align: center;
                padding: 20px 0;
            }

            .activity-detail {
                background-color: #fff;
                border: 1px solid #ddd;
                border-radius: 5px;
                margin: 20px 0;
                padding: 20px;
            }

            .activity-detail h2 {
                color: #007bff;
            }

            .activity-detail p {
                margin: 10px 0;
            }

            footer {
                background-color: #007bff;
                color: #fff;
                text-align: center;
                padding: 10px 0;
            }

            .activity-date {
                font-weight: bold;
            }

            

            
        </style>
    </head>
    <body>
        <h1>FPT University Academic Portal</h1>
        <a href="">Home</a> | <a href="">Activity</a> | View
        <h3>Activity detail</h3>

        <table class="container">
            <tbody class="activity-detail">
                <c:set value="${requestScope.session}" var="ses"></c:set>
                    <tr align="left" class="activity-date">
                        <td>Date:</td>
                        <td>${ses.date}</td>
                </tr>
                <tr align="left" class="activity-slot">
                    <td> Slot:</td>
                    <td>${ses.slotid.slot}</td>
                </tr>
                
                <tr align="left" class="activity-group">
                    <td>Student group:</td>
                    <td><a href="list?gid=${ses.gid.gid}">${ses.gid.gname}</a></td>
                </tr>
                <tr align="left" class="activity-instructor">
                    <td>Instructor:</td>
                    <td>${ses.lid.lname}</td>
                </tr>
                <tr align="left" class="activity-course">
                    <td>Course:</td>
                    <td>${ses.subid.subname}(${ses.subid.subid})</td>
                </tr>

            </tbody>
        </table>


    </body>
</html>

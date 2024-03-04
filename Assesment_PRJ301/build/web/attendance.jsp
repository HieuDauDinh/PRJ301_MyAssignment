<%-- 
    Document   : attendance
    Created on : Mar 2, 2024, 12:57:15 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

            /* Table styles */
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #007bff;
                color: #fff;
            }

            /* Alternate row colors for better readability */
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            /* Additional styles specific to certain elements if needed */
            .presented-yes {
                color: green;
                font-weight: bold;
            }

            .presented-no {
                color: red;
                font-weight: bold;
            }

            .note-yes {
                color: green;
                font-weight: bold;
            }

            .note-no {
                color: red;
                font-weight: bold;
            }

            /* Time column styling */
            .time-column {
                white-space: nowrap;
            }
        </style>
    </head>
    <body class="container">
        <h2>Attendance Table</h2>
        <table>
            <c:forEach items="${sessionScope.listAtt}" var="att">
                <tr>
                    <td>att.description</td>
                </tr>
            </c:forEach>
        </table>
        <form action="attended" method="POST">
            <input type="hidden" name="id" value="${param.id}" />
            <table border="1px">
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Presented</td>
                    <td>Note</td>
                    <td>Time</td>
                </tr>
                <c:forEach items="${requestScope.atts}" var="a">
                    <tr>
                        <td>${a.sid.stuid}</td>
                        <td>${a.sid.name}</td>
                        <td >
                            <input type="radio" 
                                   ${!a.isPresent?"checked=\"checked\"":""}
                                   name="present${a.sid.stuid}" value="no"/> No
                            <input type="radio" 
                                   ${a.isPresent?"checked=\"checked\"":""}
                                   name="present${a.sid.stuid}" value="yes"/> Yes
                        </td>
                        <c:forEach items="${sessionScope.listAtt}" var="att">
                            <td>${att.description}</td>
                        </c:forEach>
                        <td>
                            <input type="text" name="description${a.sid.stuid}" value="${a.description}"/>
                        </td>
                        <td class="time-column">${a.date}</td>
                    </tr>    
                </c:forEach>
            </table>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>

<%-- 
    Document   : list
    Created on : Feb 29, 2024, 9:43:47 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table, td, th {
                        border: 1px solid;
                    }
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

/* Image styling */
td img {
    max-width: 50px;
    max-height: 50px;
    border-radius: 50%;
}

/* Additional styles specific to certain elements if needed */
.member-code {
    font-weight: bold;
    color: #007bff;
}
    </style>
    <body class="container">
        <h1>${requestScope.group.gname} - ${requestScope.group.subid.subid}</h1>
        <h3>List of Student</h3>
            <table>
                <thead>
                    <tr>
                        <th>Index</th>
                        <th>Image</th>
                        <th >Member</th>
                        <th >Code</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.student}" var="s" varStatus="idex">
                    <tr>
                        <td>${idex.index+1}</td>
                        <td>
                <center>
                    <img src="" style="height:146px;width:111px;border-width:0px;">    
                </center>
                       </td>
                       <td style="text-align: center">${s.name}</td>
                       <td style="text-align: center" class="member-code">${s.stuid}</td>
        </tr>
    </c:forEach>
</tbody>
</table>
</body>
</html>

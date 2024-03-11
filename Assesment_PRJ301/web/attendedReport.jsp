<%-- 
    Document   : attendedReport
    Created on : Mar 4, 2024, 3:57:20 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <a href="loginc.jsp">Logout</a>
    <style>
            body {
                font-family: Arial, sans-serif;
            }

            .grade-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            .grade-table th, .grade-table td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            .grade-table th {
                background-color: #f2f2f2;
            }

            .grade-table tfoot td {
                font-weight: bold;
            }

            .grade-table tfoot tr:last-child td {
                border-top: 2px solid #333;
            }
        </style>
</head>
<body>
    <c:if test="${sessionScope.role == 1}">
        <table>
            <tbody>
                <tr>
                    <td>
                        <table>
                            <table>
                                <thead>
                                    <tr>
                                        <th>
                                            Course
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <div>
                                                <table>
                                                    <tbody>
                                                        <c:forEach items="${requestScope.group}" var="ses">
                                                            <tr>             
                                                                <td>
                                                                    <b><a href="report?id=${ses.gid.gid}&lid=${ses.gid.lid.lid}">${ses.gid.subid.subname}(${ses.gid.subid.subid})</a>(${ses.gid.gname})</b><br>
                                                                </td>                
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>

                                            </div>
                                        </td>
                                    </tr>
                                </tbody>

                            </table>
                        </table>
                    </td>
                    <td>
                        <table border="1px" class="grade-table">
                            <tbody>
                                <tr></tr>
                            </tbody>
                            <thead> 
                                <tr>
                                    <th>No.</th>
                                    <th>Date</th>
                                    <th>Slot</th>
                                    <th>Room</th>
                                    <th>Lecturer</th>
                                    <th>Group Name</th>
                                    <th>Attendance status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.list}" var="ses" varStatus="idex">
                                    <tr>
                                        <td>${idex.index+1}</td>
                                        <td>${ses.date}</td>
                                        <td>${ses.slotid.slotid} (${ses.tid.timeStart}-${ses.tid.timeEnd})</td>
                                        <td>${ses.rid.rname}</td>
                                        <td>${ses.lid.lname}</td>
                                        <td>${ses.gid.gname}</td>
                                        <td>
                                            <c:if test="${!ses.isTaken}">
                                                Not yet                                              
                                            </c:if>
                                            <c:if test="${ses.isTaken}">
                                                Attended
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>           

        </table>
    </c:if>

    <c:if test="${sessionScope.role == 0}">
        <table>
            <tbody>
                <tr>
                    <td>
                        <table>
                            <table>
                                <thead>
                                    <tr>
                                        <th>
                                            Course
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <div>
                                                <table>
                                                    <tbody>
                                                        <c:forEach items="${requestScope.listGroupStu}" var="ses">
                                                            <tr>             
                                                                <td>
                                                                    <b><a href="report?id=${ses.gid.gid}&sid=${sessionScope.idStu}">${ses.gid.subid.subname}(${ses.gid.subid.subid})</a>(${ses.gid.gname})</b><br>
                                                                </td>                
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>

                                            </div>
                                        </td>
                                    </tr>
                                </tbody>

                            </table>
                        </table>
                    </td>
                    <td>
                        <table border="1px" class="grade-table">
                            <tbody>
                                <tr></tr>
                            </tbody>
                            <thead> 
                                <tr>
                                    <th>No.</th>
                                    <th>Date</th>
                                    <th>Slot</th>
                                    <th>Room</th>
                                    <th>Lecturer</th>
                                    <th>Group Name</th>
                                    <th>Attendance status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.listAttStu}" var="ses" varStatus="idex">
                                    <tr>
                                        <td>${idex.index+1}</td>
                                        <td>${ses.date}</td>
                                        <td>${ses.slotid.slotid} (${ses.tid.timeStart}-${ses.tid.timeEnd})</td>
                                        <td>${ses.rid.rname}</td>
                                        <td>${ses.lid.lid}(${ses.lid.lname})</td>
                                        <td>${ses.gid.gname}</td>

                                        <td>
                                            <c:forEach items="${requestScope.atten}" var="att">
                                                <c:if test="${ses.seid == att.seid.seid}">
                                                    <c:if test="${att.isPresent}">
                                                        Attended
                                                    </c:if>
                                                    <c:if test="${!att.isPresent}">
                                                        <c:if test="${ses.isTaken}">
                                                            Absent
                                                        </c:if>
                                                        <c:if test="${!ses.isTaken}">
                                                            Not Yet
                                                        </c:if>
                                                    </c:if>
                                                </c:if>

                                            </c:forEach>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>           

        </table>
    </c:if>
</body>
</html>

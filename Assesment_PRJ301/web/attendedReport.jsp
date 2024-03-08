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
                        <table border="1px">
                            <tbody>
                                <tr></tr>
                            </tbody>
                            <thead> 
                                <tr>
                                    <th>No.</th>
                                    <th>Date</th>
                                    <th>Slot</th>
                                    <th>Room</th>
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
                        <table border="1px">
                            <tbody>
                                <tr></tr>
                            </tbody>
                            <thead> 
                                <tr>
                                    <th>No.</th>
                                    <th>Date</th>
                                    <th>Slot</th>
                                    <th>Room</th>
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
    </body>
</html>

<%-- 
    Document   : markReport
    Created on : Mar 8, 2024, 10:04:52 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <c:forEach items="${requestScope.listGrade}" var="gr">
            <c:set var="sum" value="${sum + (gr.score * gr.eid.aid.weight /100)}" />
        </c:forEach>


        <c:forEach items="${requestScope.listGrade}" var="gr">
            <c:if test="${gr.eid.aid.name eq 'Final Exam'}">
                <c:set var="fe" value="${gr.score}" />
                <c:set var="start" value="${gr.eid.start}" />
                <c:set var="end" value="${gr.eid.end}" />
            </c:if>
        </c:forEach>

        <table>
            <tbody>
                <tr>
                    <td>
                        <table>
                            <table>
                                <thead>
                                    <tr>
                                        <th>
                                            Grade Report for ${sessionScope.stu.stuid} (${sessionScope.stu.name})
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <div>
                                                <table>
                                                    <tbody>
                                                        <tr>  
                                                            <td>
                                                                <c:forEach items="${requestScope.semester}" var="semes">     
                                                                    <a href="showgrade?semesid=${semes.semID}&sid=${sessionScope.idStu}">${semes.semName}</a><br>
                                                                </c:forEach>
                                                            </td> 
                                                            <td>  
                                                                <c:forEach items="${requestScope.listGroupStu}" var="ses">
                                                                    <b><a href="showgrade?subid=${ses.gid.subid.subid}&sid=${sessionScope.idStu}">${ses.gid.subid.subname}(${ses.gid.subid.subid})</a>(${ses.gid.gname}, from ${end} / ${start})</b><br>                                   
                                                                </c:forEach>

                                                            </td> 
                                                        </tr>

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
                                    <th>Grade category</th>
                                    <th>Grade item</th>
                                    <th>Weight</th>
                                    <th>Value</th>
                                    <th>Comment</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <c:if test="${requestScope.listGrade != null}"> 
                                    <c:forEach items="${requestScope.listGrade}" var="gr">
                                        <tr>
                                            <td>${gr.eid.aid.name}</td>
                                            <td>${gr.eid.aid.name}</td>
                                            <td>${gr.eid.aid.weight}</td>
                                            <td>${gr.score}</td>
                                            <td>${gr.comment}</td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${requestScope.listGrade == null}"> 
                                    <c:forEach items="${requestScope.asses}" var="ass">
                                        <tr>
                                            <td>${ass.name}</td>
                                            <td>${ass.name}</td>
                                            <td>${ass.weight}</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td rowspan="2">Course total</td>
                                    <td>Average</td>
                                    <td colspan="3">${sum}</td>
                                </tr><br>
                            <tr>
                                <td>Total</td>
                                <td>Status</td>
                                <c:if test="${sum >= 5 and fe < 4}">
                                    <td colspan="3"><font color="Red">Not Passed</font></td>
                                    </c:if>
                                    <c:if test="${sum <= 5 and fe < 4}">
                                    <td colspan="3"><font color="Red">Not Passed</font></td>
                                    </c:if>

                                <c:if test="${sum >= 5 and fe >= 4}">
                                    <td colspan="3"><font color="Green">Passed</font></td>
                                    </c:if>
                                    <c:if test="${sum < 5 and fe >= 4}">
                                    <td colspan="3"><font color="Red">Not Passed</font></td>
                                    </c:if>
                                    <c:if test="${sum < 5 and fe < 4}">
                                    <td colspan="3"><font color="Red">Not Passed</font></td>
                                    </c:if>

                            </tr>
                            </tfoot>
                        </table>
                    </td>
                </tr>
            </tbody>           

        </table>
    </body>
</html>

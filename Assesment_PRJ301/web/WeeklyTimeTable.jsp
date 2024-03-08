
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
            <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
                <title>
                    FPT University Academic Portal
                </title>

                <style type="text/css">
                    .style1 {
                        font-weight: bold;
                    }

                    .label-success {
                        background-color: #5cb85c;
                    }
                    table, td, th {
                        border: 1px solid;
                    }
                    table {
                        width: 100%;
                        border-collapse: collapse;
                    }
                </style>
                </head>

                <body style="">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-8">
                                <h1><span>FPT University Academic Portal</span>
                                </h1>

                            </div>
                            <div class="col-md-4">

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <form method="post" action="weeklyTable">
                                    <ol class="breadcrumb">
                                        <li>
                                            <span id="ctl00_lblNavigation"><a href="Home.jsp">Home</a>&nbsp;|<a href="loginc.jsp">Logout</a>&nbsp;<b>View
                                                    Schedule</b></span>
                                        </li>
                                    </ol>
                                    <c:if test="${sessionScope.acc.role == 1}">
                                        <h1> Activities for ${sessionScope.lec.lid} (${sessionScope.lec.lname})</h1>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.role == 0}">
                                        <h1> Activities for ${sessionScope.stu.stuid} (${sessionScope.stu.name})</h1> 
                                    </c:if>
                                    <div>
                                        <title>
                                            FPT University Academic Portal
                                        </title>

                                        <p>
                                            <b>Note</b>: These activities do not include extra-curriculum activities, such as
                                            club activities ...
                                        </p>
                                        <p>
                                            <b>Chú thích</b>: Các hoạt động trong bảng dưới không bao gồm hoạt động ngoại khóa,
                                            ví dụ như hoạt động câu lạc bộ ...
                                        </p>
                                        <div id="ctl00_mainContent_ghichu">
                                            <p>
                                                Các phòng bắt đầu bằng AL thuộc tòa nhà Alpha. VD: AL...<br/>
                                                Các phòng bắt đầu bằng BE thuộc tòa nhà Beta. VD: BE,..<br/>
                                                Các phòng bắt đầu bằng G thuộc tòa nhà Gamma. VD: G201,...<br/>
                                                Các phòng tập bằng đầu bằng R thuộc khu vực sân tập Vovinam.<br/>
                                                Các phòng bắt đầu bằng DE thuộc tòa nhà Delta. VD: DE,..<br/>
                                                Little UK (LUK) thuộc tầng 5 tòa nhà Delta
                                            </p>
                                        </div>


                                        <table>
                                            <tr style="text-align: left">

                                                <th rowspan="2" style="width: 200px; background-color: blue;">
                                                    <span class="auto-style1"><strong>Year</strong></span>
                                                    <select name="year"
                                                            id="ctl00_mainContent_drpYear" onchange="this.form.submit()">
                                                        <option value="2020" ${requestScope.selectedYear == 2020 ? 'selected' : ''}>2020</option>
                                                        <option value="2021" ${requestScope.selectedYear == 2021 ? 'selected' : ''}>2021</option>
                                                        <option value="2022" ${requestScope.selectedYear == 2022 ? 'selected' : ''}>2022</option>
                                                        <option value="2023" ${requestScope.selectedYear == 2023 ? 'selected' : ''}>2023</option>
                                                        <option value="2024" ${requestScope.selectedYear == 2024 ? 'selected' : ''}>2024</option>
                                                    </select>
                                                    <br>

                                                        Week
                                                        <select name="DateRange"
                                                                id="ctl00_mainContent_drpSelectWeek" onchange="this.form.submit()">
                                                            <c:forEach items="${requestScope.listDayDT}" var="i">
                                                                <option value="${i.week}" ${i.week == requestScope.selectedWeek ? 'selected' : ''}>${i.content} </option>
                                                            </c:forEach>                                                      
                                                        </select>
                                                </th>
                                                <th style="width: 200px; background-color: blue;"align="center">Mon</th>
                                                <th style="width: 200px; background-color: blue;"align="center">Tue</th>
                                                <th style="width: 200px; background-color: blue;"align="center">Wed</th>
                                                <th style="width: 200px; background-color: blue;"align="center">Thu</th>
                                                <th style="width: 200px; background-color: blue;"align="center">Fri</th>
                                                <th style="width: 200px; background-color: blue;"align="center">Sat</th>
                                                <th style="width: 200px; background-color: blue;"align="center">Sun</th>
                                                <br/>

                                            </tr>
                                            <c:forEach items="${requestScope.dayweek}" var="i">
                                                <th style="width: 200px; background-color: blue;"align="center">${i.showDate()}</th>
                                                </c:forEach>   
                                                <c:forEach items="${requestScope.slot}" var="slot">
                                                <tr>
                                                    <td>${slot.slot}</td>
                                                    <c:forEach items="${requestScope.dayweek}" var="i">
                                                        <c:if test="${sessionScope.acc.role == 1}">

                                                            <td>

                                                                <c:forEach items="${requestScope.listSession}" var="les">

                                                                    <c:if test="${les.date eq i.formatDate() and les.slotid.slotid eq slot.slotid}">
                                                                        <div style="text-align: center" > <a href="inforSession?id=${les.seid}">${les.gid.subid.subid}</a> at  ${les.rid.rname}<br>
                                                                                <c:if test="${!les.isTaken}">
                                                                                    <font color="Red">(Not yet)</font> <br>
                                                                                        <span class="label label-success">(${les.tid.timeStart}-${les.tid.timeEnd})</span>

                                                                                    </c:if>
                                                                                    <c:if test="${les.isTaken}">
                                                                                        <font color="Green">(Attended)</font><br>
                                                                                            <span class="label label-success">(${les.tid.timeStart}-${les.tid.timeEnd})</span><br>
                                                                                            </c:if>
                                                                                            <a href="attended?id=${les.seid}">
                                                                                                <c:if test="${les.isTaken}">Edit</c:if>
                                                                                                <br><c:if test="${!les.isTaken}">Take</c:if>
                                                                                                </a>
                                                                                                </div>
                                                                                        </c:if>


                                                                                    </c:forEach>

                                                                                    </td>
                                                                                </c:if>
                                                                                <c:if test="${sessionScope.acc.role == 0}">
                                                                                    <td>
                                                                                        <c:forEach items="${requestScope.listSessionStu}" var="ses">

                                                                                            <c:if test="${ses.date eq i.formatDate() and ses.slotid.slotid eq slot.slotid}">
                                                                                                <div style="text-align: center" >
                                                                                                    <a href="inforSession?id=${ses.seid}">${ses.subid.subid}</a> at  ${ses.rid.rname}<br>
                                                                                                        <c:if test="${!ses.isTaken}">
                                                                                                            <font color="Red">(Not yet)</font> <br>
                                                                                                                <span class="label label-success">(${ses.tid.timeStart}-${ses.tid.timeEnd})</span>
                                                                                                            </c:if>
                                                                                                            <c:if test="${ses.isTaken}">
                                                                                                                <font color="Red">(Attended)</font> <br>
                                                                                                                    <span class="label label-success">(${ses.tid.timeStart}-${ses.tid.timeEnd})</span>
                                                                                                                </c:if>
                                                                                                                </div>
                                                                                                            </c:if>


                                                                                                        </c:forEach>
                                                                                                        </td>
                                                                                                    </c:if>
                                                                                                </c:forEach>   
                                                                                                </tr>
                                                                                            </c:forEach>
                                                                                            </table>                                                                               

                                                                                            <p>
                                                                                                <b>More note / Chú thích thêm</b>:
                                                                                            </p>
                                                                                            <div id="ctl00_mainContent_divfoot">
                                                                                                <ul>
                                                                                                    <li>(<font color="green">attended</font>): had attended
                                                                                                        this activity / đã tham gia hoạt động này</li>
                                                                                                    <li>(<font color="red">absent</font>):  had NOT attended
                                                                                                        this activity / đã vắng mặt buổi này</li>
                                                                                                    <li>(-): no data was given / chưa có dữ liệu</li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <p>
                                                                                            </p>
                                                                                            </div>
                                                                                            </form>
                                                                                            </div>
                                                                                            </div>
                                                                                            </div>
                                                                                            </body>
                                                                                            </html>

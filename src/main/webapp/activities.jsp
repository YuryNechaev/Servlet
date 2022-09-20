<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Activities</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-lg navbar-dark"
         style="background-color: dimgray">

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link" >Users</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">Activities</h3>
        <br>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/newActivity" class="btn btn-primary">Add
                New Activity </a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Student</th>
                <th>Activity</th>
                <th>Date</th>
                <th>Duration</th>
<%--                <th>Status</th>--%>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="activity" items="${listActivities}">

                <tr>
                    <td><c:out value="${activity.id}" /></td>
                    <td><c:out value="${activity.studentName}" /></td>
                    <td><c:out value="${activity.activityType}" /></td>
                    <td><c:out value="${activity.activityDate}" /></td>
                    <td><c:out value="${activity.prolongation}" /></td>
<%--                    <td><c:out value="${activity.status}" /></td>--%>
                    <td><c:if test="${activity.status.equals('valid')}">
                        <a href="editActivity?id=<c:out value='${activity.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteActivity?id=<c:out value='${activity.id}' />">Delete</a>
                    </c:if>
                        <c:if test="${!activity.status.equals('valid')}">
                                Submitted
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>
</html>

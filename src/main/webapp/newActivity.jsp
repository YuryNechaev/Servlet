<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add activity</title>
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
            <li><a href="<%=request.getContextPath()%>/activities"
                   class="nav-link" >Activities</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${activity != null}">
            <form action="updateActivity" method="post">
                </c:if>
                <c:if test="${activity == null}">
                <form action="insertActivity" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${activity != null}">
                                Edit your activity
                            </c:if>
                            <c:if test="${activity == null}">
                                Add your activity
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${activity != null}">
                        <input type="hidden" name="id" value="<c:out value='${activity.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Student name</label> <input type="text"
                                                        value="<c:out value='${activity.studentName}' />" class="form-control"
                                                        name="studentName" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Type of activity</label> <input type="text"
                                                         value="<c:out value='${activity.activityType}' />" class="form-control"
                                                         name="activityType">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Date</label> <input type="text"
                                                           value="<c:out value='${activity.activityDate}' />" class="form-control"
                                                           name="activityDate">
                    </fieldset>
                        <fieldset class="form-group">
                            <label>Prolongation</label> <input type="text"
                                                       value="<c:out value='${activity.prolongation}' />" class="form-control"
                                                       name="prolongation">
                        </fieldset>

                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>

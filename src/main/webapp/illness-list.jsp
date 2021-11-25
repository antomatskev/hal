<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HAL project SICK LEAVE</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: lightskyblue">
        <div class="navbar-header">
            <a href="/hal" class="navbar-brand">
                <img width="20%"
                     src="https://www.haigekassa.ee/sites/default/files/symboolika/hk_eng_cmyk.jpg"></a>
        </div>

        <ul class="nav navbar-nav">
            <li><a href="<%=request.getContextPath()%>/listPerson"
                   class="nav-link">Persons</a></li>
            <li><a href="<%=request.getContextPath()%>/listSL"
                   class="nav-link">Sick leaves</a></li>
            <li><a href="<%=request.getContextPath()%>/listPayment"
                   class="nav-link">Payments</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Sick Leaves</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/newSL" class="btn btn-success">Add New Sick Leave</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Person ID</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Diagnosis</th>
                <th>Medical doctor</th>
                <th>Notes</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty slList}">
                <tr>No records in Sick Leaves table.</tr>
            </c:if>
            <c:forEach var="payment" items="${slList}">
                <tr>
                    <td><c:out value="${payment.id}"/></td>
                    <td><c:out value="${payment.personId}"/></td>
                    <td><c:out value="${payment.startDate}"/></td>
                    <td><c:out value="${payment.endDate}"/></td>
                    <td><c:out value="${payment.diagnosis}"/></td>
                    <td><c:out value="${payment.medicalDoctor}"/></td>
                    <td><c:out value="${payment.notes}"/></td>
                    <td><a href="editSL?id=<c:out value='${payment.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="deleteSL?id=<c:out value='${payment.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
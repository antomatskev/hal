<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HAL project PERSON</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: lightseagreen">
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
        <h3 class="text-center">List of Persons</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/newPerson" class="btn btn-success">Add New Person</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Personal Code</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Address</th>
                <th>Email</th>
                <th>Bank Account</th>
                <th>Insurance</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty personList}">
                <tr>No records in Person table.</tr>
            </c:if>
            <c:forEach var="payment" items="${personList}">
                <tr>
                    <td><c:out value="${payment.id}"/></td>
                    <td><c:out value="${payment.personalCode}"/></td>
                    <td><c:out value="${payment.firstName}"/></td>
                    <td><c:out value="${payment.lastName}"/></td>
                    <td><c:out value="${payment.address}"/></td>
                    <td><c:out value="${payment.email}"/></td>
                    <td><c:out value="${payment.bankAccount}"/></td>
                    <td><c:out value="${payment.insurance}"/></td>
                    <td><a href="editPerson?id=<c:out value='${payment.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="deletePerson?id=<c:out value='${payment.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
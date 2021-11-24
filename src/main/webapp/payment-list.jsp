<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HAL project PAYMENT</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: gold">
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
        <h3 class="text-center">List of Payments</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/newPayment" class="btn btn-success">Add New Payment</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Person ID</th>
                <th>Income</th>
                <th>Sum</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty paymentList}">
                <tr>Check your Database connection!</tr>
            </c:if>
            <c:forEach var="payment" items="${paymentList}">
                <tr>
                    <td><c:out value="${payment.id}"/></td>
                    <td><c:out value="${payment.personId}"/></td>
                    <td><c:out value="${payment.income}"/></td>
                    <td><c:out value="${payment.sum}"/></td>
                    <td><c:out value="${payment.status}"/></td>
                    <td><a href="editPayment?id=<c:out value='${payment.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="deletePayment?id=<c:out value='${payment.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HAL project</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: lightskyblue">
        <div class="navbar-brand">
            <a href="/hal" class="navbar-brand">
                <img width="20%"
                     src="https://www.haigekassa.ee/sites/default/files/symboolika/hk_eng_cmyk.jpg">
            </a>
        </div>

        <ul class="navbar-nav">
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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${illness != null}">
            <form action="updateSL" method="post">
                </c:if>
                <c:if test="${illness == null}">
                <form action="insertSL" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${illness != null}">
                                Edit Sick Leave
                            </c:if>
                            <c:if test="${illness == null}">
                                Add New Sick Leave
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${illness != null}">
                        <input type="hidden" name="id" value="<c:out value='${illness.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Person ID</label> <input type="number"
                                                        value="<c:out value='${illness.personId}' />"
                                                        class="form-control"
                                                        name="personId" required="required">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Start date</label> <input type="text"
                                                         value="<c:out value='${illness.startDate}' />"
                                                         class="form-control"
                                                         name="startDate" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>End date</label> <input type="text"
                                                       value="<c:out value='${illness.endDate}' />"
                                                       class="form-control"
                                                       name="endDate" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Diagnosis</label> <input type="text"
                                                        value="<c:out value='${illness.diagnosis}' />"
                                                        class="form-control"
                                                        name="diagnosis">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Medical doctor</label> <input type="text"
                                                             value="<c:out value='${illness.medicalDoctor}' />"
                                                             class="form-control"
                                                             name="medicalDoctor">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Notes</label> <input type="text"
                                                    value="<c:out value='${illness.notes}' />"
                                                    class="form-control"
                                                    name="notes">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
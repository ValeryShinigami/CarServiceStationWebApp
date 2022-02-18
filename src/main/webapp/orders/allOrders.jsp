<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>All orders</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>History of all orders</h2>
        <a href="./add-order" class="btn btn-success rounded-0 text-light m-1">Add order</a>
        <h4>${noOrdersError}</h4> <h4>${deleteMessage}</h4> <h4>${updateMessage}</h4> <h4>${noDataError}</h4>
        <table class="table table-hover">
            <thead>
            <th class="active">No</th>
            <th class="active">Assigned employee</th>
            <th class="active">Vehicle</th>
            <th class="active">Customer name</th>
            <th class="active">Status</th>
            <th class="active">Actions</th>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order" varStatus="count">
                <tr>
                    <td>${count.count}</td>
                    <td>${order.employee.firstName} ${order.employee.lastName}</td>
                    <td>${order.vehicle.model} ${order.vehicle.brand}</td>
                    <td>${order.vehicle.customer.firstName} ${order.vehicle.customer.lastName}</td>
                    <td>${order.status.name}</td>
                    <td>
                        <a href="./detailed-order?orderId=${order.id}"
                           class="btn btn-info rounded-0 text-light m-1">Details</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
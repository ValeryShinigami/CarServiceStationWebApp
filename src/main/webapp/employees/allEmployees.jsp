<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Employees</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>List of employees</h2>
        <h4>
            <form action="./search-employees" method="get">
                Search for employee by his last name:<br>
                <input type="text" name="lastName" placeholder="enter employee's last name">
                <input type="submit" value="Search">
            </form>
        </h4>
        <!-- add-customer c'est pour la servlet il s'agit de l'url de la servlet -->
        <a href="./add-employee" class="btn btn-success rounded-0 text-light m-1">Add employee</a>
        <h4>${noCustomersError}</h4> <h4>${deleteMessage}</h4>
        <table class="table table-hover">
            <thead>
            <th class="active">No</th>
            <th class="active">First name</th>
            <th class="active">Last name</th>
            <th class="active">Adress</th>
            <th class="active">Phone Number</th>
             <th class="active">Remarks</th>
              <th class="active">Hourly Rate</th>
            </thead>
            <tbody>
            
             <!-- on boucle sur la liste des consommateurs-->
            <c:forEach items="${employees}" var="employee" varStatus="count">
                <tr>
                <!-- ${objet.attribut}-->
                    <td>${count.count}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.address}</td>
                    <td>${employee.phoneNumber}</td>
                    <td>${employee.remarks}</td>
                    <td>${employee.hourlyRate}</td>
                    <td>
                        <a href="./update-employee?id=${employee.id}"
                           class="btn btn-warning rounded-0 text-light m-1">Update</a>
                        <a href="./delete-employee?id=${employee.id}"
                           class="btn btn-danger rounded-0 text-light m-1">Delete</a>
                        <a href="./orders-of-employee?id=${employee.id}" class="btn btn-info rounded-0 text-light m-1">Show
                            orders</a>
                        <a href="./vehicles-of-employee?id=${employee.id}" class="btn btn-info rounded-0 text-light m-1">Show
                            vehicles</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: sanu
  Date: 2023-07-24
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <meta content="width=device-width initial-scale=1" name="viewport">
    <link crossorigin="anonymous" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" rel="stylesheet">
    <style>
        ul > li {
            cursor: pointer;
        }
    </style>
</head>
<body>

<!--header-->
<header class="jumbotron bg-primary text-white p-3">
    <h1 class="position-absolute" id="nav"></h1>
    <ul class="list-group list-group-horizontal text-danger justify-content-end font-weight-bold">
        <li class="list-group-item bg-danger text-white" id="lnkHome"><a class="text-white" href="index.jsp">Home</a></li>
        <li class="list-group-item bg-white" id="lnkCustomer"><a href="pages/customer.html">Customer</a></li>
        <li class="list-group-item bg-white" id="lnkItem"><a href="pages/item.html">Item</a></li>
        <li class="list-group-item bg-white" id="lnkOrders"><a href="pages/purchase-order.html">Orders</a></li>
    </ul>
</header>

</body>
</html>


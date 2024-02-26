<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <style>
        .button-container {
            text-align: center; /* Align buttons to the center */
        }

        .button-container form {
            display: inline-block; /* Make forms display inline */
            margin: 0 10px; /* Add some spacing between buttons */
        }

        /* Position the button container to top right */
        .top-right {
            position: absolute;
            top: 0;
            right: 0;
            padding: 10px; /* Add padding for spacing */
        }
    </style>
</head>
<body>
<div class="top-right">
    <!-- Add your button here -->
    <form action="/restaurant/add">
        <input type="submit" value="Add New Restaurant">
    </form>
</div>

<div class="button-container">
    <form action="/restaurant/view">
        <input type="submit" value="View Restaurants">
    </form>
    <form action="/item/view">
        <input type="submit" value="View Items">
    </form>
</div><br>
<br>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Location</th>
        <th>Add New Item</th>
        <th>Add Exist Item</th>
        <th>View Items</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="restaurant" items="${restaurants}">
        <tr>
            <td><c:out value="${restaurant.getName()}"/></td>
            <td><c:out value="${restaurant.getType()}"/></td>
            <td><c:out value="${restaurant.getLocation()}"/></td>
            <td>
                <form action="/restaurant/addNewItem">
                    <input type="hidden" name="restaurantId" value="${restaurant.getRestaurantID()}">
                    <input type="submit" value="Add New">
                </form>
            </td>
            <td>
                <form action="/restaurant/addExistItem">
                    <input type="hidden" name="restaurantId" value="${restaurant.getRestaurantID()}">
                    <input type="submit" value="Add Exist">
                </form>
            </td>
            <td>
                <form action="/restaurant/viewItems">
                    <input type="hidden" name="restaurantId" value="${restaurant.getRestaurantID()}">
                    <input type="submit" value="View">
                </form>
            </td>
            <td>
                <form action="/restaurant/update">
                    <input type="hidden" name="restaurantId" value="${restaurant.getRestaurantID()}">
                    <input type="submit" value="update">
                </form>
            </td>
            <td>
                <form action="/restaurant/delete">
                    <input type="hidden" name="restaurantId" value="${restaurant.getRestaurantID()}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

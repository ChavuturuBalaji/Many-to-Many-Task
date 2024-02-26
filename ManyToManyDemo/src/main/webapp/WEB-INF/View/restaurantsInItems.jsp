<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .button-container {
            text-align: center;
        }

        .button-container form {
            display: inline-block;
            margin: 0 10px;
        }
    </style>
</head>
<body>
<div class="button-container">
    <form action="/restaurant/view">
        <input type="submit" value="View Restaurants">
    </form>
    <form action="/item/view">
        <input type="submit" value="View Items">
    </form>

</div>
<br>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Location</th>
        <th>Remove Restaurant</th>
    </tr>
    <c:forEach var="restaurant" items="${restaurants}">
        <tr>
            <td><c:out value="${restaurant.getName()}"/></td>
            <td><c:out value="${restaurant.getType()}"/></td>
            <td><c:out value="${restaurant.getLocation()}"/></td>
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

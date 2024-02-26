<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

</head>
<body>
<!DOCTYPE html>

<style>
    .button-container {
        text-align: center;
    }

    .button-container form {
        display: inline-block;
        margin: 0 10px;
    }
</style>
<div class="button-container">
    <form action="/restaurant/view">
        <input type="submit" value="View Restaurants">
    </form>
    <form action="/item/view">
        <input type="submit" value="View Items">
    </form>
</div>

<form:form modelAttribute="restaurantModel" action="/restaurant/updated">
    <table>
        <tr>
            <td>Restaurant ID</td>
            <td><form:input path="restaurantID" readonly="true"/></td>
        </tr>
        <tr>
            <td>Restaurant Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Type</td>
            <td><form:input path="type"/></td>
        </tr>
        <tr>
            <td>Location</td>
            <td><form:input path="location"/></td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form:form>


</body>
</html>

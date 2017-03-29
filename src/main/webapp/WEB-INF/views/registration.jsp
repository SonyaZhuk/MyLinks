<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>
<body>


<div class="container">

    <form method="POST" action="${contextPath}/registrationuser" class="form-signin">

        <h2 class="form-heading">Registration form</h2>

        <div>

            <input name="firstname" type="text" class="form-control" placeholder="Firstname" autofocus="true"/>

            <input name="surname" type="text" class="form-control" placeholder="Surname"/>

            <input name="username" type="text" class="form-control" placeholder="Username"/>

            <input name="password" type="password" class="form-control" placeholder="Password"/>

            <input name="email" type="text" class="form-control" placeholder="Email"/>

            <input name="age" type="text" class="form-control" placeholder="Age"/>

            <input name="city" type="text" class="form-control" placeholder="City"/>

            <input name="photo" type="text" class="form-control" placeholder="Photo"/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Registration</button>

        </div>

    </form>

</div>

</body>
</html>
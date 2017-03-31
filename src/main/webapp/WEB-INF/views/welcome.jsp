<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/welcomestyle.css" rel="stylesheet">

</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <form class="user-form">
            <div>
                <%--<img src=""> ${currentUser.photo}</img>--%>
                </br>
                </br>
                <h3> ${currentUser.firstname}   ${currentUser.surname}</h3>
                <c:if test="${currentUser.age != 0}">
                   <h4>Age: ${currentUser.age}</h4>
                </c:if>
                <c:if test="${currentUser.city != ''}">
                   <h4>City: ${currentUser.city}</h4>
                </c:if>
            </div>
        </form>
        </br>

        <form class="search-form">
            <button type="submit" class="btn btn-lg btn-primary">Display all links</button>
            <div class="search-scope">
                <label>Search only in my content</label>
                <input type="checkbox">
            </div>
            <div>
                <input type="search" class="input search" placeholder="Search" onkeypress="search()" />
            </div>
        </form><hr/>


        </br>
        <div class="logout">
        <h3><a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </div>

    </c:if>

</div>

</body>
</html>

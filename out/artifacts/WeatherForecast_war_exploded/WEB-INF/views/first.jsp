<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form method="post" modelAttribute="cityName" action="">

    City Name: <spring:input path="cityName"/>
    <br/>
    <spring:button>Proceed</spring:button>

</spring:form>
</body>
</html>

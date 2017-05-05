<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <spring:url value="/resources/css/project.css" var="projectCss" />

    <link href="${projectCss}" rel="stylesheet" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Person View Page</title>
</head>
<body>
    <form:form method="post" modelAttribute="person" action="/person/save">
        <spring:bind path="name">
            <label><b>Name: </b></label>
            <form:input path="name" type="text" id="name" value=""/><br>
            <label><b>Last Name: </b></label>
            <form:input path="lastName" type="text" id="lastName" value=""/><br>
            <label><b>Age: </b></label>
            <form:input path="age" type="text" id="age" value=""/><br>
            <label><b>Salary: </b></label>
            <form:input path="salary" type="text" id="salary" value=""/><br>
        </spring:bind>
        <button type="submit">Submit</button>
    </form:form>
</body>
</html>
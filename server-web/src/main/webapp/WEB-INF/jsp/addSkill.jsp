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
    <form:form method="post" modelAttribute="skill" action="/skill/update/${personID}">
        <spring:bind path="skill">
            <label><b>Language: </b></label>
            <form:input path="language" type="text" id="language" value=""/><br>
            <label><b>Level: </b></label>
            <form:input path="level" type="text" id="level" value=""/><br>
        </spring:bind>
        <button type="submit">Submit</button>
    </form:form>
</body>
</html>
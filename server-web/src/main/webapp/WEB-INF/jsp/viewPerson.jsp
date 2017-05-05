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
    <form:form method="post" modelAttribute="person" action="/person/update">
        <form:hidden path="id" />
        <spring:bind path="name">
            <label><b>Name: </b></label>
            <form:input path="name" type="text" id="name" value="${person.name}"/><br>
            <label><b>Last Name: </b></label>
            <form:input path="lastName" type="text" id="lastName" value="${person.lastName}"/><br>
            <label><b>Age: </b></label>
            <form:input path="age" type="text" id="age" value="${person.age}"/><br>
            <label><b>Salary: </b></label>
            <form:input path="salary" type="text" id="salary" value="${person.salary}"/><br>
            <label><b>Skills: </b></label><br>
            <c:forEach var="skill" items="${person.skills}" varStatus="status">
                <form:input readonly="readonly" path="skills[${status.index}].language" name="language" id="language" value="${skill.language}" /> -
                <form:input readonly="readonly" path="skills[${status.index}].level" name="level" id="level" value="${skill.level}" /><br>
            </c:forEach>
        </spring:bind>
        <a href="/skill/add/${person.id}">Add Skill</a>
        <button type="submit">Submit</button>
    </form:form>
</body>
</html>
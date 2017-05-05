<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <spring:url value="/resources/css/project.css" var="projectCss" />

    <link href="${projectCss}" rel="stylesheet" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Home Page</title>
</head>
<body>
    <div>
        <table>
            <tr>
                <th></th>
                <th></th>
                <th>Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Salary</th>
                <th>Skill</th>
                <th>Level</th>
            </tr>
            <c:forEach var="person" items="${persons}">
                <c:set var="skillSize" value="${fn:length(person.skills)}"/>
                <c:choose>
                    <c:when test="${skillSize gt 0}">
                        <tr>
                            <td rowspan="${skillSize}"><a href="/person/edit/${person.id}">Edit</a></td>
                            <td rowspan="${skillSize}"><a href="/person/delete/${person.id}" onclick="return confirm('Are you sure?')">Delete</a></td>
                            <td rowspan="${skillSize}">${person.name}</td>
                            <td rowspan="${skillSize}">${person.lastName}</td>
                            <td rowspan="${skillSize}">${person.age}</td>
                            <td rowspan="${skillSize}">${person.salary}</td>
                            <td>${person.skills[0].language}</td>
                            <td>${person.skills[0].level}</td>
                        </tr>
                        <c:forEach var="skill" items="${person.skills}" begin="1">
                            <tr>
                                <td>${skill.language}</td>
                                <td>${skill.level}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                         <tr>
                             <td><a href="/person/edit/${person.id}">Edit</a></td>
                             <td><a href="/person/delete/${person.id}" onclick="return confirm('Are you sure?')">Delete</a></td>
                             <td>${person.name}</td>
                             <td>${person.lastName}</td>
                             <td>${person.age}</td>
                             <td>${person.salary}</td>
                             <td>---</td>
                             <td>---</td>
                         </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </table>
        <form action="/person/new" method="post">
            <input type="submit" value="Add new" />
        </form>
    </div>
</body>

</html>